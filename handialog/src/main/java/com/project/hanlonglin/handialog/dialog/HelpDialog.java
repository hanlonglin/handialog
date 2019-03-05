package com.project.hanlonglin.handialog.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.hanlonglin.handialog.R;

/**
 * Created by hanlonglin on 2018/12/16.
 */

public class HelpDialog extends BaseDialog {
    public final static int STYLE_BOOK=1;
    public final static int STYLE_COMPUTER=2;
    public final static int STYLE_PAPER=3;

    TextView txt_msg;
    ImageView image_close;

    String message;
    int style=1;

    public HelpDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_help);
        initView();
    }

    private void initView() {
        txt_msg = (TextView) findViewById(R.id.txt_msg);
        image_close=(ImageView)findViewById(R.id.image_close);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void show() {
        super.show();

        txt_msg.setText(message);
        if(style==STYLE_BOOK){
            txt_msg.setBackgroundResource(R.drawable.help_dialog_bg6);
            txt_msg.setTextColor(getContext().getResources().getColor(R.color.colorWhite));
        }
        else if(style==STYLE_COMPUTER){
            txt_msg.setBackgroundResource(R.drawable.help_dialog_bg8);
            txt_msg.setTextColor(getContext().getResources().getColor(R.color.colorWhite));
        }
        else if(style==STYLE_PAPER){
            txt_msg.setBackgroundResource(R.drawable.help_dialog_bg9);
            txt_msg.setTextColor(getContext().getResources().getColor(R.color.colorLittleBlack));
        }
    }


    public HelpDialog message(String message){
        this.message=message;
        return this;
    }

    public HelpDialog style(int style){
        this.style=style;
        return this;
    }
}
