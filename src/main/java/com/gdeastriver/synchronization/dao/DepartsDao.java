package com.gdeastriver.synchronization.dao;


import com.gdeastriver.synchronization.pojo.Departs;

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

    int updateState(Departs departs);
}

