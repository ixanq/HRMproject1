package com.ixanq.service.serviceImpl;

import com.ixanq.dao.VisitorDao;
import com.ixanq.entity.Resume;
import com.ixanq.entity.Visitor;
import com.ixanq.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorDao visitorDao;

    @Override
    public Visitor findByNameAndPassword(String name, String password) {
        return visitorDao.findByNameAndPassword(name, password);
    }

    @Override
    public List<Visitor> showAll() {
        return visitorDao.showAll();
    }

    @Override
    public Visitor findByName(String name) {
        return visitorDao.findByName(name);
    }

    @Override
    public void add(Visitor visitor) {
            visitorDao.add(visitor);
    }

    @Override
    public void updatePassword(Visitor visitor) {
        visitorDao.updatePassword(visitor);
    }

    @Override
    public List<Resume> findAllResume() {
        return visitorDao.findAllResume();
    }

    @Override
    public void addResume(Resume resume) {
        visitorDao.addResume(resume);
    }


}
