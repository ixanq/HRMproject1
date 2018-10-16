package com.ixanq.controller;

import com.alibaba.fastjson.JSON;
import com.ixanq.entity.*;
import com.ixanq.service.ManagerService;
import com.ixanq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String visitorNav(String name,String password, Model model){
       Visitor visitor2=visitorService.findByName(name);//判断名字是否为错误
       Visitor visitor3=visitorService.findByNameAndPassword(name,password);
       if(null==visitor2) {//名字错误
    	   model.addAttribute("nameError","nameError");
    	   return "forward:/visitorLogin.jsp";
       } else if(null!=visitor3) {//账号密码正确
    	   model.addAttribute("visitor2", visitor2);
    	   return "visitor/visitorIndexNav";
       }else{ //密码错误
    	   model.addAttribute("visitor2", visitor2);
    	   model.addAttribute("passwordError","passwordError");
    	   return "forward:/visitorLogin.jsp";
       }
    }


    /**
     * 游客查看简历
     * @return
     */
    @RequestMapping("lookTheResume")
    public String lookTheResume(Model model){
        List<Resume> allResume = visitorService.findAllResume();
        if(null==allResume ||allResume.size()==0){//没有简历
            return "visitor/writeResume";
        }else{
            Resume resume = allResume.get(0);
            Department departmentbyId = managerService.findDepartmentbyId(resume.getDepartmentId());
            model.addAttribute("departmentbyId",departmentbyId);
            WorkPosition workPositionById = managerService.findWorkPositionById(resume.getWorkPositionId());
            model.addAttribute("workPositionById",workPositionById);
            model.addAttribute("allResume",allResume);
            return "visitor/lookTheResume";
        }

    }

    @RequestMapping("findAllWorkPosition")
    @ResponseBody
    public void findAllWorkPosition(Integer id, PrintWriter printWriter){
        List<WorkPosition> workPositionsByDepartmentId = managerService.findWorkPositionByDepartmentId(id);
        Object json= JSON.toJSON(workPositionsByDepartmentId);
        printWriter.print(json);

    }
    /**
     * 填写简历
     * @return
     */
    @RequestMapping("writeResume")
    public String addResume(Model model){
        List<Resume> allResume = visitorService.findAllResume();
        if(null==allResume ||allResume.size()==0){
            List<Department> allDepartment = managerService.findAllDepartment();
            model.addAttribute("allDepartment",allDepartment);
            return "visitor/writeResume";
        }else{
            model.addAttribute("resumeExist","resumeExist");
            return "visitor/visitorIndexNav";
        }
    }


    @RequestMapping("writeResumeAndCommit")
    public String resumeCommit(String name,String gender,Integer age,String politicalStatus,String tel,String email,String lastWork,
           String salary,Integer departmentId,Integer workPositionId ,String master,String workBackground,String hobby ,Model model){
        Resume resume = new Resume(name, gender, age, politicalStatus, tel, email, lastWork, salary, departmentId, workPositionId, master, workBackground, hobby);
        System.out.println(resume);
       visitorService.addResume(new Resume(name,gender,age,politicalStatus,tel,email,lastWork,salary,departmentId,workPositionId,master,workBackground,hobby));
       model.addAttribute("addSeccessfully","addSeccessfully");
        return "visitor/visitorIndexNav";
    }

    /**
     * 修改简历
     * @return
     */
    @RequestMapping("updateResume")
    public String updateResume(){
        return "visitor/updateResume";
    }




}
