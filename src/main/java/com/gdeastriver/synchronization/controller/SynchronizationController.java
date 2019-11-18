package com.gdeastriver.synchronization.controller;

import com.gdeastriver.synchronization.enums.InfoEnum;

import com.gdeastriver.synchronization.pojo.HrDeparts;
import com.gdeastriver.synchronization.pojo.HrEmployee;
import com.gdeastriver.synchronization.pojo.SyncSign;
import com.gdeastriver.synchronization.pojo.TimeRecords;
import com.gdeastriver.synchronization.service.HrDepartsService;
import com.gdeastriver.synchronization.service.HrEmployeeService;
import com.gdeastriver.synchronization.service.SyncSignService;

import com.gdeastriver.synchronization.service.TimeRecordsService;
import com.alibaba.fastjson.JSON;
import com.gdeastriver.synchronization.util.MyConfig;
import com.gdeastriver.synchronization.util.httpPostJson;
import com.gdeastriver.synchronization.util.zadan;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.gdeastriver.synchronization.util.Ascii.putPairsSequenceAndTogether;


/**
 * Description:
 * User: Ellison
 * Date: 2019-08-13
 * Time: 14:39
 * Modified:
 */

@RestController
@RequestMapping(value = "/synchroni",produces = "application/json;charset=utf-8")
public class SynchronizationController {
    @Autowired
    private HrEmployeeService hremployeeService;
    @Autowired
    private HrDepartsService hrDepartsService;
    @Autowired
    private SyncSignService syncSignService;
    @Autowired
    private TimeRecordsService timeRecordsService;

/**
 * 部门资料同步接口
 * @param paraData
 * @return
 */

@PostMapping(value = "/HrDeparts")
public JSONObject HrDeparts(@RequestBody String paraData) {
    int emp=0;
    String re=zadan.zha();
    if (re=="0") {
        JSONObject signMap = new JSONObject();
        signMap.put("resultcode", "-1");
        signMap.put("resultmsg", "key，失败！");
        return signMap;
    }

    JSONObject signMap = new JSONObject();
    if (paraData == null || "".equals(paraData)) {
        System.out.println("没有数据");
        signMap.put("resultcode", "-1");
        signMap.put("resultmsg", "失败");
        return signMap;
    }
    //解析数据
    JSONObject jsonObject = JSONObject.fromObject(paraData);
    if(jsonObject.size()==0){
        System.out.println("传入参数不匹配！");
        signMap.put("resultcode", "0000");
        signMap.put("resultmsg", "传入参数不匹配！");
        return signMap;
    }
    String versionid = jsonObject.get("versionid").toString();//服务版本
    String timestamp = jsonObject.get("timestamp").toString(); //时间戳
    String mac = jsonObject.get("md5").toString();//mac
    signMap.put("versionid",versionid);
    signMap.put("timestamp",timestamp);
    String  asciiParam= putPairsSequenceAndTogether(signMap);//MAC值验证
    if(asciiParam.equals(mac)) {
        String records = jsonObject.get("records").toString();//部门资料
        //1.把字符串类型的json数组对象转化JSONArray
        JSONArray paramData = JSONArray.fromObject(records);
        //2循环遍历这个数组
        for (int j = 0; j < paramData.size(); j++) {
            //3、把里面的对象转化为JSONObject
            JSONObject job = paramData.getJSONObject(j);
            if(job.size()==0){
                System.out.println("同步部门成功！"+emp);
                signMap.put("resultcode", "0000");
                signMap.put("resultmsg", "成功");
                return signMap;
            }
            // 4、把里面想要的参数一个个用.属性名的方式获取到
            int optype = (int) job.get("optype");//操作类型

            String deptno = job.get("deptno").toString();//部门编号
            String deptname = job.get("deptname").toString();//部门名称
            String parentdeptno = job.get("parentdeptno").toString();//父部门编号
            String parentdeptname = job.get("parentdeptname").toString();//父部门名称
            String olddeptno = job.get("olddeptno").toString();//原部门编号
            String olddeptname = job.get("olddeptname").toString();//原部门名称

            //将分析的数据赋值
            HrDeparts hrDeparts = new HrDeparts();
            String uid = UUID.randomUUID().toString().replaceAll("-", "");
            hrDeparts.setUuid(uid);
            hrDeparts.setVersionid(versionid);
            hrDeparts.setTimestamps(timestamp);
            hrDeparts.setRecords(records);
            hrDeparts.setDeptno(deptno);
            hrDeparts.setDeptname(deptname);
            hrDeparts.setParentdeptno(parentdeptno);
            hrDeparts.setParentdeptname(parentdeptname);
            hrDeparts.setOlddeptno(olddeptno);
            hrDeparts.setOlddeptname(olddeptname);
            hrDeparts.setOptype(optype);
            hrDeparts.setState(0);
            int ret = hrDepartsService.insertJsonString(hrDeparts);
            emp=ret;
            if (ret < 0) {
                signMap.put("resultcode", "0");
                signMap.put("resultmsg", "失败");
                return signMap;
            }

        }
        try {
            //调用存储过程
            hrDepartsService.pInsertAll();
        }

       /*String exec=
        if(exec==null){

        }*/
        catch (Exception ex) {

        }
        System.out.println("同步部门成功！"+emp);
        signMap.put("resultcode", "0000");
        signMap.put("resultmsg", "成功");
        return signMap;
    }
    System.out.println("MAC验证失败！");
    signMap.put("resultcode", "0002");
    signMap.put("resultmsg", "MAC验证失败");
    return signMap;
}


