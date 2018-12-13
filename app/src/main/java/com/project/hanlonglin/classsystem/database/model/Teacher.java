package com.project.hanlonglin.classsystem.database.model;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class Teacher {
    int tid;
    String tname;
    String tpasswd;
    int age;
    int sex;

    public Teacher(int tid, String tname, String tpasswd, int age, int sex) {
        this.tid = tid;
        this.tname = tname;
        this.tpasswd = tpasswd;
        this.age = age;
        this.sex = sex;
    }

    public Teacher() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpasswd() {
        return tpasswd;
    }

    public void setTpasswd(String tpasswd) {
        this.tpasswd = tpasswd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
