package com.ixanq.controller;

import com.ixanq.entity.Visitor;
import com.ixanq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

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
     * @param visitor
     * @param model
     * @return
     */
    @RequestMapping("visitorNav")
    public String visitorNav(Visitor visitor, Model model){
       Visitor visitor2=visitorService.findByName(visitor.getName());//�ж������Ƿ�Ϊ����
       Visitor visitor3=visitorService.findByNameAndPassword(visitor);
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
}
