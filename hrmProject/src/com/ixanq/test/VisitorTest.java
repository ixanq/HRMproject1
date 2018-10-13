package com.ixanq.test;

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
    	Visitor visitor=new Visitor("bbb","222");
    	Visitor visitor1=visitorService.findByNameAndPassword(visitor);
        System.out.println(visitor1);
    }
}
