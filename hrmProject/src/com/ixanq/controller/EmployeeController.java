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
     * 用异步ajax 验证员工信息存不存在
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
            //存在
            return "no";
        }
    }

    /**
     * 游客登陆完后，跳转到游客界面
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("employeeNav")
    public String visitorNav(String name,String password, Model model){
        Employee employee2=employeeService.findEmployeeByName(name);//判断名字是否为错误
        Employee employee3=employeeService.findEmployeeByNameAndPassword(name,password);
        if(null==employee2) {//名字错误
            model.addAttribute("nameError","nameError");
            return "forward:/employeeLogin.jsp";
        } else if(null!=employee3) {//账号密码正确
            model.addAttribute("employee2", employee2);
            return "employee/employeeIndexNav";
        }else{ //密码错误
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
