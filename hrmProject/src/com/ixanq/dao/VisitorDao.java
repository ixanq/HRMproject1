package com.ixanq.dao;

import com.ixanq.entity.Visitor;

import java.util.List;

public interface VisitorDao {
    public List<Visitor>  showAll();

    public Visitor findByName(String name);

    public void add(Visitor visitor);

    public void updatePassword(Visitor visitor);
}
