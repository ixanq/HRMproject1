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
     * ���첽ajax ��֤����Ա�治����
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
     * ����Ա��½�����ת������Ա����
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("managerNav")
    public String visitorNav(Manager manager, Model model){
        Manager manager2=managerService.findAdminByName(manager.getName());//�ж������Ƿ�Ϊ����
        Manager manager3=managerService.findAdminByNameAndPassword(manager);
        if(null==manager2) {//���ִ���
            model.addAttribute("nameError","nameError");
            return "forward:/adminLogin.jsp";
        } else if(null!=manager3) {//�˺�������ȷ
            model.addAttribute("manager2", manager2);
            return "manager/managerIndexNav";
        }else{ //�������
            model.addAttribute("manager2", manager2);
            model.addAttribute("passwordError","passwordError");
            return "forward:/adminLogin.jsp";
        }
    }


    /**
     * ����Ա���ڽ���
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mworkAtendance")
    public String workAtendance(Manager manager, Model model){
        return "manager/workAttandance";
    }

    /**
     * ����ԱԱ���������
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageEmployee")
    public String manageEmployee(Manager manager, Model model){
        return "manager/employee";
    }

    /**
     * ����Ա���Ź������
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageDepartment")
    public String manageDepartment(Manager manager, Model model){
        return "manager/department";
    }

    /**
     * ����Աְλ�������
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageWorkPosition")
    public String manageWorkAtendance(Manager manager, Model model){
        return "manager/workPosition";
    }

    /**
     * ����Ա��Ƹ�������
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageResume")
    public String manageResume(Manager manager, Model model){
        return "manager/manageResume";
    }

    /**
     * ����Ա��ѵ�������
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageTrain")
    public String manageTrain(Manager manager, Model model){
        return "manager/train";
    }

    /**
     * ����Ա��ѵ�������
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageSalary")
    public String manageSalary(Manager manager, Model model){
        return "manager/salary";
    }

    /**
     * ����Ա���͹������
     * @param manager
     * @param model
     * @return
     */
    @RequestMapping("mmanageReward")
    public String manageReward(Manager manager, Model model){
        return "manager/reward";
    }


}
