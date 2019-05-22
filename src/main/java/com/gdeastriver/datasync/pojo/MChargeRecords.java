package com.gdeastriver.datasync.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description:充值记录表
 * User: Ellison
 * Date: 2019-05-16
 * Time: 14:11
 * Modified:
 */
@Data
public class MChargeRecords extends Base{

    /**
     * 员工工号
     */
    private String empId ;
    /**
     * 卡号
     */
    private String cardId ;
    /**
     * 充值金额
     */
    private String chargeMoney ;
    /**
     * 帐上余额
     */
    private String cardBalance ;
    /**
     * 充值日期
     */
    private Date opYmd ;
    /**
     * 充值次数
     */
    private String cardTimes ;
    /**
     * 卡交易流水号
     */
    private String cardSequ ;
    /**
     * 类型(0 为现金充值 1 补贴充值 2 批量充值 3免费充值 4补办新卡)
     */
    private String Kind ;
    /**
     * 操作人
     */
    private String opUser ;
    /**
     * 充值时间
     */
    private Date opDate ;
    /**
     * 备注
     */
    private String remark;
    /**
     *
     */
    private String difineSequ;

    private String nRecSeq;
}
