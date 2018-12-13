package com.project.hanlonglin.classsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.hanlonglin.classsystem.database.dao.StudentDao;
import com.project.hanlonglin.classsystem.database.model.Student;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialog;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialogListener;

/**
 * Created by hanlonglin on 2018/12/12.
 */

public class RegisterInfoActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner sp_age, sp_grade;
    RadioGroup raGroup_sex;
    Button btn_finish;

    StudentDao stuDao;
    Student stu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_info);
        initView();
        stuDao = new StudentDao(this);
        stu = (Student) getIntent().getSerializableExtra("student");

    }

    private void initView() {
        sp_age = (Spinner) findViewById(R.id.sp_age);
        sp_grade = (Spinner) findViewById(R.id.sp_grade);
        raGroup_sex = (RadioGroup) findViewById(R.id.raGroup_sex);
        btn_finish = (Button) findViewById(R.id.btn_finish);

        btn_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_finish:
                finishInfo();
                break;
        }
    }

    private void finishInfo() {
        if (stu == null) {
            Toast.makeText(this, "异常，请重新注册！", Toast.LENGTH_SHORT).show();
            return;
        }
        String age = sp_age.getSelectedItem().toString();
        String grade = sp_grade.getSelectedItem().toString();
        String sex = "男";
        if (raGroup_sex.getCheckedRadioButtonId() == R.id.ra_man) {
            sex = "男";
        } else {
            sex = "女";
        }
        if (TextUtils.isEmpty(age)
                || TextUtils.isEmpty(grade)
                || TextUtils.isEmpty(sex)) {
            Toast.makeText(this, "不允许有空值", Toast.LENGTH_SHORT).show();
            return;
        }
        stu.setAge(Integer.parseInt(age));
        stu.setGrade(Integer.parseInt(grade));
        stu.setSex(sex);
        boolean b=stuDao.add(stu);
        if(b) {
            new AlertDialog(this)
                    .title("注册成功")
                    .messsage("是否前往登陆页面登陆？")
                    .showCancel(true)
                    .setAlertDialogListener(new AlertDialogListener() {
                        @Override
                        public void onCancel() {
                            finish();
                        }

                        @Override
                        public void onConfrim() {
                            gotoLogin();
                        }
                    }).show();
        }else{
            new AlertDialog(this)
                    .title("注册失败")
                    .messsage("用户名重复")
                    .animtype(AlertDialog.TYPE_FAIL)
                    .icon(R.drawable.fail)
                    .show();
        }
    }

    private void gotoLogin() {
        startActivity(new Intent(RegisterInfoActivity.this, LoginActivity.class));
        finish();
    }
}
