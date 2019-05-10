package com.gdeastriver.datasync.vo;

import com.google.gson.annotations.Expose;
import lombok.Data;

/**
 * Description: 用于 GSON 解析服务端返回的结果
 * User: YangYong
 * Date: 2019-04-29
 * Time: 15:17
 * Modified:
 */
@Data
public class Response {

    @Expose
    private String code ;

    @Expose
    private String desc ;

    @Expose
    private Integer data ;
}