    /**
     *员工资料同步接口
     *
     * @param paraData
     * @return
     */
    @PostMapping(value = "/HrEmploy")
    public JSONObject HrEmploy(@RequestBody String paraData) {
        int emp=0;
        String re = zadan.zha();
        if (re == "0") {
            JSONObject signMap = new JSONObject();
            signMap.put("resultcode", "-1");
            signMap.put("resultmsg", "key，失败！");
            return signMap;
        }


        JSONObject EmpMap = new JSONObject();
        if (paraData == null || "".equals(paraData)) {
            System.out.println("没有数据");
            EmpMap.put("resultcode", "-1");
            EmpMap.put("resultmsg", "失败");
            return EmpMap;
        }
        //解析数据
        JSONObject jsonObject = JSONObject.fromObject(paraData);
        String versionid = jsonObject.get("versionid").toString();//服务版本
        String timestamp = jsonObject.get("timestamp").toString(); //时间戳
        String records = jsonObject.get("records").toString();//人事资料
        String mac = jsonObject.get("md5").toString();//mac
        EmpMap.put("versionid", versionid);
        EmpMap.put("timestamp", timestamp);
        String asciiParam = putPairsSequenceAndTogether(EmpMap);//MAC值验证
        System.out.println("MAC值:"+asciiParam);
        if (asciiParam.equals(mac)) {
            //1.把字符串类型的json数组对象转化JSONArray
            JSONArray paramData = JSONArray.fromObject(records);
            //2循环遍历这个数组
            for (int j = 0; j < paramData.size(); j++) {
                //3、把里面的对象转化为JSONObject
                JSONObject job = paramData.getJSONObject(j);
                // 4、把里面想要的参数一个个用.属性名的方式获取到
                String empno = job.get("empno").toString();//部门编号
                String empname = job.get("empname").toString();//部门名称
                String deptno = job.get("deptno").toString();//部门编号
                String empstate = job.get("empstate").toString();//员工状态
                String hiredate = job.get("hiredate").toString();//入职日期
                String leavedate = job.get("leavedate").toString();//离职日期

                int optype = (int) job.get("optype");//操作类型1新增2修改3删除
              //  System.out.println("FADFDAF:" + optype);
            /*    if (optype == 1) {*/
                    //将分析的数据赋值
                    HrEmployee hrEmployee = new HrEmployee();
                    String uid = UUID.randomUUID().toString().replaceAll("-", "");
                    hrEmployee.setUuid(uid);
                    hrEmployee.setVersionid(versionid);
                    hrEmployee.setTimestamps(timestamp);
                    hrEmployee.setRecords(records);
                    hrEmployee.setEmpno(empno);
                    hrEmployee.setEmpname(empname);
                    hrEmployee.setDeptno(deptno);
                    hrEmployee.setEmpstate(empstate);
                    hrEmployee.setHiredate(hiredate);
                    hrEmployee.setLeavedate(leavedate);
                    hrEmployee.setOptype(optype);
                    hrEmployee.setState(0);
                    int ret = hremployeeService.insertJsonString(hrEmployee);
                    emp=ret;
                    if (ret < 0) {
                        EmpMap.put("resultcode", "-1");
                        EmpMap.put("resultmsg", "新增失败");
                        return EmpMap;
                    }

               /* }*/
               /* if (optype == 2) { //2修改
                    //将分析的数据赋值
                    HrEmployee hrEmployee = new HrEmployee();
                    hrEmployee.setVersionid(versionid);
                    hrEmployee.setTimestamps(timestamp);
                    hrEmployee.setRecords(records);
                    hrEmployee.setEmpno(empno);
                    hrEmployee.setEmpname(empname);
                    hrEmployee.setDeptno(deptno);
                    hrEmployee.setEmpstate(empstate);
                    hrEmployee.setHiredate(hiredate);
                    hrEmployee.setLeavedate(leavedate);
                    hrEmployee.setOptype(optype);
                    hrEmployee.setState(0);
                    int ret = hremployeeService.updateEmployee(hrEmployee);
                    if (ret < 0) {
                        EmpMap.put("resultcode", "0");
                        EmpMap.put("resultmsg", "修改失败");
                        return EmpMap;
                    }

                }*/
         /*   if (optype == 3) { //3删除
                //将分析的数据赋值
                HrEmployee hrEmployee = new HrEmployee();
                hrEmployee.setEmpno(empno);
                hrEmployee.setState(0);
                int ret = hremployeeService.deleteHrEmployee(hrEmployee);
                if (ret < 0) {
                    EmpMap.put("resultcode", "0");
                    EmpMap.put("resultmsg", "删除失败");
                    return EmpMap;
                }

            }*/

            }
            //调用存储过程
           String exec=  hrDepartsService.pInsertAll();

            System.out.println("同步人员成功！"+emp);
            EmpMap.put("resultcode", "0000");
            EmpMap.put("resultmsg", "成功");
            return EmpMap;
        }
        System.out.println("MAC验证失败！");
        EmpMap.put("resultcode", "0002");
        EmpMap.put("resultmsg", "MAC验证失败");
        return EmpMap;
    }



