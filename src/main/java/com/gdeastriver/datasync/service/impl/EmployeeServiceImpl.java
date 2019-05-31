package com.gdeastriver.datasync.service.impl;

import com.gdeastriver.datasync.dao.EmployeeDao;
import com.gdeastriver.datasync.pojo.Employee;
import com.gdeastriver.datasync.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:47
 * Modified:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> selectAll() {
        return this.employeeDao.selectAll();
    }

    @Override
    public int countAll() {
        return this.employeeDao.countAll();
    }

    @Override
    public int updateState( Employee employee) {
        return employeeDao.updateState(employee);
    }

    @Override
    public String selectCardId( String empId) {
        return employeeDao.selectCardId(empId);
    }
}
