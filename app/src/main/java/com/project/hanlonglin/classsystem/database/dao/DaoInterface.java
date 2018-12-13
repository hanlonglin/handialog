package com.project.hanlonglin.classsystem.database.dao;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public interface DaoInterface<T> {

    public boolean add(T o);

    public boolean delete(String whereStr);

    public boolean update(T o,String whereStr);

    public List<T> select(String whereStr);
}
