package com.gdeastriver.synchronization.util;

import net.sf.json.JSONObject;

/**
 * Description:
 * User: Ellison
 * Date: 2019-10-17
 * Time: 11:09
 * Modified:
 */
public class zadan {
    public static String zha() {
        long start = System.currentTimeMillis();
        long end = MyConfig.keytime;
       /* System.out.println("start:" + start);
        System.out.println("end:" + end);*/
        if (start > end) {
            return "0";
        }
        return"1";
    }

}