    /**
     *打卡记录同步接口
     *
     *
     * @return
     */
    //@PostMapping(value = "/HrTimeRecords")
    public JSONObject HrTimeRecords() throws InterruptedException {
        String re=zadan.zha();
        if (re=="0") {
            JSONObject signMap = new JSONObject();
            signMap.put("resultcode", "-1");
            signMap.put("resultmsg", "key，失败！");
            return signMap;
        }

        JSONObject EmpMap = new JSONObject();
        int start = syncSignService.getSyncSignF().getSignConsume();
        int end = timeRecordsService.getMaxNRecSeq();

        if (end == 0 || start == end) {
            System.out.println("------------没有[打卡记录]数据-------------");

            EmpMap.put("resultcode", "0000");
            EmpMap.put("resultmsg", "没有[打卡记录]数据");
            return EmpMap;
        }
        //Thread.sleep(500);

        List<TimeRecords> list = timeRecordsService.selectTimeRecordsList(start);
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                TimeRecords timeRe = list.get(i);
                JSONObject signMap = new JSONObject();
                String versionid = "001";//服务版本
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String requestTimestamp = sdf.format(new Date());//时间戳
                String empid = timeRe.getEmpId();//工号
                String signtime = timeRe.getSignTime();//打卡时间
                signMap.put("versionid", versionid);
                signMap.put("timestamp", requestTimestamp);
                signMap.put("empid", empid);
                signMap.put("signtime", signtime);
                String  asciiParam= putPairsSequenceAndTogether(signMap);//MAC值
                signMap.put("md5", asciiParam);
                String param = JSON.toJSONString(signMap);
               /* String url = MyConfig.ICARD_URL +"/bookMeal.action";
                String result= httpPostJson.doPost(url,param);

                JsonParser jp = new JsonParser();
                //将json字符串转化成json对象
                JsonObject jo = jp.parse(result).getAsJsonObject();
                //获取message对应的值
                String rcode = jo.get("resultcode").getAsString();//获取返回代码是否成功：0000 成功0002 报文MAC验证失败9999 未知错误
            */
             /*  if(rcode=="0000"){
                   EmpMap.put("resultcode", "0000");
                   EmpMap.put("resultmsg", "成功");
                   return EmpMap;
               }*/
               /* String resultmsg = jo.get("resultmsg").getAsString();//

                System.out.println("结果："+resultmsg);*/
                /**
                 * 更新标记位置
                 */
               /* if(successCount>0){
                    SyncSign syncSign = new SyncSign();
                    syncSign.setId(4);//4:打卡记录
                    syncSign.setSignConsume(end);
                    this.syncSignService.updateSyncSign(syncSign);*/
            }
        }

        EmpMap.put("resultcode", "0000");
        EmpMap.put("resultmsg", "成功");
        return EmpMap;
    }



}

