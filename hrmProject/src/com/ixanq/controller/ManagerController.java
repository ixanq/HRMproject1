package com.ixanq.controller;

import com.ixanq.entity.Manager;
import com.ixanq.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /**
     * 用异步ajax 验证管理员存不存在
     * @param name
     * @return
     */
    @RequestMapping("ajaxCheckManager")
    @ResponseBody
    public String validate(String name ){
        Manager manager = managerService.findAdminByName(name);
        if(null==manager){
            return "yes";
        }else {
            return "no";
        }
    }


    /**
     * 管理员登陆完后，跳转到管理员界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("managerNav")
    public String visitorNav(Manager manager, Model model){
        Manager manager2=managerService.findAdminByName(manager.getName());//判断名字是否为错误
        Manager manager3=managerService.findAdminByNameAndPassword(manager);
        if(null==manager2) {//名字错误
            model.addAttribute("nameError","nameError");
            return "forward:/adminLogin.jsp";
        } else if(null!=manager3) {//账号密码正确
            model.addAttribute("manager2", manager2);
            return "manager/managerIndexNav";
        }else{ //密码错误
            model.addAttribute("manager2", manager2);
            model.addAttribute("passwordError","passwordError");
            return "forward:/adminLogin.jsp";
        }
    }


    /**
     * 管理员考勤界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mworkAtendance")
    public String workAtendance(Manager manager, Model model){
        return "manager/workAttandance";
    }

    /**
     * 管理员员工管理界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageEmployee")
    public String manageEmployee(Manager manager, Model model){
        return "manager/employee";
    }

    /**
     * 管理员部门管理界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageDepartment")
    public String manageDepartment(Manager manager, Model model){
        return "manager/department";
    }

    /**
     * 管理员职位管理界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageWorkPosition")
    public String manageWorkAtendance(Manager manager, Model model){
        return "manager/workPosition";
    }

    /**
     * 管理员招聘管理界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageResume")
    public String manageResume(Manager manager, Model model){
        return "manager/manageResume";
    }

    /**
     * 管理员培训管理界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageTrain")
    public String manageTrain(Manager manager, Model model){
        return "manager/train";
    }

    /**
     * 管理员培训管理界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageSalary")
    public String manageSalary(Manager manager, Model model){
        return "manager/salary";
    }

    /**
     * 管理员奖惩管理界面
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageReward")
    public String manageReward(Manager manager, Model model){
        return "manager/reward";
    }


}
