package com.gdeastriver.datasync.dao;

import com.gdeastriver.datasync.pojo.MealRecords;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:39
 * Modified:
 */
public interface MealRecordDao {

    List<MealRecords> selectListByCondition(Map<String,Object> map);

    int getMaxNRecSeq();
}
