package com.gdeastriver.datasync.util;

import com.gdeastriver.datasync.pojo.*;
import com.gdeastriver.datasync.vo.Response;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 15:26
 * Modified:
 */
public class SyncDataUtil {

    /**
     * 通过企业编码获取该企业下面的设备数量
     * @param eCode
     * @return
     */
    public static int getServerTerminalCount(String serverUrl,String eCode){

        String url = serverUrl+"/api/sync/getTerminalCount";
        String param = "eCode="+eCode;
        String result = MyRequestUtil.sendGet(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        return response.getData();
    }

    /**
     * 添加一条设备数据到服务端的数据库
     * @param eCode
     * @param clocks
     * @return
     */
    public static int addClock(String serverUrl,String eCode, Clocks clocks){

        String url = serverUrl+"/api/sync/addTerminal";
        String param = "eCode="+eCode+"&tName="+clocks.getClockName()+"&tNo="+clocks.getClockId()+"&tType="+clocks.getClockType();
        String result = MyRequestUtil.sendPost(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        if(response.getCode().equals("000001") && response.getData() == 0){
            return 0;
        }else{
            System.out.println("同步本地[设备]数据到服务端时报错：");
            return -1;
        }
    }

    /**
     * 移除服务端设备数据
     * @param eCode
     * @return
     */
    public static int removeServiceClock(String serverUrl,String eCode){
        String url = serverUrl+"/api/sync/removeTerminal";
        String param = "eCode="+eCode;

        String result = MyRequestUtil.sendGet(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        if(response.getCode().equals("000001") && response.getData() == 0){
            return 0;
        }else{
            System.out.println("移除服务端[设备]数据时报错：");
            return -1;
        }
    }

    /**
     * 通过企业编码获取该企业下面的部门数量
     * @param eCode
     * @return
     */
    public static int getServerDepartsCount(String serverUrl,String eCode){

        String url = serverUrl+"/api/sync/getDepartsCount";
        String param = "eCode="+eCode;
        String result = MyRequestUtil.sendGet(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        return response.getData();
    }

    /**
     * 添加一条部门数据到服务端的数据库
     * @param eCode
     * @param departs
     * @return
     */
    public static int addDepart(String serverUrl,String eCode, Departs departs){

        String url = serverUrl+"/api/sync/addDepart";
        String param = "eCode="+eCode+"&departId="+departs.getDepartId()+"&insideId="+departs.getInsideId()+"&groupId="+departs.getGroupId()+
                    "&departName="+departs.getDepartName()+"&principal="+departs.getPrincipal()+"&empPrefix="+departs.getEmpPrefix();
        String result = MyRequestUtil.sendPost(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        if(response.getCode().equals("000001") && response.getData() == 0){
            return 0;
        }else{
            System.out.println("同步本地[部门]数据到服务端时报错：");
            return -1;
        }
    }

    /**
     * 移除服务端部门数据
     * @param eCode
     * @return
     */
    public static int removeServiceDeparts(String serverUrl,String eCode){
        String url = serverUrl+"/api/sync/removeDeparts";
        String param = "eCode="+eCode;

        String result = MyRequestUtil.sendGet(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        if(response.getCode().equals("000001") && response.getData() == 0){
            return 0;
        }else{
            System.out.println("移除服务端[部门]数据时报错：");
            return -1;
        }
    }

    /**
     * 通过企业编码获取该企业下面的员工数量
     * @param eCode
     * @return
     */
    public static int getServerEmployeeCount(String serverUrl,String eCode){

        String url = serverUrl+"/api/sync/getStaffCount";
        String param = "eCode="+eCode;
        String result = MyRequestUtil.sendGet(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        return response.getData();
    }

    /**
     * 添加一条员工数据到服务端的数据库
     * @param eCode
     * @param employee
     * @return
     */
    public static int addEmployee(String serverUrl,String eCode, Employee employee){

        String url = serverUrl+"/api/sync/addStaff";
        String param = "eCode="+eCode+"&sName="+employee.getEmpFname()+"&departsId="+employee.getDepartId()+"&jobNo="+employee.getEmpId()+"&cardNo="+employee.getCardId();
        String result = MyRequestUtil.sendPost(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        if(response.getCode().equals("000001") && response.getData() == 0){
            return 0;
        }else{
            System.out.println("同步本地[员工]数据到服务端时报错：");
            return -1;
        }
    }

    /**
     * 移除服务端员工数据
     * @param eCode
     * @return
     */
    public static int removeServiceEmployee(String serverUrl,String eCode){
        String url = serverUrl+"/api/sync/removeStaff";
        String param = "eCode="+eCode;

        String result = MyRequestUtil.sendGet(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        if(response.getCode().equals("000001") && response.getData() == 0){
            return 0;
        }else{
            System.out.println("移除服务端[员工]数据时报错：");
            return -1;
        }
    }

    /**
     * 添加一条消费记录数据到服务端的数据库
     * @param eCode
     * @param mealRecords
     * @return
     */
    public static int addMealRecord(String serverUrl,String eCode, MealRecords mealRecords){

        String url = serverUrl+"/api/sync/addConsume";
        String param = "eCode="+eCode+"&money="+mealRecords.getCardConsume()+"&remainMoney="+mealRecords.getCardBalance()+
                    "&consumeType="+mealRecords.getKind()+"&createTime="+mealRecords.getSignTime().toLocaleString()+
                    "&poseSequ="+mealRecords.getPosSequ()+"&cardSequ="+mealRecords.getCardSequ()+
                    "&tNo="+mealRecords.getClockId()+"&jobNo="+mealRecords.getEmpId()+"&cardNo="+mealRecords.getCardId();

        String result = MyRequestUtil.sendPost(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        if(response.getCode().equals("000001") && response.getData() >= 0){
            return response.getData();
        }else{
            System.out.println("同步本地[消费记录]数据到服务端时报错：");
            return -1;
        }
    }

    /**
     * 添加充值记录数据到服务端的数据库
     * @param eCode
     * @param mChargeRecords
     * @return
     */
    public static int addMealRecharge(String serverUrl,String eCode, MChargeRecords mChargeRecords){

        String url = serverUrl+"/api/sync/addCharge";
        String param = "eCode="+eCode+"&empId="+mChargeRecords.getEmpId()+"&cardId="+mChargeRecords.getCardId()+
                "&chargeMoney="+mChargeRecords.getChargeMoney()+"&cardBalance="+mChargeRecords.getCardBalance()+
                "&opYmd="+mChargeRecords.getOpYmd().toLocaleString()+"&cardTimes="+mChargeRecords.getCardTimes()+
                "&cardSequ="+mChargeRecords.getCardSequ()+"&Kind="+mChargeRecords.getKind()+"&opUser="+mChargeRecords.getOpUser()+
                "&opDate="+mChargeRecords.getOpDate().toLocaleString()+"&remark="+mChargeRecords.getRemark()+"&difineSequ="+mChargeRecords.getDifineSequ();

        String result = MyRequestUtil.sendPost(url,param);

        Response  response = (Response) GsonUtil.jsonToObject(result,Response.class);
        if(response.getCode().equals("000001") && response.getData() >= 0){
            return response.getData();
        }else{
            System.out.println("同步本地[充值记录]数据到服务端时报错：");
            return -1;
        }
    }

}
