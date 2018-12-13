package com.project.hanlonglin.classsystem.database.model;

import java.io.Serializable;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class Student implements Serializable{
    int sid;
    int age;
    String sname;
    String sex;
    String spasswd;
    int grade;

    public Student( int age, String sname, String sex, String spasswd, int grade) {
        this.age = age;
        this.sname = sname;
        this.sex = sex;
        this.spasswd = spasswd;
        this.grade = grade;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSpasswd() {
        return spasswd;
    }

    public void setSpasswd(String spasswd) {
        this.spasswd = spasswd;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
