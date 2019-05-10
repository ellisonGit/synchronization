package com.gdeastriver.datasync.pojo;

import lombok.Data;

/**
 * Description: 部门表
 * User: YangYong
 * Date: 2019-04-29
 * Time: 11:42
 * Modified:
 */
@Data
public class Departs extends Base{

    private String departId ;

    private String insideId ;

    private String groupId ;

    private String departName ;

    private String principal ;

    private String empPrefix;

}
