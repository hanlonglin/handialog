package com.project.hanlonglin.classsystem.util.item;

/**
 * Created by hanlonglin on 2018/12/17.
 */

public class TaobaoItem {
    int imageId;
    String descrip;
    String title;

    public TaobaoItem() {
    }

    public TaobaoItem(int imageId, String descrip, String title) {
        this.imageId = imageId;
        this.descrip = descrip;
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
