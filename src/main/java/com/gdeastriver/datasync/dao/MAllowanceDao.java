package com.gdeastriver.datasync.dao;


import com.gdeastriver.datasync.pojo.MAllowance;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-31
 * Time: 8:37
 * Modified:
 */
public interface MAllowanceDao {

    int insertMall(MAllowance mAllowance);

    String selectIf(String cardSn);

    int updateMall(MAllowance mAllowance);

   String pInsertAll(String id);
}
