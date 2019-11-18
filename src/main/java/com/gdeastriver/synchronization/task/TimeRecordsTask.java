package com.gdeastriver.synchronization.task;


import com.gdeastriver.synchronization.service.impl.TimeRecordsServiceImpl;
import com.gdeastriver.synchronization.util.MyConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 17:15
 * Modified:
 */
@Component
public class TimeRecordsTask {
    @Autowired
    private TimeRecordsServiceImpl timeRecordsServiceImpl;

   // @Scheduled(cron="0 */5 * * * ?")   //每1fen钟执行一次
   @Scheduled(cron="*/20 * * * * ?")   //每10秒钟执行一次
    public void syncTimeRecordsData() throws ParseException {
        try {
            String ret= timeRecordsServiceImpl.HrTimeRecords();
           System.out.println("----------------"+ret);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
