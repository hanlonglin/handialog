package com.project.hanlonglin.handialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.hanlonglin.handialog.R;
import com.project.hanlonglin.handialog.diyview.LineWrapLayout;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/13.
 */

public class LineWrapDialog extends BaseDialog {
    LineWrapLayout lineWrapLayout;
    ImageView image_close;
    Context context;

    List<View> viewList;
    public LineWrapDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_line_wrap);

        initView();

        Window diaogWindow=getWindow();
        diaogWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void initView() {
        lineWrapLayout=(LineWrapLayout)findViewById(R.id.lineWrap_views);
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
        if(viewList==null) return ;
        for(View v:viewList){
            lineWrapLayout.addView(v);
        }
    }

    public LineWrapDialog setViews(List<View> views){
        this.viewList=views;
        return this;
    }
}
