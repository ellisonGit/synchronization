package com.gdeastriver.synchronization.service;


import com.gdeastriver.synchronization.pojo.TimeRecords;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:36
 * Modified:
 */
public interface TimeRecordsService {

    int getMaxNRecSeq();

    List<TimeRecords> selectTimeRecordsList(int id);
}
