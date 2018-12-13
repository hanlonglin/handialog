package com.project.hanlonglin.classsystem.util.item;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class GradeItem {
    String title;
    int imageSrc;

    public GradeItem(String title, int imageSrc) {
        this.title = title;
        this.imageSrc = imageSrc;
    }

    public GradeItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }
}
