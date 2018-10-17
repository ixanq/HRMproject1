package com.ixanq.test;

import com.ixanq.entity.ResumeForManager;
import com.ixanq.entity.Visitor;
import com.ixanq.service.VisitorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class VisitorTest {

    @Autowired
    private VisitorService visitorService;
    @Test
    public void login(){
        Visitor visitor1 = visitorService.findByName("aaa");
        System.out.println(visitor1);
    }
    
    @Test
    public void findByNameAndPassword(){
    	Visitor visitor1=visitorService.findByNameAndPassword("bbb","222");
        System.out.println(visitor1);
    }

    @Test
    public void addResumeForManager(){
        ResumeForManager resumeForManager=new ResumeForManager(1,"111","张三","男",26,"共青团员","17333334455","234213423@qq.com","程序员","7000-9000",11,6,"本科","本科","hahahahaahha","未读");
        visitorService.addResumeForManager(resumeForManager);
        System.out.println(resumeForManager);
    }
}
