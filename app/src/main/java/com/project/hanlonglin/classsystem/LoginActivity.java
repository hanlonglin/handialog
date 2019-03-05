package com.project.hanlonglin.classsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.hanlonglin.classsystem.app.AppApplication;
import com.project.hanlonglin.classsystem.database.dao.StudentDao;
import com.project.hanlonglin.classsystem.database.model.Student;
import com.project.hanlonglin.classsystem.veiw.diyview.TitleBarRelativeLayout;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialog;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialogListener;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ed_id, ed_passwd;
    Button btn_login;
    TextView txt_register, txt_forget_passwd;
    ImageView image_qq;
    TitleBarRelativeLayout title_layout;

    StudentDao stuDao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intiView();
        //gotoMain();
        stuDao=new StudentDao(this);

    }

    private void intiView() {
        ed_id = (EditText) findViewById(R.id.ed_id);
        ed_passwd = (EditText) findViewById(R.id.ed_passwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        txt_forget_passwd = (TextView) findViewById(R.id.txt_forget_passwd);
        txt_register = (TextView) findViewById(R.id.txt_register);
        image_qq = (ImageView) findViewById(R.id.image_qq);
        title_layout=(TitleBarRelativeLayout)findViewById(R.id.titleLayout);
        title_layout.setTitle("登录");

        btn_login.setOnClickListener(this);
        txt_register.setOnClickListener(this);
        txt_forget_passwd.setOnClickListener(this);
        image_qq.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                doLogin();
                break;
            case R.id.txt_register:
                gotoRegister();
                break;
            case R.id.txt_forget_passwd:
                gotoForgetPasswd();
                break;
            case R.id.image_qq:
                loginByQQ();
                break;
        }
    }


    private void doLogin() {
        String id=ed_id.getText().toString();
        String passwd=ed_passwd.getText().toString();
        if(TextUtils.isEmpty(id)||TextUtils.isEmpty(passwd))
        {
            Toast.makeText(this, "用户名密码不能为空！", Toast.LENGTH_SHORT).show();
            return ;
        }
        List<Student> stuList=stuDao.select("where sname='"+id+"'");
        if(stuList.size()>0){
            Student stu=stuList.get(0);
            if(TextUtils.equals(stu.getSpasswd(),passwd)){
                AppApplication.currentStu=stu;
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                gotoMain();
            }else{
                Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "用户不存在！", Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoRegister() {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        finish();
    }

    private void gotoForgetPasswd() {
    }

    private void loginByQQ() {
    }

    private void gotoMain(){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
        finish();
    }
}
