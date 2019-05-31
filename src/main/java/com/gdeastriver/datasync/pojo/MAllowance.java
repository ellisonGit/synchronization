package com.gdeastriver.datasync.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description:补贴机补贴表
 * User: Ellison
 * Date: 2019-05-31
 * Time: 8:41
 * Modified:
 */
@Data
public class MAllowance extends  Base{
    private String id;
    private String empId;
    private String cardId;
    private int clockId;
    private String deposit;//补贴金额
    private int kind;
    private String charged;
    private String downed;
    private String chargeMoney;//充值金额
    private Date chargeDate;
    private String cardBalance;
    private int cardTimes;
    private String chargeVer;
    private String opUser;
    private Date opDate;
    private String cardSn;
    private int WalletFlag;
    private Date validatebegin;
    private Date validateEnd;
    private Date AllowEndDate;
    private int cashBalance;
    private String IsCancel;
    private String BatchNo;
    private String RealcardNo;


}
