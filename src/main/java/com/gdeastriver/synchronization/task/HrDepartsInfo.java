package com.gdeastriver.synchronization.task;

import com.gdeastriver.synchronization.pojo.HrDeparts;
import com.gdeastriver.synchronization.service.HrDepartsService;
import com.gdeastriver.synchronization.service.impl.HrDepartsServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 17:15
 * Modified:
 */
@Component
public class HrDepartsInfo {
    @Autowired
    private HrDepartsServiceImpl hrDepartsServiceImpl;

    //@Scheduled(cron="*/20 * * * * ?")   //每10秒钟执行一次
    public void syncHrDepartsData()  {

     List <HrDeparts> hrDepList= hrDepartsServiceImpl.selectAll();
        if(hrDepList!=null){
            for(int i=0;i<hrDepList.size();i++){
                HrDeparts hrDep=hrDepList.get(i);
               String paraData=  hrDep.getRecords();
                JSONObject jsonObject  = JSONObject.fromObject(paraData);
                String recordsJson = jsonObject.get("records").toString();
                //1.把字符串类型的json数组对象转化JSONArray
                JSONArray paramData = JSONArray.fromObject(recordsJson);
              //2循环遍历这个数组
                for(int j=0;j<paramData.size();j++) {
                    //3、把里面的对象转化为JSONObject
                    JSONObject job = paramData.getJSONObject(j);
                    // 4、把里面想要的参数一个个用.属性名的方式获取到
                    String sdeptno=job.get("deptno").toString();//获取部门编号
                    String sdeptname=job.get("deptname").toString(); //部门名称
                    String sparentdeptno=job.get("parentdeptno").toString(); //父部门编号
                    System.out.println("部门编号："+sdeptno+",部门名称:"+sdeptname+",父部门编号:"+sparentdeptno);
                }



            }
        }
    }
}
