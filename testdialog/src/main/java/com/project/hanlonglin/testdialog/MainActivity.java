package com.project.hanlonglin.testdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.hanlonglin.handialog.dialog.AdvertDialog;
import com.project.hanlonglin.handialog.dialog.AlertDialog;
import com.project.hanlonglin.handialog.dialog.DialogFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                showSuccessDialog();
                break;
            case R.id.btn2:
                showFailDialog();
                break;
            case R.id.btn3:
                showWarnDialog();
                break;
            case R.id.btn4:
                showConfirmDialog();
                break;
            case R.id.btn5:
                showAdvertDialog();
                break;
        }
    }

    private void showAdvertDialog() {
        DialogFactory.buildAdvertDialog(this, DialogFactory.DIALOG_ADVERT)
                .url("http://t8.baidu.com/it/u=2063170438,222422588&fm=191&app=48&wm=1,13,90,45,0,7&wmo=10,10&n=0&g=0n&f=JPEG?sec=1853310920&t=ecdf5c04372612896a6a5d483c942e29")
                .showType(AdvertDialog.TYPE_HTTP)
                .show();
//        DialogFactory.buildAdvertDialog(this, DialogFactory.DIALOG_ADVERT)
//                .show();
    }

    private void showWarnDialog() {
        DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_WARNING_CANCEL).show();
    }

    private void showConfirmDialog() {
        DialogFactory.buildConfirmDialog(this, DialogFactory.DIALOG_CONFIRM)
                .message("你好的我受按时大苏打啊是多久啊离开就达拉斯空间道路喀什就离开的就爱你好的我受按时大苏打啊是多久啊离开就达拉斯空间道路喀什就离开的就爱你好的我受按时大苏打啊是多久啊离开就达拉斯空间道路喀什就离开的就爱你好的我受按时大苏打啊是多久啊离开就达拉斯空间道路喀什就离开的就爱上了空间的a").show();
    }

    private void showFailDialog() {
        DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_FAIL).show();
    }

    private void showSuccessDialog() {
        DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_SUCCESS).show();
    }
}