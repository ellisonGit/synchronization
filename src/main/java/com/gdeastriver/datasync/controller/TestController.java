package com.gdeastriver.datasync.controller;

import com.gdeastriver.datasync.enums.InfoEnum;
import com.gdeastriver.datasync.pojo.Departs;
import com.gdeastriver.datasync.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-26
 * Time: 17:41
 * Modified:
 */
@RestController
@RequestMapping(value = "/test",produces = "application/json;charset=utf-8")
public class TestController {

    @Value(value = "${enterprise.code}")
    private String eCode;

    @GetMapping(value = "/index")
    public ResponseInfo index(){
        Departs departs=new Departs();
        departs.setDepartId("1002");
        if(departs.getDepartId()=="1002"){
            return new ResponseInfo(InfoEnum.SUCCESS,departs);
        }
        return new ResponseInfo(InfoEnum.FAILUE);
    }
    @GetMapping(value = "/hello")
    public String hello(Model model) {
        List<Departs> empList = new ArrayList<>();
        Departs departs=new Departs();
        departs.setInsideId("1");
        departs.setGroupId("2");
        departs.setEmpPrefix("3");
        departs.setDepartName("4");
        departs.setDepartId("5");
        departs.setPrincipal("6");
        empList.add(departs);

        model.addAttribute("empList", empList);
        return "tes";
    }


}
