package com.project.hanlonglin.classsystem.database.model;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class CourseManager {
    int sid;
    int cid;
    String date;

    public CourseManager(int sid, int cid, String date) {
        this.sid = sid;
        this.cid = cid;
        this.date = date;
    }

    public CourseManager() {
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSid() {
        return sid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCid() {
        return cid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
