package com.gdeastriver.synchronization.service;


import com.gdeastriver.synchronization.pojo.WXWebToken;

/**
 * Description:
 * User: by yangyong
 * Date: 2018-09-25
 * Time: 20:28
 * Modified:
 */
public interface WxAuthService {

    WXWebToken getWXAccessToken(String appId, String secret, String code);


}
