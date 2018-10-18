package com.ixanq.controller;

import com.alibaba.fastjson.JSON;
import com.ixanq.entity.*;
import com.ixanq.service.ManagerService;
import com.ixanq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private ManagerService managerService;


    /**
     * 用异步ajax 验证用户信息存不存在
     * @param name
     * @return
     */
    @RequestMapping("ajaxCheck")
    @ResponseBody
    public String validate(String name ){
        Visitor visitor1 = visitorService.findByName(name);
        if(null==visitor1){
            return "yes";
        }else {
            return "no";
        }
    }

    /**
     * 游客注册完后，跳转到游客登录页面
     * @param visitor
     * @param model
     * @return
     */
    @RequestMapping("visitorRegist")
    public String regist(Visitor visitor, Model model){
    	 Visitor visitor2=visitorService.findByName(visitor.getName());
         if(null==visitor2) {//在数据库不存在,添加数据
        	 visitorService.add(visitor);
             return "forward:/visitorLogin.jsp";
         }else{ //如果数据库中存在，返回原页面
      	   model.addAttribute("nameExist","nameExist");
      	   return "forward:/index.jsp";
         }
    	
    	
      
    }
    
    /**
     * 游客登陆完后，跳转到游客界面
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("visitorNav")
    public String visitorNav(String name,String password, Model model,HttpSession session){
       Visitor visitor2=visitorService.findByName(name);//判断名字是否为错误
       Visitor visitor3=visitorService.findByNameAndPassword(name,password);
       if(null==visitor2) {//名字错误
    	   model.addAttribute("nameError","nameError");
    	   return "forward:/visitorLogin.jsp";
       } else if(null!=visitor3) {//账号密码正确
    	   session.setAttribute("visitor", visitor2);
           System.out.println("session:"+visitor2);
           Interview byVisitorName = managerService.findInterviewforVisitorByVisitorName(visitor2.getName());
           if(byVisitorName!=null){
               model.addAttribute("youHaveInterviewMessegess",66);
           }
           return "visitor/visitorIndexNav";
       }else{ //密码错误
    	   model.addAttribute("visitor2", visitor2);
    	   model.addAttribute("passwordError","passwordError");
    	   return "forward:/visitorLogin.jsp";
       }
    }

    /**
     * ajax
     * @param id
     * @param printWriter
     */
    @RequestMapping("findAllWorkPosition")
    @ResponseBody
    public void findAllWorkPosition(Integer id, PrintWriter printWriter){
        List<WorkPosition> workPositionsByDepartmentId = managerService.findWorkPositionByDepartmentId(id);
        Object json= JSON.toJSON(workPositionsByDepartmentId);
        printWriter.print(json);

    }


    /**
     * 游客查看简历
     * @return
     */
    @RequestMapping("lookTheResume")
    public String lookTheResume(Model model,HttpSession session){
        Visitor visitor=(Visitor)session.getAttribute("visitor");
        Resume resumeByVisitorName = visitorService.findResumeByVisitorName(visitor.getName());
        System.out.println(visitor);
        if(null==resumeByVisitorName){//没有简历
            System.out.println("2222");
            List<Department> allDepartment = managerService.findAllDepartment();
            model.addAttribute("allDepartment",allDepartment);
            return "visitor/writeResume";
        }else{
            System.out.println("3333");
            Department departmentbyId = managerService.findDepartmentbyId(resumeByVisitorName.getDepartmentId());
            model.addAttribute("departmentbyId",departmentbyId);
            WorkPosition workPositionById = managerService.findWorkPositionById(resumeByVisitorName.getWorkPositionId());
            model.addAttribute("workPositionById",workPositionById);
            model.addAttribute("resumeByVisitorName",resumeByVisitorName);
            return "visitor/lookTheResume";
        }

    }
    /**
     * 填写简历
     * @return
     */
    @RequestMapping("writeResume")
    public String addResume(Model model,HttpSession session){
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Resume resumeByVisitorName = visitorService.findResumeByVisitorName(visitor.getName());
        if(null==resumeByVisitorName){
            List<Department> allDepartment = managerService.findAllDepartment();
            model.addAttribute("allDepartment",allDepartment);
            return "visitor/writeResume";
        }else{
            model.addAttribute("resumeExist","resumeExist");
            return "visitor/visitorIndexNav";
        }
    }


    /**
     * 往数据库提交简历
     */
    @RequestMapping("writeResumeAndCommit")
    public String resumeCommit(String name,String gender,Integer age,String politicalStatus,String tel,String email,String lastWork,
           String salary,Integer departmentId,Integer workPositionId ,String master,String workBackground,String hobby,String visitorName ,Model model){
        Resume resume = new Resume(visitorName,name, gender, age, politicalStatus, tel, email, lastWork, salary, departmentId, workPositionId, master, workBackground, hobby);
        System.out.println(resume);
       visitorService.addResume(new Resume(visitorName,name,gender,age,politicalStatus,tel,email,lastWork,salary,departmentId,workPositionId,master,workBackground,hobby));
       model.addAttribute("addSeccessfully","addSeccessfully");
        return "visitor/visitorIndexNav";
    }

    /**
     * 修改简历
     * @return
     */
    @RequestMapping("updateResume")
    public String updateResume(HttpSession session,Model model){
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Resume resumeByVisitorName = visitorService.findResumeByVisitorName(visitor.getName());
        if(null==resumeByVisitorName){
            model.addAttribute("pleaseRewriteAgAin","pleaseRewriteAgAin");
            return "visitor/visitorIndexNav";
        }else{
            model.addAttribute("resumeByVisitorName",resumeByVisitorName);
            List<Department> allDepartment = managerService.findAllDepartment();
            model.addAttribute("allDepartment",allDepartment);
            return "visitor/updateResume";
        }
    }

    /**
     * 修改后的简历提交
     * @return
     */
    @RequestMapping("updateAndCommitResume")
    public String updateAndCommitResume(Integer resumeId,String name,String gender,Integer age,String politicalStatus,String tel,String email,String lastWork,
                               String salary,Integer departmentId,Integer workPositionId ,String master,String workBackground,String hobby,String visitorName ,Model model){
        Resume resume = new Resume(resumeId,visitorName,name, gender, age, politicalStatus, tel, email, lastWork, salary, departmentId, workPositionId, master, workBackground, hobby);
        System.out.println(resume);
        visitorService.updateResume(new Resume(resumeId,visitorName,name,gender,age,politicalStatus,tel,email,lastWork,salary,departmentId,workPositionId,master,workBackground,hobby));
        model.addAttribute("updateSeccessfully","updateSeccessfully");
        return "visitor/visitorIndexNav";
    }

    /**
     * 投递简历
     *
     */
    @RequestMapping("sendResume")
    public String sendResume(String id,HttpSession session,Model model){
        Integer advertiseId = Integer.valueOf(id);
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Resume resumeByVisitorName = visitorService.findResumeByVisitorName(visitor.getName());
        if(null==resumeByVisitorName){
            model.addAttribute("plesaseWriteAgain","plesaseWriteAgain");
            return "visitor/visitorIndexNav";
        }else{
            Resume r=resumeByVisitorName;
            ResumeForManager resumeForManager=new ResumeForManager(advertiseId,r.getVisitorName(),r.getName(),
                    r.getGender(),r.getAge(),r.getPoliticalStatus(),r.getTel(),r.getEmail(),r.getLastWork(),
                    r.getSalary(),r.getDepartmentId(),r.getWorkPositionId(),r.getMaster(),r.getWorkBackground(),
                    r.getHobbies(),"未读");
            System.out.println(resumeForManager);
            ResumeForManager resumeForManager1=visitorService.findResumeForManagerByAdvertiseId(advertiseId);
            if(resumeForManager1!=null){
                model.addAttribute("resumeForManagerIsExist","111");
                return "visitor/visitorIndexNav";
            }
            visitorService.addResumeForManager(resumeForManager);
            model.addAttribute("sendResumeisSeccessfully","sendResumeisSeccessfully");
            return "visitor/visitorIndexNav";
        }
    }

    @RequestMapping("lookAdvertiseForVisitor")
    public String manageResume( Model model){
        List<Advertises> advertises = managerService.finaAllAdvertise();
        if(advertises==null||advertises.size()==0){
            model.addAttribute("manageAdvertiseEmpty",11);
            return "visitor/visitorIndexNav";
        }else {
            model.addAttribute("advertises",advertises);
            return "visitor/advertise";
        }
    }


    @RequestMapping("lookInterviewForVisitor")
    public String lookInterviewForVisitor(HttpSession session,Model model){
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Interview interview = managerService.findInterviewforVisitorByVisitorName(visitor.getName());
        if(interview==null){
            model.addAttribute("thereAreNoInterviewMesseges",33);
            return "visitor/visitorIndexNav";
        }else {
            model.addAttribute("interview",interview);
            return "visitor/showInterview";
        }

    }

    @RequestMapping("lookAdvertiseDetailMasseges")
    public String lookTheAdvertiseDetailMasseges(String id,Model model) {
        Integer newId = Integer.valueOf(id);
        if (newId == null) {
            model.addAttribute("lookTheAdvertiseDetailMasseges", 11);
            return "visitor/visitorIndexNav";
        } else {
            Advertises advertises = managerService.findAdvertisesById(newId);
            if (advertises == null) {
                model.addAttribute("noadvertises", 11);
                return "visitor/visitorIndexNav";
            }
            model.addAttribute("advertises", advertises);
            return "visitor/showAdvertise";
        }
    }


    @RequestMapping("gotoInterview")
    public String gotoInterview(String id,Model model,HttpSession session ){
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Integer interviewId = Integer.valueOf(id);
        GoInterview goInterview=new GoInterview(visitor.getName(),"未读","待定");
        visitorService.addGoInterview(goInterview);
        return "visitor/visitorIndexNav";
    }





















}
