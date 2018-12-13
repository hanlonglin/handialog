package com.project.hanlonglin.classsystem.view.layout.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.hanlonglin.classsystem.R;

/**
 * Created by hanlonglin on 2018/12/12.
 */

public class AlertDialog extends Dialog implements View.OnClickListener {
    public final static int TYPE_SUCCESS=0;
    public final static int TYPE_FAIL=1;

    ImageView image_title,image_close;
    Button btn_ok, btn_cancel;
    TextView txt_title, txt_msg;

    //设置参数
    AlertDialogListener listener = null;
    String title="成功";
    String message="";
    int icon=R.drawable.success;
    boolean showCancel=false;
    int animType=0;
    Context context=null;

    public AlertDialog(@NonNull Context context) {
        super(context);
        this.context=context;
        Log.e("TAG","AlertDialog()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_alert);
        Log.e("TAG","dialog  onCreate");
        initView();

        Window dialogWindow=getWindow();
        dialogWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void initView() {
        image_title = (ImageView) findViewById(R.id.image_title);
        image_close=(ImageView)findViewById(R.id.image_close);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        txt_msg = (TextView) findViewById(R.id.txt_msg);
        txt_title = (TextView) findViewById(R.id.txt_title);

        btn_cancel.setOnClickListener(this);
        btn_ok.setOnClickListener(this);
        image_close.setOnClickListener(this);

        btn_cancel.setVisibility(View.GONE);
    }

    @Override
    public void show() {
        super.show();
        Log.e("TAG","显示");
        image_title.setImageResource(icon);
        txt_title.setText(title);
        txt_msg.setText(message);
        if(showCancel)
            btn_cancel.setVisibility(View.VISIBLE);
        else
            btn_cancel.setVisibility(View.GONE);

        AnimationSet animationSet = new AnimationSet(true);
        if(animType==TYPE_SUCCESS) {
            Animation rotateAnimation = AnimationUtils.loadAnimation(context, R.anim.rotate);
            Animation scaleAnimation = AnimationUtils.loadAnimation(context, R.anim.scale);
            Animation alphaAnimation = AnimationUtils.loadAnimation(context, R.anim.alpha);
            animationSet.addAnimation(rotateAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
        }
        else if(animType==TYPE_FAIL){
            Animation scaleAnimation=AnimationUtils.loadAnimation(context,R.anim.fail_scale);
            animationSet.addAnimation(scaleAnimation);
        }
        image_title.startAnimation(animationSet);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:
                if (listener != null)
                    listener.onConfrim();
                dismiss();
                break;
            case R.id.btn_cancel:
                if (listener != null)
                    listener.onCancel();
                dismiss();
                break;
            case R.id.image_close:
                dismiss();
                break;
        }
    }


    //设置
    public AlertDialog setAlertDialogListener(AlertDialogListener listener) {
        this.listener = listener;
        return this;
    }

    public AlertDialog icon(int id) {
        icon=id;
        return this;
    }

    public AlertDialog showCancel(boolean b) {
        showCancel=b;
        return this;
    }

    public AlertDialog title(String title) {
        Log.e("TAG","dialog settitle");
        this.title=title;
        return this;
    }

    public AlertDialog messsage(String message) {
        this.message=message;
        return this;
    }
    public AlertDialog animtype(int animType){
        this.animType=animType;
        return this;
    }

}
