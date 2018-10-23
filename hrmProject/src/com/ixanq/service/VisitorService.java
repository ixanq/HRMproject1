package com.ixanq.service;

import com.ixanq.entity.GoInterview;
import com.ixanq.entity.Resume;
import com.ixanq.entity.ResumeForManager;
import com.ixanq.entity.Visitor;

import java.util.List;

public interface VisitorService {
	
	public Visitor findByNameAndPassword(String name,String password);
    public List<Visitor> showAll();
    public Visitor findByName(String name);
    public void add(Visitor visitor);
    public void updatePassword(Visitor visitor);


    public List<Resume> findAllResume();
    public void addResume(Resume resume);
    Resume findResumeByVisitorName(String visitorName);

    void addResumeForManager(ResumeForManager resumeForManager);
    List<ResumeForManager> findAllResumeForManager();

    void updateResume(Resume resume);

    ResumeForManager findResumeForManagerByAdvertiseId(Integer visitorName);

    void addGoInterview(GoInterview goInterview);

    ResumeForManager findResumeForManagerByAdvertiseIdAndVisitorName(Integer advertiseId, String name);
}
