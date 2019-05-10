package com.gdeastriver.datasync.dao;


import com.gdeastriver.datasync.pojo.Departs;

import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:36
 * Modified:
 */
public interface DepartsDao {

    List<Departs> selectAll();

    int countAll();
}

