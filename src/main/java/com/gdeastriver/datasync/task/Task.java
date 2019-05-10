package com.gdeastriver.datasync.task;

import com.gdeastriver.datasync.pojo.*;
import com.gdeastriver.datasync.service.*;
import com.gdeastriver.datasync.util.SyncDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 15:21
 * Modified:
 */
@Component
public class Task {

    @Value(value = "${enterprise.code}")
    private String eCode;

    @Value(value = "${enterprise.serverurl}")
    private String serverUrl;

    @Autowired
    private ClocksService clocksService;

    @Autowired
    private DepartsService departsService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MealRecordService mealRecordService;

    @Autowired
    private SyncSignService syncSignService;

    /**
     * 定时同步数据思路
     * 1：少量且没有自增长id的数据，先删除服务端所有的该企业下对应数据，再同步所有新数据到服务端
     * 2：消费记录，本地建立一个记号表，每次更新完成后把自增长的值记下来，
     *    下次同步从自增长的值到现有数据库最大的自增长值区间就是要同步的数据
     */

//    @Scheduled(cron="0 0 */2 * * ?")   //每隔2小时执行一次
    @Scheduled(cron="0 */1 * * * ?")   //每1分钟执行一次
    public void syncClockData() throws InterruptedException {

        System.out.println("------------准备同步[设备]数据...-------------");

        int serverClockCount = SyncDataUtil.getServerTerminalCount(serverUrl,eCode);
        int localClockCount = clocksService.countAll();

        if(localClockCount == 0 || serverClockCount == localClockCount){
            System.out.println("------------没有需要同步的[设备]数据-------------");
            return ;
        }

        Thread.sleep(500);

        int removeResult = SyncDataUtil.removeServiceClock(serverUrl,eCode);
        if(removeResult == -1){
            return ;
        }

        Thread.sleep(500);

        List<Clocks> list = clocksService.selectAll();
        for(int i=0;i<list.size();i++){
            Clocks clocks = list.get(i);
            int result = SyncDataUtil.addClock(serverUrl,eCode,clocks);
            //Thread.sleep(500);
            if(result == -1){
                continue;
            }
        }

        System.out.println("----------[设备]数据同步完成！！！----------");
    }

    //    @Scheduled(cron="0 0 */2 * * ?")   //每隔2小时执行一次
    @Scheduled(cron="0 */1 * * * ?")   //每1分钟执行一次
    public void syncDepartsData() throws InterruptedException {

        System.out.println("------------准备同步[部门]数据...-------------");

        int serverClockCount = SyncDataUtil.getServerDepartsCount(serverUrl,eCode);
        int localClockCount = departsService.countAll();

        if(localClockCount == 0 || serverClockCount == localClockCount){
            System.out.println("------------没有需要同步的[部门]数据-------------");
            return ;
        }

        Thread.sleep(500);

        int removeResult = SyncDataUtil.removeServiceDeparts(serverUrl,eCode);
        if(removeResult == -1){
            return ;
        }

        Thread.sleep(500);

        List<Departs> list = departsService.selectAll();
        for(int i=0;i<list.size();i++){
            Departs departs = list.get(i);
            int result = SyncDataUtil.addDepart(serverUrl,eCode,departs);
            //Thread.sleep(500);
            if(result == -1){
                continue;
            }
        }

        System.out.println("----------[部门]数据同步完成！！！----------");
    }

//    @Scheduled(cron="0 0 */2 * * ?")   //每隔2小时执行一次
    @Scheduled(cron="0 */1 * * * ?")   //每1分钟执行一次
    public void syncEmployeeData() throws InterruptedException {

        System.out.println("------------准备同步[员工]数据...-------------");

        int serverClockCount = SyncDataUtil.getServerEmployeeCount(serverUrl,eCode);
        int localClockCount = employeeService.countAll();

        if(localClockCount == 0 || serverClockCount == localClockCount){
            System.out.println("------------没有需要同步的[员工]数据-------------");
            return ;
        }

        Thread.sleep(500);

        int removeResult = SyncDataUtil.removeServiceEmployee(serverUrl,eCode);
        if(removeResult == -1){
            return ;
        }

        Thread.sleep(500);

        List<Employee> list = employeeService.selectAll();
        for(int i=0;i<list.size();i++){
            Employee employee = list.get(i);
            int result = SyncDataUtil.addEmployee(serverUrl,eCode,employee);
            //Thread.sleep(500);
            if(result == -1){
                continue;
            }
        }

        System.out.println("----------[员工]数据同步完成！！！----------");
    }

    @Scheduled(cron="0 */1 * * * ?")   //每1分钟执行一次
    public void syncConsumeData() throws InterruptedException {

        System.out.println("------------准备同步[消费记录]数据...-------------");

        int start = syncSignService.getSyncSign().getSignConsume();
        int end = mealRecordService.getMaxNRecSeq();

        if(end == 0 || start == end){
            System.out.println("------------没有需要同步的[消费记录]数据-------------");
            return ;
        }

        Thread.sleep(500);

        Map<String,Object> map = new HashMap<>();
        map.put("start",start+1);
        map.put("end",end);
        List<MealRecords> list = mealRecordService.selectListByCondition(map);

        /**
         * 同步成功，并发送模板消息成功
         */
        int successCount = 0;
        /**
         * 同步成功，但是发送模板消息失败
         */
        int failureCount = 0;
        /**
         * 同步成功，用户未关注公众号
         */
        int unconcerned = 0;
        for(int i=0;i<list.size();i++){
            MealRecords mealRecords = list.get(i);
            int result = SyncDataUtil.addMealRecord(serverUrl,eCode,mealRecords);
            //Thread.sleep(500);
            if(result == 100){
                successCount++;
            }
            if(result == 101){
                failureCount++;
            }
            if(result == 0){
                unconcerned++;
            }
        }

        /**
         * 更新标记位置
         */
        SyncSign syncSign = new SyncSign();
        syncSign.setId(1);
        syncSign.setSignConsume(end);
        this.syncSignService.updateSyncSign(syncSign);

        System.out.println(" ");
        System.out.println("----------------------------------------------");
        System.out.println("[员工]数据同步完成！！！");
        System.out.println("同步成功，并发送模板消息成功的数量有："+successCount);
        System.out.println("同步成功，但是发送模板消息失败的数量有："+failureCount);
        System.out.println("同步成功，用户未关注公众号的数量有："+unconcerned);
        System.out.println("----------------------------------------------");
        System.out.println(" ");
    }
}
