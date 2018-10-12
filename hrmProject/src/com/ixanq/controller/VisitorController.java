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
       visitorService.add(visitor);
       return "forward:/visitorLogin.jsp";
    }
    
    /**
     * 游客登陆完后，跳转到游客界面
     * @param visitor
     * @param model
     * @return
     */
    @RequestMapping("visitorNav")
    public String visitorNav(Visitor visitor, Model model){
       Visitor visitor2=visitorService.findByName(visitor.getName());
       if(null==visitor2) {//名字错误
    	   model.addAttribute("nameError","nameError");
    	   return "forward:/visitorLogin.jsp";
       } else if(visitor.getName().equals(visitor2.getName())  &&  visitor.getPassword().equals(visitor2.getPassword())) {
    	   model.addAttribute("visitor2", visitor2);
    	   return "visitor/lookTheResume";
       }else{ //密码错误
    	   model.addAttribute("visitor2", visitor2);
    	   model.addAttribute("passwordError","passwordError");
    	   return "forward:/visitorLogin.jsp";
       }
    }
}
