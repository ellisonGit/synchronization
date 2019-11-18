package com.gdeastriver.synchronization.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description:员工表
 * User:  Ellison
 * Date: 2019-08-13
 * Time: 11:56
 * Modified:
 */
@Data
public class HrEmployee extends  Base{

    private String uuid ;

    private String versionid ;

    private String timestamps ;

    private String records ;

    private String empno ;

    private String empname;

    private String deptno ;

    private String empstate ;

    private String hiredate ;

    private String leavedate ;

    private int optype ;

    private int state ;

    private String handletime ;

    private String memo ;

    private int del;

}
