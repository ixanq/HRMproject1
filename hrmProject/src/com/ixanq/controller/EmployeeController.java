package com.ixanq.controller;

import com.ixanq.entity.CheckWorkAttendance;
import com.ixanq.entity.Employee;
import com.ixanq.entity.Reward;
import com.ixanq.service.EmployeeService;
import com.ixanq.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ManagerService managerService;

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
    public String visitorNav(String name, String password, Model model, HttpSession employeeSession){
        Employee employee2=employeeService.findEmployeeByName(name);//判断名字是否为错误
        Employee employee3=employeeService.findEmployeeByNameAndPassword(name,password);
        if(null==employee2) {//名字错误
            model.addAttribute("nameError","nameError");
            return "forward:/employeeLogin.jsp";
        } else if(null!=employee3) {//账号密码正确
            employeeSession.setAttribute("employee",employee2);
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

    @RequestMapping("addworkAttendenceForEmployee")
    public String addworkAttendenceForEmployee(Model model,HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateString = sdf.format(date);
        Date date1=null;
        try {
            date1 = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //2017-12-12 12:12:12
        Integer day = Integer.valueOf(dateString.substring(8, 10));
        Integer hour = Integer.valueOf(dateString.substring(11, 13));
        Integer min = Integer.valueOf(dateString.substring(14, 16));
        CheckWorkAttendance workAttendance=employeeService.findCheckWorkAttendanceByEIdAndBeginDayLike(employee.getId(),"%-"+day+" %");
        if(workAttendance!=null){
            model.addAttribute("youHaveAlreadyWorkAtendance",11);
            return "employee/workAttandance";
        }else{
            if(hour<=9){
                employeeService.addCheckWorkAttendance(new CheckWorkAttendance(-1,employee.getId(),date1,new Date(),"正常","待定"));
                model.addAttribute("WorkAtendanceIsInTime",11);
                return "employee/workAttandance";
            }else if(hour>9&&hour<12){
                managerService.addReward(new Reward(employee.getId(),"迟到"+(hour-9)+"小时",(hour-9)*20,date1));//迟到1小时扣20元
                employeeService.addCheckWorkAttendance(new CheckWorkAttendance(employee.getId(),date1,new Date(),"迟到","待定"));
                model.addAttribute("WorkAtendanceIsInTime",11);
                return "employee/workAttandance";
            }
            return "employee/workAttandance";
        }
    }


}
