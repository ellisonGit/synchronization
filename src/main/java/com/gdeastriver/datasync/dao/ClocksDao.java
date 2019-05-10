package com.gdeastriver.datasync.dao;

import com.gdeastriver.datasync.pojo.Clocks;

import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:35
 * Modified:
 */
public interface ClocksDao {

    List<Clocks> selectAll();

    int countAll();
}
