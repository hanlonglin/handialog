package com.project.hanlonglin.classsystem.database.dao;

import com.project.hanlonglin.classsystem.database.model.Teacher;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class TeacherDao implements DaoInterface<Teacher> {

    @Override
    public boolean add(Teacher o) {
        return false;
    }

    @Override
    public boolean delete(String whereStr) {
        return false;
    }

    @Override
    public boolean update(Teacher o, String whereStr) {
        return false;
    }

    @Override
    public List<Teacher> select(String whereStr) {
        return null;
    }
}
