package com.project.hanlonglin.testdialog;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.project.hanlonglin.handialog.dialog.AdvertDialog;
import com.project.hanlonglin.handialog.dialog.AlertDialog;
import com.project.hanlonglin.handialog.dialog.DialogFactory;
import com.project.hanlonglin.handialog.dialog.HelpDialog;
import com.project.hanlonglin.handialog.dialog.adapter.TextItemAdapter;
import com.project.hanlonglin.handialog.dialog.listener.AlertDialogListener;
import com.project.hanlonglin.handialog.dialog.listener.ConfirmListener;
import com.project.hanlonglin.handialog.dialog.listener.ListItemListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
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
            case R.id.btn6:
                showListDialog();
                break;
            case R.id.btn7:
                showHelpDialog(HelpDialog.STYLE_BOOK);
                break;
            case R.id.btn8:
                showHelpDialog(HelpDialog.STYLE_COMPUTER);
                break;
            case R.id.btn9:
                showHelpDialog(HelpDialog.STYLE_PAPER);
                break;

        }
    }

    private void showHelpDialog(int style) {
       DialogFactory.buildHelpDialog(this)
               .message("最近天气不好，请记得出门多穿衣服，多喝热水少喝酒，祝您身体健康，万事如意！")
               .style(style)
               .show();
    }

    private void showListDialog() {
        List<String> list=new ArrayList<>();
        list.add("青島");
        list.add("北京");
        list.add("太原");
        list.add("甘肅");
        list.add("西藏");
        list.add("廣州");
        list.add("青島");
        list.add("北京");
        list.add("太原");
        list.add("甘肅");
        list.add("西藏");
        list.add("廣州");
        list.add("青島");
        list.add("北京");
        list.add("太原");
        list.add("甘肅");
        list.add("西藏");
        list.add("廣州");
        list.add("青島");
        list.add("北京");
        list.add("太原");
        list.add("甘肅");
        list.add("西藏");
        list.add("廣州");
        list.add("青島");
        list.add("北京");
        list.add("太原");
        list.add("甘肅");
        list.add("西藏");
        list.add("廣州");
        list.add("青島");
        list.add("北京");
        list.add("太原");
        list.add("甘肅");
        list.add("西藏");
        list.add("廣州");
        TextItemAdapter adapter=new TextItemAdapter(this,list);
        DialogFactory.buildListDialog(this,DialogFactory.DIALOG_LIST)
                .title("城市")
                .titleBgColor(Color.RED)
                .setAdapter(adapter)
                .setListItemListener(new ListItemListener() {
                    @Override
                    public void itemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this,"點擊"+(String)adapterView.getAdapter().getItem(i),Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    private void showAdvertDialog() {
//        DialogFactory.buildAdvertDialog(this, DialogFactory.DIALOG_ADVERT)
//                .url("http://t8.baidu.com/it/u=2063170438,222422588&fm=191&app=48&wm=1,13,90,45,0,7&wmo=10,10&n=0&g=0n&f=JPEG?sec=1853310920&t=ecdf5c04372612896a6a5d483c942e29")
//                .showType(AdvertDialog.TYPE_HTTP)
//                .setConfirmListener(new ConfirmListener() {
//                    @Override
//                    public void onClick() {
//                        Log.e("TAG","click the advert");
//                    }
//                }).show();
        DialogFactory.buildAdvertDialog(this, DialogFactory.DIALOG_ADVERT)
                .show();
    }

    private void showWarnDialog() {
        DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_WARNING_CANCEL).show();
    }

    private void showConfirmDialog() {
        DialogFactory.buildConfirmDialog(this, DialogFactory.DIALOG_CONFIRM)
                .message("确定")
                .title("确定执行此操作吗？").show();
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
