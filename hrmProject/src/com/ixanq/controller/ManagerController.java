package com.ixanq.controller;

import com.ixanq.entity.*;
import com.ixanq.service.ManagerService;
import com.ixanq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private VisitorService visitorService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }


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
            List<GoInterview> goInterviews=managerService.findGoInterviewByStatus("δ��");
            if(null!=resumes&&resumes.size()!=0){
                model.addAttribute("thereAreMesseges","thereAreMesseges");
            }
            if(null!=goInterviews&&goInterviews.size()!=0){
                model.addAttribute("thereAregoInterviewsMesseges","thereAregoInterviewsMesseges");
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
    @RequestMapping("manageAdvertise")
    public String manageResume(Manager manager, Model model){
        List<Advertises> advertises = managerService.finaAllAdvertise();
        if(advertises==null||advertises.size()==0){
            model.addAttribute("manageAdvertiseEmpty",11);
            return "manager/managerIndexNav";
        }else {
            model.addAttribute("advertises",advertises);
        return "manager/advertise";
        }
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

    @RequestMapping("addAdvertisesforAdmin")
    public String addAdvertisesforAdmin( ){
        return "manager/addAdvertise";
    }

    @RequestMapping("addAdvertiseAndCommit")
    public String addAdvertiseAndCommit(String advertiseName,String salary,Integer needPersonNumber, String advertiseDescreption,Model model){
        Advertises advertises=new Advertises(advertiseName,salary,needPersonNumber,advertiseDescreption);
        System.out.println(advertiseDescreption);
        managerService.addAdvertise(advertises);
        model.addAttribute("addAdvertiseAndCommit",333);
        return "manager/managerIndexNav";
    }

    @RequestMapping("lookTheAdvertiseDetailMasseges")
    public String lookTheAdvertiseDetailMasseges(String id,Model model){
        Integer newId = Integer.valueOf(id);
        if(newId==null){
            model.addAttribute("lookTheAdvertiseDetailMasseges",11);
            return "manager/managerIndexNav";
        }else{
            Advertises advertises = managerService.findAdvertisesById(newId);
            if(advertises==null){
                model.addAttribute("noadvertises",11);
                return "manager/managerIndexNav";
            }
            model.addAttribute("advertises",advertises);
        return "manager/showAdvertise";
        }

    }

    @RequestMapping("ajaxDeleteAdvertiseById")
    @ResponseBody
    public String ajaxDeleteAdvertiseById(Integer id){
        managerService.deleteAdvertiseById(id);
        return "deleteSeccessfully";
    }

    @RequestMapping("interviewforVisitor")
    public String interviewforVisitor(String visitorName, String advertiseId, Date viewTime, Model model){
        Integer advertiseId1 = Integer.valueOf(advertiseId);
        Interview interview=new Interview(visitorName,advertiseId1,viewTime);
        System.out.println(interview);
        Interview interview1 =managerService.findInterviewforVisitorByVisitorName(interview.getVisitorName());
        if(interview1!=null){
            model.addAttribute("visitorViewxist",88);
            return "manager/managerIndexNav";
        }
       managerService.addInterviewforVisitor(interview);
        model.addAttribute("visitorViewSeccessfully",99);
        return "manager/managerIndexNav";
    }

    @RequestMapping("lookAllGoInterview")
    public String lookAllGoInterview(Model model){
        List<GoInterview> goInterviews= managerService.findAllGoInterview();
        if(goInterviews==null||goInterviews.size()==0){
            model.addAttribute("goInterviewsMessegesEmpty",88);
            return "manager/managerIndexNav";
        }else{
            model.addAttribute("goInterviews",goInterviews);
            return "manager/showGoInterview";
        }
    }


    @RequestMapping("lookTheGoInterviewDetailsForAdmin")
    public String lookTheGoInterviewDetailsForAdmin(String id,Model model){
        Integer gointerviewId = Integer.valueOf(id);
        GoInterview goInterview=managerService.findGoInterviewByGointerviewId(gointerviewId);
        //Ҫд¼��δ¼�ã��鿴�ο��������Ϣ�����¼�ã������ο͵���Ϣ��Ա����
        if(goInterview==null){
            model.addAttribute("nogoInterview",88);
            return "manager/managerIndexNav";
        }else{
            model.addAttribute("goInterview",goInterview);
            return "manager/showGoInterviewDetails";
        }
    }


    @RequestMapping("changeToEmployee")
    public String changeToEmployee(String name,Model model){
        List<ResumeForManager>  resumeForManagers=managerService.findResumeForManagerByVisitorName(name);
        if(resumeForManagers==null||resumeForManagers.size()==0){
            model.addAttribute("NochangeToEmployee",11);
            return "manager/managerIndexNav";
        }
        ResumeForManager r=resumeForManagers.get(0);
        Visitor visitor = visitorService.findByName(r.getVisitorName());
        Employee employee=new Employee(-1,visitor.getName(),visitor.getPassword(),r.getName(),r.getGender(),r.getAge(),
                r.getMaster(),r.getEmail(),new Date(),"�ϰ�");
        System.out.println(employee);
        managerService.addEmployee(employee);
        model.addAttribute("changeToEmployeeSeccessfully",44);
        return "manager/managerIndexNav";
    }










}
