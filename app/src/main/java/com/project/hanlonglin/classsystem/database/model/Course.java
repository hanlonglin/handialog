package com.project.hanlonglin.classsystem.database.model;

import com.project.hanlonglin.classsystem.database.dao.CourseDao;
import com.project.hanlonglin.classsystem.database.dao.DaoInterface;

import java.io.Serializable;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class Course implements Serializable{
    int cid;
    String cname;
    String caccount;
    int grade;
    int maxNum;
    int num;
    String descrip;

    public Course(String cname, int grade, int maxNum, int num, String descrip) {
        this.cname = cname;
        this.grade = grade;
        this.maxNum = maxNum;
        this.num = num;
        this.descrip = descrip;
        this.caccount=grade+cname;
    }

    public Course() {
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
        setCaccount(grade+cname);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
        setCaccount(grade+cname);
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setCaccount(String caccount) {
        this.caccount = caccount;
    }

    public String getCaccount() {
        return caccount;
    }

    @Override
    public String toString() {
        return "{" +
                "'cname:'"+cname+"," +
                "'caccount:'"+caccount+"," +
                "'grade:'"+grade+"," +
                "'maxNum:'"+maxNum+"," +
                "'num:'"+num+"," +
                "'descrip:'"+descrip +
                "}";
    }
}
