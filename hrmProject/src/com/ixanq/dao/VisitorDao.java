package com.ixanq.dao;

import com.ixanq.entity.GoInterview;
import com.ixanq.entity.Resume;
import com.ixanq.entity.ResumeForManager;
import com.ixanq.entity.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VisitorDao {
	
	public Visitor findByNameAndPassword(@Param("name") String name,@Param("password") String Password);
    public List<Visitor>  showAll();
    public Visitor findByName(String name);
    public void add(Visitor visitor);
    public void updatePassword(Visitor visitor);

    public List<Resume> findAllResume();
    void addResume(Resume resume);
    Resume findResumeByVisitorName(String visitorName);
    void addResumeForManager(ResumeForManager resumeForManager);
    List<ResumeForManager> findAllResumeForManager();


    void updateResume(Resume resume);

    ResumeForManager findResumeForManagerByAdvertiseId(Integer advertiseId);

    void addGoInterview(GoInterview goInterview);

    ResumeForManager findResumeForManagerByAdvertiseIdAndVisitorName(@Param("advertiseId") Integer advertiseId,@Param("name") String name);
}
