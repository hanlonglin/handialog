package com.project.hanlonglin.handialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.hanlonglin.handialog.R;
import com.project.hanlonglin.handialog.dialog.listener.AlertDialogListener;

/**
 * Created by hanlonglin on 2018/12/13.
 */

public class ConfirmDialog extends BaseDialog implements View.OnClickListener{

    Button btn_ok, btn_cancel;
    TextView txt_title, txt_msg;

    //设置参数
    AlertDialogListener listener = null;
    String title="成功";
    String message="";

    Context context=null;

    public ConfirmDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_confirm);
        initView();
    }

    private void initView() {
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        txt_msg = (TextView) findViewById(R.id.txt_msg);
        txt_title = (TextView) findViewById(R.id.txt_title);

        btn_cancel.setOnClickListener(this);
        btn_ok.setOnClickListener(this);
    }

    @Override
    public void show() {
        super.show();
        txt_title.setText(title);
        txt_msg.setText(message);
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
        }
    }

    public ConfirmDialog title(String title){
        this.title=title;
        return this;
    }
    public ConfirmDialog message(String message){
        this.message=message;
        return this;
    }
}
