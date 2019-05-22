package com.gdeastriver.datasync.service.impl;

import com.gdeastriver.datasync.dao.MChargeRecordsDao;
import com.gdeastriver.datasync.pojo.MChargeRecords;
import com.gdeastriver.datasync.service.MChargeRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-16
 * Time: 14:30
 * Modified:
 */
@Service
public class MChargeRecordsServiceImpl implements MChargeRecordsService {

    @Autowired
    private MChargeRecordsDao mChargeRecordsDao;

    @Override
    public List<MChargeRecords> selectListByCondition(Map<String, Object> map) {
        return mChargeRecordsDao.selectListByCondition(map);
    }

    @Override
    public int getMaxNRecSeq() {
        return mChargeRecordsDao.getMaxNRecSeq();
    }
}
