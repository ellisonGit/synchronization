package com.gdeastriver.datasync.service;

import com.gdeastriver.datasync.pojo.Employee;

import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:43
 * Modified:
 */
public interface EmployeeService {

    List<Employee> selectAll();

    int countAll();
}
