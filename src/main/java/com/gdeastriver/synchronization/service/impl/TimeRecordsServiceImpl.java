package com.gdeastriver.synchronization.service.impl;


import com.alibaba.fastjson.JSON;
import com.gdeastriver.synchronization.dao.TimeRecordsDao;

import com.gdeastriver.synchronization.pojo.SyncSign;
import com.gdeastriver.synchronization.pojo.TimeRecords;
import com.gdeastriver.synchronization.service.SyncSignService;
import com.gdeastriver.synchronization.service.TimeRecordsService;
import com.gdeastriver.synchronization.util.MyConfig;
import com.gdeastriver.synchronization.util.httpPostJson;
import com.gdeastriver.synchronization.util.zadan;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.gdeastriver.synchronization.util.Ascii.putPairsSequenceAndTogether;


/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:36
 * Modified:
 */
@Service
public class TimeRecordsServiceImpl implements TimeRecordsService {

    @Autowired
    private TimeRecordsDao timeRecordsDao;
    @Autowired
    private SyncSignService syncSignService;
    @Autowired
    private TimeRecordsService timeRecordsService;


    @Override
    public int getMaxNRecSeq() {
        return timeRecordsDao.getMaxNRecSeq();
    }

    @Override
    public List<TimeRecords> selectTimeRecordsList(int id) {
        return timeRecordsDao.selectTimeRecordsList(id);
    }

    //打卡记录同步
    public String HrTimeRecords() throws InterruptedException, ParseException {
        String re = zadan.zha();
        if (re == "0") {

            return "key，失败！";
        }

        SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmss");
        String requestTimestamp = d.format(new Date());//时间戳
        int start = syncSignService.getSyncSignF().getSignConsume();
        int end = timeRecordsService.getMaxNRecSeq();

        if (end == 0 || start == end) {
            System.out.println("------------没有[打卡记录]数据-------------"+requestTimestamp);
            return "------------没有[打卡记录]数据-------------"+requestTimestamp;
        }
        //Thread.sleep(500);
        JSONObject Map = new JSONObject();
        JSONArray jsonArray = new JSONArray();//定义json数组
        List<TimeRecords> list = timeRecordsService.selectTimeRecordsList(start);
        int toal=list.size();
        Date date = new Date();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                TimeRecords timeRe = list.get(i);
                JSONObject signMap = new JSONObject();
                String empid = timeRe.getEmpId();//工号
                String stime = timeRe.getSignTime();//打卡时间

                date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(stime);//先按照原格式转换为时间
                String signtime = new SimpleDateFormat("yyyyMMddHHmmss").format(date);//再将时间转换为对应格式字符串
                signMap.put("EMPLID", empid);
                signMap.put("C_CARD_TIME", signtime);
                jsonArray.add(signMap);

            }
            Map.put("PUNCH", jsonArray);
            String param = JSON.toJSONString(Map);
            System.out.println("发送json串:" + param);

            String url = MyConfig.ICARD_URL;//对接地址
            String result = httpPostJson.doPost(url, param);
            JsonParser jp = new JsonParser();
            //将json字符串转化成json对象
            JsonObject jo = jp.parse(result).getAsJsonObject();
            //获取message对应的值
            String Status = jo.get("Status").getAsString();
            if ("success".equals(Status)) {
                System.out.println("同步成功！"+requestTimestamp);

                //更新标记位置
                SyncSign syncSign = new SyncSign();
                syncSign.setId(4);//4:打卡记录
                syncSign.setSignConsume(start+toal);
                this.syncSignService.updateSyncSign(syncSign);
                return "----------同步成功！:"+toal+"条-----------"+requestTimestamp;
            }else{
                String errorMsg = jo.get("errorMsg").getAsString();

                return errorMsg;
            }

        }



        return "未知错误！"+requestTimestamp;
    }
}
