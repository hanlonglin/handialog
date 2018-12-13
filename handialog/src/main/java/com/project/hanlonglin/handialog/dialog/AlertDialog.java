package com.project.hanlonglin.handialog.dialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.hanlonglin.handialog.R;
import com.project.hanlonglin.handialog.dialog.listener.AlertDialogListener;

/**
 * Created by hanlonglin on 2018/12/12.
 */

public class AlertDialog extends BaseDialog implements View.OnClickListener {
    public final static int TYPE_SUCCESS=0;
    public final static int TYPE_FAIL=1;
    public final static int TYPE_WARN=2;

    ImageView image_title,image_close;
    Button btn_ok, btn_cancel;
    TextView txt_title, txt_msg;

    //设置参数
    AlertDialogListener listener = null;
    String title="成功";
    String message="";
    int icon=R.drawable.handialog_success;
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

//        Window dialogWindow=getWindow();
//        dialogWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
        if(animType==TYPE_SUCCESS) {
            ObjectAnimator rotate=new ObjectAnimator().ofFloat(image_title,"rotation",0f,360f);
            ObjectAnimator scaleX=new ObjectAnimator().ofFloat(image_title,"scaleX",0f,1f);
            ObjectAnimator scaleY=new ObjectAnimator().ofFloat(image_title,"scaleY",0f,1f);
            ObjectAnimator alpha=new ObjectAnimator().ofFloat(image_title,"alpha",0f,1f);
            AnimatorSet animatorSet=new AnimatorSet();
            animatorSet.setDuration(1000);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.play(rotate).with(scaleX).with(scaleY).with(alpha);
            animatorSet.start();
        }
        else if(animType==TYPE_FAIL){
            ObjectAnimator scaleX=new ObjectAnimator().ofFloat(image_title,"scaleX",0.8f,1f,1.2f,1f);
            ObjectAnimator scaley=new ObjectAnimator().ofFloat(image_title,"scaleY",0.8f,1f,1.2f,1f);
            AnimatorSet animatorSet=new AnimatorSet();
            animatorSet.setDuration(1000);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            animatorSet.play(scaleX).with(scaley);
            animatorSet.start();
        }
        else if(animType==TYPE_WARN){
            ObjectAnimator animator=new ObjectAnimator().ofFloat(image_title,"rotation",-45f,0f,45f,0f,-45f,0f);
            animator.setDuration(1000);
            animator.start();
        }
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_ok) {
            if (listener != null)
                listener.onConfrim();
            dismiss();

        } else if (i == R.id.btn_cancel) {
            if (listener != null)
                listener.onCancel();
            dismiss();

        } else if (i == R.id.image_close) {
            dismiss();

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
