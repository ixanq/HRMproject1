package com.ixanq.controller;

import com.ixanq.entity.Department;
import com.ixanq.entity.Manager;
import com.ixanq.entity.Resume;
import com.ixanq.entity.ResumeForManager;
import com.ixanq.service.ManagerService;
import com.ixanq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String visitorNav(Manager manager, Model model, HttpSession managerSession){
        Manager manager2=managerService.findAdminByName(manager.getName());//�ж������Ƿ�Ϊ����
        Manager manager3=managerService.findAdminByNameAndPassword(manager);
        if(null==manager2) {//���ִ���
            model.addAttribute("nameError","nameError");
            return "forward:/adminLogin.jsp";
        } else if(null!=manager3) {//�˺�������ȷ
            List<ResumeForManager> resumes=managerService.findResumeByStatus("δ��");
            if(null!=resumes&&resumes.size()!=0){
                model.addAttribute("thereAreMesseges","thereAreMesseges");
            }
            managerSession.setAttribute("manager",manager2);
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

    /**
     * ������ɾ
     */
    @RequestMapping("lookAndDeleteResume")
    public String lookAndDeleteResume( Model model)
    {
        List<ResumeForManager> resumesForManager= managerService.findAllResumeForManager();
        if(resumesForManager==null||resumesForManager.size()==0){
            model.addAttribute("thereIsNoMesseges","thereIsNoMesseges");
            return "manager/managerIndexNav";
        }else{
            model.addAttribute("resumesForManager",resumesForManager);
        return "manager/showResume";
        }
    }

    @RequestMapping("lookTheResumeDetailsForAdmin")
    public String lookTheResumeDetailsForAdmin(String id,Model model){
        if(null==id){
            model.addAttribute("messegesIsDelete",111);
            return "manager/managerIndexNav";
        }
        Integer newId = Integer.valueOf(id);
        ResumeForManager resumeForManager=managerService.findResumeById(newId);
        System.out.println(resumeForManager);
        if(null==resumeForManager){//û�м���
            System.out.println("2222");
            model.addAttribute("empityResumeMasseges",333);
            return "manager/managerIndexNav";
        }else{
            System.out.println("3333");
            model.addAttribute("resumeForManager",resumeForManager);
            return "manager/lookMResume";
        }

    }
    @RequestMapping("alterResumeStatus")
    @ResponseBody
    public String alterResumeStatus(Integer id ){
        ResumeForManager resumeById = managerService.findResumeById(id);
        System.out.println(resumeById);
        managerService.updateResumeStatusForManager(resumeById);
        return "yes";
    }

    @RequestMapping("ajaxDeleteResumeForManagerById")
    @ResponseBody
    public String ajaxDeleteResumeForManagerById(Integer id ){
        managerService.deleteResumeForManagerById(id);
        return "yes";
    }


}
