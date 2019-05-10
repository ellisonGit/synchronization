package com.gdeastriver.datasync.service.impl;

import com.gdeastriver.datasync.dao.ClocksDao;
import com.gdeastriver.datasync.pojo.Clocks;
import com.gdeastriver.datasync.service.ClocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:44
 * Modified:
 */
@Service
public class ClockServiceImpl implements ClocksService {

    @Autowired
    private ClocksDao clocksDao;

    @Override
    public List<Clocks> selectAll() {
        return this.clocksDao.selectAll();
    }

    @Override
    public int countAll() {
        return this.clocksDao.countAll();
    }
}
