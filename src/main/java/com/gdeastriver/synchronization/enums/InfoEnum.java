package com.gdeastriver.synchronization.enums;

/**
 * Description:
 * User: by
 * Date: 2018-04-03
 * Time: 11:43
 * Modified:
 */
public enum InfoEnum {
    //Enum采用大写加下划线组合
    SUCCESS("000001","SUCCESS"),
    WXSUCCESS("000002","绑定openId,SUCCESS"),
    OPENID_SUCCESS("000002","该员工已绑定过openId,SUCCESS"),
    NO_OPENID("100001","参数 openid 不能为空"),
    NO_STUNAME("100002","参数 stuName 不能为空"),
    NO_ACTION("100003","参数 action 不能为空"),
    NO_TIMESTR("100004","参数 timeStr 不能为空"),
    NO_MONEY("100005","参数 money 不能为空"),
    NO_REASON("100006","参数 reason 不能为空"),
    NO_REMAIN_MONEY("100007","参数 remainMoney 不能为空"),
    NO_ACCOUNT("100008","参数 account 不能为空"),
    NO_STUNO("100009","参数 stuno 不能为空"),
    NO_STUNAME_lowercase("100010","参数 stuname 不能为空"),
    NO_ADDRESS("100011","参数 address 不能为空"),
    NO_START("100012","参数 start 不能为空"),

    TEMPLATE_MSG_FAILED("200001","模板消息发送失败！"),

    NET_ERROR("300001","网络异常，请检查网络后重试！"),

    SHUJU("100013","数据已存在!"),
    NO_SHUJU("100014","没有要同步的数据!"),
    NO_ECODE("400001","企业编码不能为空!"),
    NO_SNAME("400002","用户姓名不能为空"),
    NO_DEPARTSID("400003","部门编号不能为空!"),
    NO_JOBNO("400004","工号不能为空!"),
    NO_CARDNO("400005","卡号不能为空!"),
    NO_OPEN("100001","openId不存在!"),
    NO_USER("400007","员工不存在!"),
    ;



    private String code;
    private String msg;

    InfoEnum(String code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
