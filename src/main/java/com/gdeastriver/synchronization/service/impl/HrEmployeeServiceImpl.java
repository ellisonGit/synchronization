package com.gdeastriver.synchronization.service.impl;

import com.gdeastriver.synchronization.dao.EmployeeDao;
import com.gdeastriver.synchronization.dao.HrEmployeeDao;
import com.gdeastriver.synchronization.pojo.Employee;
import com.gdeastriver.synchronization.pojo.HrDeparts;
import com.gdeastriver.synchronization.pojo.HrEmployee;
import com.gdeastriver.synchronization.pojo.TemplateJson;
import com.gdeastriver.synchronization.service.EmployeeService;
import com.gdeastriver.synchronization.service.HrEmployeeService;
import com.gdeastriver.synchronization.util.DateUtil;
import com.gdeastriver.synchronization.util.TemplateMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-08-22
 * Time: 14:47
 * Modified:
 */
@Service
public class HrEmployeeServiceImpl implements HrEmployeeService {

    @Autowired
    private HrEmployeeDao hrEmployeeDao;

    @Override
    public int insertJsonString(HrEmployee hrEmployee) {
        return hrEmployeeDao.insertJsonString(hrEmployee);
    }


    @Override
    public int updateEmployee(HrEmployee hrEmployee) {
        return hrEmployeeDao.updateEmployee(hrEmployee);
    }


    @Override
    public int deleteHrEmployee(HrEmployee hrEmployee) {
        return hrEmployeeDao.deleteHrEmployee(hrEmployee);
    }
}
