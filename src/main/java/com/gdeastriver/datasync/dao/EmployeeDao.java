package com.gdeastriver.datasync.dao;

import com.gdeastriver.datasync.pojo.Employee;

import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:37
 * Modified:
 */
public interface EmployeeDao {

    List<Employee> selectAll();

    int countAll();

    int updateState(Employee employee);
}
