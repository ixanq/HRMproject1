package com.ixanq.controller;

import com.ixanq.service.ManagerService;
import com.ixanq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommonController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private VisitorService visitorService;


    @RequestMapping("employeeSignOut")
    public String employeeSignOut(Model model, HttpSession session){
        session.removeAttribute("employee");
        return "forward:/employeeLogin.jsp";
    }

    @RequestMapping("visitorSignOut")
    public String visitorSignOut(Model model, HttpSession session){
        session.removeAttribute("visitor");
        return "forward:/visitorLogin.jsp";
    }

    @RequestMapping("managerSignOut")
    public String managerSignOut(Model model, HttpSession session){
        session.removeAttribute("manager");
        return "forward:/adminLogin.jsp";
    }




}
