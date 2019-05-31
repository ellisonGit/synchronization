package com.gdeastriver.datasync.service.impl;

import com.gdeastriver.datasync.dao.MAllowanceDao;
import com.gdeastriver.datasync.dao.MChargeRecordsDao;
import com.gdeastriver.datasync.pojo.MAllowance;
import com.gdeastriver.datasync.pojo.MChargeRecords;
import com.gdeastriver.datasync.service.MAllowanceService;
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
public class MAllowanceServiceImpl implements MAllowanceService {

    @Autowired
    private MAllowanceDao mAllowanceDao;


    @Override
    public int insertMall(MAllowance mAllowance) {
        return mAllowanceDao.insertMall(mAllowance);
    }

    @Override
    public int updateMall(MAllowance mAllowance) {
        return mAllowanceDao.insertMall(mAllowance);
    }

    @Override
    public String selectIf(String cardSn) {
        return mAllowanceDao.selectIf(cardSn);
    }

    @Override
    public String pInsertAll(String id) {
        return mAllowanceDao.pInsertAll(id);
    }
}
