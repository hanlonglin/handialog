package com.project.hanlonglin.classsystem.util.item;

/**
 * Created by hanlonglin on 2018/12/17.
 */

public class MessageItem {
    public final static int TYPE_SEND=1;
    public final static int TYPE_REC=2;

    int type;
    String content;

    public MessageItem(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public static int getTypeSend() {
        return TYPE_SEND;
    }

    public static int getTypeRec() {
        return TYPE_REC;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
