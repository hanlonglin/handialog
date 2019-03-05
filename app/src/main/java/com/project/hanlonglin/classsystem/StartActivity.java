package com.project.hanlonglin.classsystem;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hanlonglin on 2018/12/16.
 */

public class StartActivity extends AppCompatActivity {
    private final static int SENDING_CODE = 10;
    private TextView txt_time;
    private ImageView image_center;

    private int time_last=5;

    private static final String TAG = "StartActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
        handler.sendEmptyMessageDelayed(SENDING_CODE, 1000);
        Log.e(TAG, "onCreate: start oncreate");

        if(savedInstanceState!=null){
            Log.e(TAG, "onCreate: savedInstanceState不为空"+savedInstanceState.getString("test"));
        }
    }

    private void initView() {
        txt_time = (TextView) findViewById(R.id.txt_time);
        image_center=(ImageView)findViewById(R.id.image_center);
        txt_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoLogin();
            }
        });

        //动画
        ObjectAnimator alpha=ObjectAnimator.ofFloat(image_center,"alpha",0f,1f);
        alpha.setDuration(5000);
        alpha.start();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e(TAG, "onSaveInstanceState: ");
        outState.putString("test","I am hanlonglin...");
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SENDING_CODE:
                    if (time_last>1) {
                        time_last--;
                        Log.e(TAG, "handleMessage: time_last:"+time_last);
                        txt_time.setText("跳过"+time_last+"s");
                        handler.sendEmptyMessageDelayed(SENDING_CODE, 1000);
                    } else {
                        gotoLogin();
                    }
                    break;
            }
        }
    };

    private void gotoLogin() {
        startActivity(new Intent(StartActivity.this, LoginActivity.class));
        finish();
        handler.removeMessages(SENDING_CODE);
    }
}
