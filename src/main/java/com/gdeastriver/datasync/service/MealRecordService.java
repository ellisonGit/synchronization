package com.gdeastriver.datasync.service;

import com.gdeastriver.datasync.pojo.MealRecords;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:44
 * Modified:
 */
public interface MealRecordService {

    List<MealRecords> selectListByCondition(Map<String,Object> map);

    int getMaxNRecSeq();
}
