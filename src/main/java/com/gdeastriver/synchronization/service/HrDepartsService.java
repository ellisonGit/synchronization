package com.gdeastriver.synchronization.service;


import com.gdeastriver.synchronization.pojo.HrDeparts;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:36
 * Modified:
 */
public interface HrDepartsService {

    int insertJsonString(HrDeparts hrDeparts);

    List<HrDeparts> selectAll();

    String pInsertAll();
}
