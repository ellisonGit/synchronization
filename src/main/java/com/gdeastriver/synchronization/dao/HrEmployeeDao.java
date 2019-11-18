package com.gdeastriver.synchronization.dao;

import com.gdeastriver.synchronization.pojo.Employee;
import com.gdeastriver.synchronization.pojo.HrEmployee;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:36
 * Modified:
 */
public interface HrEmployeeDao {

    int insertJsonString(HrEmployee hrEmployee);

    int updateEmployee(HrEmployee hrEmployee);

    int deleteHrEmployee(HrEmployee hrEmployee);

}
