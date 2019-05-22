package com.gdeastriver.datasync.dao;

import com.gdeastriver.datasync.pojo.SyncSign;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 11:31
 * Modified:
 */
public interface SyncSignDao {

    SyncSign getSyncSign();
    SyncSign getSyncSignToo();
    void updateSyncSign(SyncSign syncSign);
}
