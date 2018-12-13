package com.project.hanlonglin.classsystem.util.item;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class ActionItem {
    String title;
    int res;

    public ActionItem(String title, int res) {
        this.title = title;
        this.res = res;
    }

    public ActionItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
