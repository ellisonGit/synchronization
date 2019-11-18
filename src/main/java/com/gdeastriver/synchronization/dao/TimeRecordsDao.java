package com.gdeastriver.synchronization.dao;


import com.gdeastriver.synchronization.pojo.TimeRecords;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:36
 * Modified:
 */
public interface TimeRecordsDao {
    int getMaxNRecSeq();

    List<TimeRecords> selectTimeRecordsList(int id);
}

