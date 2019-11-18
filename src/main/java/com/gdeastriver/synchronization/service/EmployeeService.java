package com.gdeastriver.synchronization.service;

import com.gdeastriver.synchronization.pojo.Employee;
import com.gdeastriver.synchronization.pojo.HrEmployee;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-04-29
 * Time: 14:43
 * Modified:
 */
public interface EmployeeService {


    List<Employee> selectAll();

    int countAll();

    int updateState(Employee employee);

    String selectCardId(String empId);

    int updateOpenid(Employee employee);

    String findOpenId(String openId);

    Integer selectUser(Employee employee);

    String selectOpenid(Employee employee);

    Employee selectUserInfo(String openId);

    List<Employee> selectEntranceList(int nRecSeq);

    int getMaxNRecSeq();

    List<Employee> selectChuRuList(String jobNo, String openId, String month);
}
