package com.gdeastriver.synchronization.service.impl;

import com.gdeastriver.synchronization.dao.DepartsDao;
import com.gdeastriver.synchronization.pojo.Departs;
import com.gdeastriver.synchronization.service.DepartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:46
 * Modified:
 */
@Service
public class DepartsServiceImpl implements DepartsService {

    @Autowired
    private DepartsDao departsDao;

    @Override
    public List<Departs> selectAll() {
        return this.departsDao.selectAll();
    }

    @Override
    public int countAll() {
        return this.departsDao.countAll();
    }

    @Override
    public int updateState( Departs departs) {
        return departsDao.updateState(departs);
    }
}
