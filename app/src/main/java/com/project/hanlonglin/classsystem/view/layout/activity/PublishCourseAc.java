package com.project.hanlonglin.classsystem.view.layout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.database.dao.CourseDao;
import com.project.hanlonglin.classsystem.database.model.Course;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialog;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialogListener;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class PublishCourseAc extends AppCompatActivity implements View.OnClickListener {
    ImageView image_back, image_ok;
    Spinner sp_name, sp_grade;
    EditText ed_max, ed_descrip;

    CourseDao courseDao=null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_course);
        initView();
        courseDao=new CourseDao(this);
    }

    private void initView() {
        image_back = (ImageView) findViewById(R.id.image_back);
        image_ok = (ImageView) findViewById(R.id.image_ok);
        sp_name = (Spinner) findViewById(R.id.sp_name);
        sp_grade = (Spinner) findViewById(R.id.sp_grade);
        ed_max = (EditText) findViewById(R.id.ed_max);
        ed_descrip = (EditText) findViewById(R.id.ed_descrip);

        image_back.setOnClickListener(this);
        image_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                finish();
                overridePendingTransition(0,R.anim.top_to_bottom);
                break;
            case R.id.image_ok:
                publishCourse();
                break;
        }
    }

    private void publishCourse() {
        String name = sp_name.getSelectedItem().toString();
        String grade = sp_grade.getSelectedItem().toString();
        String max = ed_max.getText().toString();
        String descrip = ed_descrip.getText().toString();
        if (TextUtils.isEmpty(name)
                || TextUtils.isEmpty(grade)
                || TextUtils.isEmpty(max)) {
            Toast.makeText(this, "字段不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        Course course=new Course(name,Integer.parseInt(grade),Integer.parseInt(max),0,descrip);
        boolean b=courseDao.add(course);
        if(b){
            new AlertDialog(this)
                    .title("发布成功")
                    .messsage("是否继续发布？")
                    .showCancel(true)
                    .setAlertDialogListener(new AlertDialogListener() {
                        @Override
                        public void onCancel() {
                            finish();
                        }

                        @Override
                        public void onConfrim() {
                        }
                    }).show();
        }else{
            new AlertDialog(this)
                    .title("发布失败")
                    .messsage("可能已经存在该课程！是否继续发布？")
                    .icon(R.drawable.fail)
                    .showCancel(true)
                    .setAlertDialogListener(new AlertDialogListener() {
                        @Override
                        public void onCancel() {
                            finish();
                        }

                        @Override
                        public void onConfrim() {

                        }
                    }).show();
        }
    }
}
