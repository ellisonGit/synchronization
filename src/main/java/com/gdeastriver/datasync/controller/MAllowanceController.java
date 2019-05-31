package com.gdeastriver.datasync.controller;

import com.gdeastriver.datasync.enums.InfoEnum;
import com.gdeastriver.datasync.pojo.Departs;
import com.gdeastriver.datasync.pojo.MAllowance;
import com.gdeastriver.datasync.service.EmployeeService;
import com.gdeastriver.datasync.service.MAllowanceService;
import com.gdeastriver.datasync.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-31
 * Time: 8:41
 * Modified:
 */
@RestController
@RequestMapping(value = "/wxInfo",produces = "application/json;charset=utf-8")
public class MAllowanceController {

    @Autowired
    private MAllowanceService mAllowanceService;
    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/saveInfo")
    public ResponseInfo saveInfo(String deposit,String empId,String cardSn) {
        //查看记录是否已存在
        String ret=mAllowanceService.selectIf(cardSn);
        if(ret!=null){
            return new ResponseInfo(InfoEnum.SUCCESS, "数据已存在！");
        }
        //根据员工id查询卡id
        String cardId=employeeService.selectCardId(empId);
        if(cardId!=null){
            MAllowance mall= new MAllowance();
            mall.setEmpId(empId);
            mall.setCardId(cardId);
            mall.setDeposit(deposit);
            mall.setClockId(0);
            mall.setKind(2);
            mall.setCharged("0");
            mall.setDowned("0");
            mall.setChargeMoney(".0000");
            mall.setOpUser("wx");//操作人
            mall.setOpDate(new Date());
            mall.setAllowEndDate(new Date());
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            mall.setBatchNo(df.format(new Date()));
            mall.setIsCancel("0");
            mall.setCashBalance(1);
            mall.setCardBalance(".0000");
            mall.setCardSn(cardSn);
            int result=mAllowanceService.insertMall(mall);
            if(result>0){
                String id=mAllowanceService.selectIf(cardSn);
             String exec=mAllowanceService.pInsertAll(id);
                return new ResponseInfo(InfoEnum.SUCCESS, "1");
            }

        }

        return new ResponseInfo(InfoEnum.FAILUE, "-1");

    }



}
