package com.gdeastriver.synchronization.dao;


import com.gdeastriver.synchronization.pojo.HrDeparts;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:36
 * Modified:
 */
public interface HrDepartsDao {
    int insertJsonString(HrDeparts hrDeparts);

    List<HrDeparts> selectAll();

    String pInsertAll();
}

