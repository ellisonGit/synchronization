package com.gdeastriver.datasync.pojo;

import lombok.Data;

/**
 * Description: 设备表
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:08
 * Modified:
 */
@Data
public class Clocks extends Base {

    private Integer clockId ;

    private String clockName;

    private String clockType ;

}
