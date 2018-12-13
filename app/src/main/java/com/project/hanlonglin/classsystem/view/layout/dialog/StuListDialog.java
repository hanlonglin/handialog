package com.project.hanlonglin.classsystem.view.layout.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.database.model.Student;
import com.project.hanlonglin.classsystem.veiw.diyview.LineWrapLayout;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/13.
 */

public class StuListDialog extends Dialog {
    LineWrapLayout lineWrapLayout;
    ImageView image_close;
    Context context;

    List<Student> stuList;
    public StuListDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_stulist);

        initView();

        Window diaogWindow=getWindow();
        diaogWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    private void initView() {
        lineWrapLayout=(LineWrapLayout)findViewById(R.id.lineWrap_stus);
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
        if(stuList==null) return ;
        for(Student stu:stuList){
            View v= LayoutInflater.from(context).inflate(R.layout.item_stus,null,false);
            if(v instanceof TextView){
                ((TextView)v).setText(stu.getSname());
            }
            lineWrapLayout.addView(v);
        }
    }

    public StuListDialog setStudents(List<Student> stus){
        this.stuList=stus;
        return this;
    }
}
