package com.gdeastriver.synchronization.pojo;

import lombok.Data;

/**
 * Description: HR部门表
 * User: Ellison
 * Date: 2019-10-16
 * Time: 11:42
 * Modified:
 */
@Data
public class HrDeparts extends Base{

    private String uuid ;

    private String versionid ;

    private String timestamps ;

    private String records ;

    private String deptno ;

    private String deptname;

    private String parentdeptno ;

    private String parentdeptname ;

    private String olddeptno ;

    private String olddeptname ;

    private int optype ;

    private int state;

    private String handletime ;

    private String memo ;
}
