package com.project.hanlonglin.classsystem.view.layout.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.project.hanlonglin.classsystem.LoginActivity;
import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.app.AppApplication;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialog;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialogListener;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class AboutFragment extends BaseFragment {
    TextView txt_sname, txt_grade;
    Button btn_exit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_about, null, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        txt_grade = (TextView) v.findViewById(R.id.txt_grade);
        txt_sname = (TextView) v.findViewById(R.id.txt_sname);
        btn_exit = (Button) v.findViewById(R.id.btn_exit);

        txt_sname.setText(AppApplication.currentStu.getSname());
        txt_grade.setText(AppApplication.currentStu.getGrade()+"年级");

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();

            }
        });
    }

    private void showAlert() {
        new AlertDialog(getActivity())
                .title("退出")
                .messsage("确定退出此账号吗？")
                .showCancel(true)
                .setAlertDialogListener(new AlertDialogListener() {
                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onConfrim() {
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        getActivity().finish();
                    }
                }).show();
    }
}
