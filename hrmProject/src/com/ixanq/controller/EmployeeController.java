package com.ixanq.controller;

import com.ixanq.entity.Employee;
import com.ixanq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * ���첽ajax ��֤Ա����Ϣ�治����
     * @param name
     * @return
     */
    @RequestMapping("ajaxCheckEmployee")
    @ResponseBody
    public String validate(String name ){
        Employee employee = employeeService.findEmployeeByName(name);
        if(null==employee){
            return "yes";
        }else {
            //����
            return "no";
        }
    }

    /**
     * �ο͵�½�����ת���οͽ���
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("employeeNav")
    public String visitorNav(String name,String password, Model model){
        Employee employee2=employeeService.findEmployeeByName(name);//�ж������Ƿ�Ϊ����
        Employee employee3=employeeService.findEmployeeByNameAndPassword(name,password);
        if(null==employee2) {//���ִ���
            model.addAttribute("nameError","nameError");
            return "forward:/employeeLogin.jsp";
        } else if(null!=employee3) {//�˺�������ȷ
            model.addAttribute("employee2", employee2);
            return "employee/employeeIndexNav";
        }else{ //�������
            model.addAttribute("employee2", employee2);
            model.addAttribute("passwordError","passwordError");
            return "forward:/employeeLogin.jsp";
        }
    }

    @RequestMapping("eeployeeInfoctrl")
    public String eployeeInfoctrl(Model model){
        return "employee/employeeInfo";
    }

    @RequestMapping("eworkAttandance")
    public String workAttandance(Model model){
        return "employee/workAttandance";
    }

    @RequestMapping("edeptWorkPosition")
    public String edeptWorkPosition(Model model){
        return "employee/deptWorkPosition";
    }

    @RequestMapping("etrain")
    public String etrain(Model model){
        return "employee/train";
    }



}
