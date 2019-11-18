package com.gdeastriver.synchronization.service.impl;

import com.gdeastriver.synchronization.dao.HrDepartsDao;
import com.gdeastriver.synchronization.pojo.HrDeparts;
import com.gdeastriver.synchronization.service.DepartsService;
import com.gdeastriver.synchronization.service.HrDepartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:36
 * Modified:
 */
@Service
public class HrDepartsServiceImpl implements HrDepartsService {

    @Autowired
    private HrDepartsDao hrdepartsDao;


    @Override
    public int insertJsonString(HrDeparts hrDeparts) {
        return hrdepartsDao.insertJsonString(hrDeparts);
    }

    @Override
    public List<HrDeparts> selectAll() {
        return hrdepartsDao.selectAll();
    }

    @Override
    public String pInsertAll() {
        return hrdepartsDao.pInsertAll();
    }
}
