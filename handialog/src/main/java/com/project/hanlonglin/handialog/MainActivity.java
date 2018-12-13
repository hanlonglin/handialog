package com.project.hanlonglin.handialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.project.hanlonglin.handialog.dialog.AlertDialog;

/**
 * Created by hanlonglin on 2018/12/13.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn1:
//                showSuccessDialog();
//                break;
//            case R.id.btn2:
//                break;
//            case R.id.btn3:
//                break;
//            case R.id.btn4:
//                break;
//            case R.id.btn5:
//                break;
//        }
    }

    private void showSuccessDialog() {
        new AlertDialog(this)
                .title("我成功了")
                .messsage("即将前往主页面")
                .showCancel(true)
                .show();
    }
}
