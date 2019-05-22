package com.gdeastriver.datasync.dao;

import com.gdeastriver.datasync.pojo.MChargeRecords;
import com.gdeastriver.datasync.pojo.MealRecords;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-16
 * Time: 14:30
 * Modified:
 */
public interface MChargeRecordsDao {

    List<MChargeRecords> selectListByCondition(Map<String, Object> map);

    int getMaxNRecSeq();
}
