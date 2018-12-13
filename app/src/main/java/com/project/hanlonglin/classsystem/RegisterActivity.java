package com.project.hanlonglin.classsystem;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.project.hanlonglin.classsystem.database.model.Student;
import com.project.hanlonglin.classsystem.util.tools.OcrCodeUtil;

/**
 * Created by hanlonglin on 2018/12/12.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed_id, ed_passwd, ed_passwdconfirm, ed_ocrcode;
    ImageView image_ocr;
    Button btn_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        ed_id = (EditText) findViewById(R.id.ed_id);
        ed_passwd = (EditText) findViewById(R.id.ed_passwd);
        ed_passwdconfirm = (EditText) findViewById(R.id.ed_passwdconfirm);
        ed_ocrcode = (EditText) findViewById(R.id.ed_ocrcode);
        image_ocr = (ImageView) findViewById(R.id.image_ocrcode);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);
        image_ocr.setOnClickListener(this);

        updateOcrCode();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                doRegister();
                break;
            case R.id.image_ocrcode:
                updateOcrCode();
                break;
        }
    }

    private void doRegister() {
        String id = ed_id.getText().toString();
        String passwd = ed_passwd.getText().toString();
        String passwdConfirm = ed_passwdconfirm.getText().toString();
        String ocrCode = ed_ocrcode.getText().toString();

        if (TextUtils.isEmpty(id)
                || TextUtils.isEmpty(passwd)
                || TextUtils.isEmpty(passwdConfirm)
                || TextUtils.isEmpty(ocrCode)) {
            Toast.makeText(this, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!TextUtils.equals(passwd, passwdConfirm)) {
            Toast.makeText(this, "两次输入的密码不一致！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!TextUtils.equals(OcrCodeUtil.getInstance().getCode().toLowerCase(), ocrCode.toLowerCase())) {
            Toast.makeText(this, "验证码错误" + OcrCodeUtil.getInstance().getCode(), Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Student stu = new Student();
        stu.setSname(id);
        stu.setSpasswd(passwd);
        Intent intent = new Intent(RegisterActivity.this,RegisterInfoActivity.class);
        intent.putExtra("student",stu);
        startActivity(intent);

    }

    private void updateOcrCode() {
        Bitmap bitmap = OcrCodeUtil.getInstance().createBitmap();
        image_ocr.setImageBitmap(bitmap);
    }
}
