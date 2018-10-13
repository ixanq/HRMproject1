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
     * @param visitor
     * @param model
     * @return
     */
    @RequestMapping("visitorNav")
    public String visitorNav(Visitor visitor, Model model){
       Visitor visitor2=visitorService.findByName(visitor.getName());//判断名字是否为错误
       Visitor visitor3=visitorService.findByNameAndPassword(visitor);
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
}
