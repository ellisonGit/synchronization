package com.gdeastriver.datasync.service.impl;

import com.gdeastriver.datasync.dao.SyncSignDao;
import com.gdeastriver.datasync.pojo.SyncSign;
import com.gdeastriver.datasync.service.SyncSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 11:39
 * Modified:
 */
@Service
public class SyncSignServiceImpl implements SyncSignService {

    @Autowired
    private SyncSignDao syncSignDao;

    @Override
    public SyncSign getSyncSign() {
        return this.syncSignDao.getSyncSign();
    }

    @Override
    public SyncSign getSyncSignToo() {
        return this.syncSignDao.getSyncSignToo();
    }
    @Override
    public int updateSyncSign(SyncSign syncSign) {
        try{
            this.syncSignDao.updateSyncSign(syncSign);
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
