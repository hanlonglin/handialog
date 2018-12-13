package com.project.hanlonglin.testdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.project.hanlonglin.handialog.dialog.AdvertDialog;
import com.project.hanlonglin.handialog.dialog.AlertDialog;
import com.project.hanlonglin.handialog.dialog.DialogFactory;
import com.project.hanlonglin.handialog.dialog.listener.AlertDialogListener;
import com.project.hanlonglin.handialog.dialog.listener.ConfirmListener;


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
                .setConfirmListener(new ConfirmListener() {
                    @Override
                    public void onClick() {
                        Log.e("TAG","click the advert");
                    }
                }).show();
//        DialogFactory.buildAdvertDialog(this, DialogFactory.DIALOG_ADVERT)
//                .show();
    }

    private void showWarnDialog() {
        DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_WARNING_CANCEL).show();
    }

    private void showConfirmDialog() {
        DialogFactory.buildConfirmDialog(this, DialogFactory.DIALOG_CONFIRM)
                .message("")
                .title("").show();
    }

    private void showFailDialog() {
        DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_FAIL).show();
    }

    private void showSuccessDialog() {
        DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_SUCCESS)
                .setAlertDialogListener(new AlertDialogListener() {
                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onConfrim() {

                    }
                }).show();
    }
}
