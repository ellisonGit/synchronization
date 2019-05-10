package com.gdeastriver.datasync.service.impl;

import com.gdeastriver.datasync.dao.MealRecordDao;
import com.gdeastriver.datasync.pojo.MealRecords;
import com.gdeastriver.datasync.service.MealRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:48
 * Modified:
 */
@Service
public class MealRecordServiceImpl implements MealRecordService {

    @Autowired
    private MealRecordDao mealRecordDao;

    @Override
    public List<MealRecords> selectListByCondition(Map<String, Object> map) {
        return this.mealRecordDao.selectListByCondition(map);
    }

    @Override
    public int getMaxNRecSeq() {
        return this.mealRecordDao.getMaxNRecSeq();
    }
}
