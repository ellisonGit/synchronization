package com.gdeastriver.datasync.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description:消费记录表
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:11
 * Modified:
 */
@Data
public class MealRecords extends Base{

    /**
     * 员工工号
     */
    private String empId ;

    /**
     * 员工卡号
     */
    private String cardId ;

    /**
     * 消费时间
     */
    private Date signTime ;

    /**
     * 消费金额
     */
    private String cardConsume ;

    /**
     * 卡上余额
     */
    private String cardBalance ;

    /**
     * 消费类型  1-早餐 2-中餐 3-晚餐 4-夜宵
     */
    private String kind ;

    /**
     * 消费流水
     */
    private Integer posSequ ;

    /**
     *卡交易流水
     */
    private Integer cardSequ ;

    /**
     * 设备号
     */
    private Integer clockId ;

    /**
     * 消费记录表的自增长字段
     */
    private Integer nRecSeq ;
}
