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
     * ���첽ajax ��֤�û���Ϣ�治����
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
     * �ο�ע�������ת���ο͵�¼ҳ��
     * @param visitor
     * @param model
     * @return
     */
    @RequestMapping("visitorRegist")
    public String regist(Visitor visitor, Model model){
    	 Visitor visitor2=visitorService.findByName(visitor.getName());
         if(null==visitor2) {//�����ݿⲻ����,�������
        	 visitorService.add(visitor);
             return "forward:/visitorLogin.jsp";
         }else{ //������ݿ��д��ڣ�����ԭҳ��
      	   model.addAttribute("nameExist","nameExist");
      	   return "forward:/index.jsp";
         }
    	
    	
      
    }
    
    /**
     * �ο͵�½�����ת���οͽ���
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("visitorNav")
    public String visitorNav(String name,String password, Model model){
       Visitor visitor2=visitorService.findByName(name);//�ж������Ƿ�Ϊ����
       Visitor visitor3=visitorService.findByNameAndPassword(name,password);
       if(null==visitor2) {//���ִ���
    	   model.addAttribute("nameError","nameError");
    	   return "forward:/visitorLogin.jsp";
       } else if(null!=visitor3) {//�˺�������ȷ
    	   model.addAttribute("visitor2", visitor2);
    	   return "visitor/visitorIndexNav";
       }else{ //�������
    	   model.addAttribute("visitor2", visitor2);
    	   model.addAttribute("passwordError","passwordError");
    	   return "forward:/visitorLogin.jsp";
       }
    }


    /**
     * �οͲ鿴����
     * @return
     */
    @RequestMapping("lookTheResume")
    public String lookTheResume(Model model){
        List<Resume> allResume = visitorService.findAllResume();
        if(null==allResume ||allResume.size()==0){//û�м���
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
     * ��д����
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
     * �޸ļ���
     * @return
     */
    @RequestMapping("updateResume")
    public String updateResume(){
        return "visitor/updateResume";
    }




}
