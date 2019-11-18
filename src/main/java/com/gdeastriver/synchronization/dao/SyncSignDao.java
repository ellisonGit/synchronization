package com.gdeastriver.synchronization.dao;

import com.gdeastriver.synchronization.pojo.SyncSign;

/**
 * Description:
 * User: Ellison
 * Date: 2019-08-17
 * Time: 11:31
 * Modified:
 */
public interface SyncSignDao {

    SyncSign getSyncSign();
    SyncSign getSyncSignToo();
    SyncSign getSyncSignTr();
    SyncSign getSyncSignF();
    void updateSyncSign(SyncSign syncSign);
}
