package com.gdeastriver.datasync.service;

import com.gdeastriver.datasync.pojo.Employee;
import com.gdeastriver.datasync.pojo.MAllowance;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-31
 * Time: 08:43
 * Modified:
 */
public interface MAllowanceService {

    int insertMall(MAllowance mAllowance);

    int updateMall(MAllowance mAllowance);

    String selectIf(String cardSn);

    String pInsertAll(String id);
}
