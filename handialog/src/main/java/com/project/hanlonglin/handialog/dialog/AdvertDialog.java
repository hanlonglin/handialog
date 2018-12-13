package com.project.hanlonglin.handialog.dialog;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.project.hanlonglin.handialog.R;
import com.project.hanlonglin.handialog.dialog.listener.ConfirmListener;
import com.project.hanlonglin.handialog.util.ImageLoader;

/**
 * Created by hanlonglin on 2018/12/13.
 */

/**
 * 广告对话框
 */

public class AdvertDialog extends BaseDialog implements View.OnClickListener {
    public final static int TYPE_HTTP=0;
    public final static int TYPE_ID=1;

    ImageView image_advert, image_close;

    ConfirmListener listener = null;
    Context context;
    int imageId=R.drawable.advert;
    String imageUrl="";
    int imageType=1;

    public AdvertDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_advert);
        initView();
    }

    private void initView() {
        image_advert = (ImageView) findViewById(R.id.image_advert);
        image_close = (ImageView) findViewById(R.id.image_close);

        image_advert.setOnClickListener(this);
        image_close.setOnClickListener(this);
    }

    @Override
    public void show() {
        super.show();
        image_advert.setImageResource(imageId);

        if(imageType==TYPE_ID){
            ImageLoader.ShowImageById(context,imageId,image_advert);
        }
        else if(imageType==TYPE_HTTP){
            ImageLoader.ShowImageByURl(context,imageUrl,image_advert);
        }
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.image_advert) {
            if (listener != null)
                listener.onClick();
            dismiss();
        } else if (i == R.id.image_close) {
            dismiss();
        }
    }

    public AdvertDialog image(int rid) {
        imageId = rid;
        return this;
    }
    public AdvertDialog url(String url) {
        imageUrl = url;
        return this;
    }
    public AdvertDialog showType(int type) {
        imageType = type;
        return this;
    }

    public AdvertDialog setConfirmListener(ConfirmListener listener) {
        this.listener = listener;
        return this;
    }
}
