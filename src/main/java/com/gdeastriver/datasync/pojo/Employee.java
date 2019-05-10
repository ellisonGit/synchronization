package com.gdeastriver.datasync.pojo;

import lombok.Data;

/**
 * Description:员工表
 * User: YangYong
 * Date: 2019-04-29
 * Time: 11:56
 * Modified:
 */
@Data
public class Employee extends  Base{

    private String empId ;

    private String cardId ;

    private String empFname ;

    private String departId ;

}
