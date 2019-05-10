package com.gdeastriver.datasync.service;

import com.gdeastriver.datasync.pojo.SyncSign;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 11:39
 * Modified:
 */
public interface SyncSignService {

    SyncSign getSyncSign();

    int updateSyncSign(SyncSign syncSign);
}
