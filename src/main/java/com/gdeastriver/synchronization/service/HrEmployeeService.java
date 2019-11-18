package com.gdeastriver.synchronization.service;


import com.gdeastriver.synchronization.pojo.HrEmployee;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:36
 * Modified::
 */
public interface HrEmployeeService {


    int insertJsonString(HrEmployee hrEmployee);

    int updateEmployee(HrEmployee hrEmployee);

    int deleteHrEmployee(HrEmployee hrEmployee);
}
