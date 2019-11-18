package com.gdeastriver.synchronization.service.impl;

import com.gdeastriver.synchronization.dao.EmployeeDao;
import com.gdeastriver.synchronization.pojo.Employee;
import com.gdeastriver.synchronization.pojo.TemplateJson;
import com.gdeastriver.synchronization.service.EmployeeService;
import com.gdeastriver.synchronization.util.DateUtil;
import com.gdeastriver.synchronization.util.TemplateMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-08-22
 * Time: 14:47
 * Modified:
 */
@Service
public abstract class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> selectAll() {
        return this.employeeDao.selectAll();
    }

    @Override
    public int countAll() {
        return this.employeeDao.countAll();
    }

    @Override
    public int updateState(Employee employee) {
        return employeeDao.updateState(employee);
    }

    @Override
    public String selectCardId(String empId) {
        return employeeDao.selectCardId(empId);
    }


    @Override
    public int updateOpenid(Employee employee) {
        return employeeDao.updateOpenid(employee);
    }

    @Override
    public String findOpenId(String openId) {
        return employeeDao.findOpenId(openId);
    }

    @Override
    public Integer selectUser(Employee employee) {
        return employeeDao.selectUser(employee);
    }

    @Override
    public String selectOpenid(Employee employee) {
        return employeeDao.selectOpenid(employee);
    }

    @Override
    public Employee selectUserInfo(String openId) {
        return employeeDao.selectUserInfo(openId);
    }

    @Override
    public List<Employee> selectEntranceList(int nRecSeq) {
        return employeeDao.selectEntranceList(nRecSeq);
    }


    @Override
    public int getMaxNRecSeq() {
        return this.employeeDao.getMaxNRecSeq();
    }

    @Override
    public List<Employee> selectChuRuList(String jobNo, String openId, String month) {
        return employeeDao.selectChuRuList(jobNo,openId,month);
    }

    public int sendEntrance(Employee employee) {
        try{
            String openId = employee.getOpenId();
            if(employee != null && openId != null && !openId.trim().equals("")){
                /**
                 * 如果用户不为空，并且已经绑定openid，就发送模板消息
                 */
                TemplateJson templateJson = new TemplateJson();
                templateJson.setTouser(openId);
                templateJson.setTemplate_id("CCHmBzIIFQKXWJWxOjE_WNzVSONSHaxn20Rn7wXu6YA");
                templateJson.setUrl("http://lllison.viphk.ngrok.org/api/info_1.html?t=1");
                templateJson.setDataFirstValue("亲爱的家长您好，您的孩子有一条新的出入校园记录");
                templateJson.setDataKeyWord1Value(employee.getEmpFname());//姓名
                templateJson.setDataKeyWord2Value(DateUtil.dateToStr(employee.getPasstime(),null));//时间
                templateJson.setDataKeyWord3Value(employee.getDoorname());//地点
                if(employee.getInoutflag()=="1"){
                    templateJson.setDataKeyWord4Value("进校");//进出方向
                }else{
                    templateJson.setDataKeyWord4Value("出校");//进出方向
                }

                templateJson.setDataRemarkValue("点击详情可查看更多信息");

                boolean result = TemplateMsgUtil.sendTemplateMsg(templateJson);
                if(result){
                    return 100;//表示数据同步成功，发送消息成功
                }else{
                    return 101;//表示数据同步成功，但是发送模板消息失败
                }
            }
            return 0;
        }catch (Exception e){
            return -1;
        }
    }
}
