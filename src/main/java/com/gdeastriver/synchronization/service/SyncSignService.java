package com.gdeastriver.synchronization.service;

import com.gdeastriver.synchronization.pojo.SyncSign;

/**
 * Description:
 * User: Ellison
 * Date: 2019-08-17
 * Time: 11:39
 * Modified:
 */
public interface SyncSignService {

    SyncSign getSyncSign();
    SyncSign getSyncSignToo();
    SyncSign getSyncSignTr();
    SyncSign getSyncSignF();
    int updateSyncSign(SyncSign syncSign);
}
