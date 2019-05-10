package com.gdeastriver.datasync.service;

import com.gdeastriver.datasync.pojo.Clocks;

import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-29
 * Time: 14:42
 * Modified:
 */
public interface ClocksService {

    List<Clocks> selectAll();

    int countAll();
}
