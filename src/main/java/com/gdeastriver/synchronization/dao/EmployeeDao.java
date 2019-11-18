package com.gdeastriver.synchronization.dao;

import com.gdeastriver.synchronization.pojo.Employee;

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

    String selectCardId(String empId);

    int updateOpenid(Employee employee );

    String findOpenId(String openId);

    int selectUser(Employee employee);

    String selectOpenid(Employee employee);

    Employee selectUserInfo(String openId);
    int getMaxNRecSeq();

    List<Employee> selectEntranceList(int nRecSeq);

    List<Employee> selectChuRuList(String jobNo, String openId,String month);


}
