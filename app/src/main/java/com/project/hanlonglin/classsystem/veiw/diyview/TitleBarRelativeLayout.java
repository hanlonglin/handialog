package com.project.hanlonglin.classsystem.veiw.diyview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.hanlonglin.classsystem.R;

/**
 * Created by hanlonglin on 2018/12/16.
 */

public class TitleBarRelativeLayout extends RelativeLayout {
    ImageView image_back;
    TextView txt_title;

    public TitleBarRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tittle_bar,this);
        image_back=(ImageView)findViewById(R.id.image_back);
        txt_title=(TextView)findViewById(R.id.txt_title);
        image_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });
    }

    public void setTitle(String title){
        txt_title.setText(title);
    }
}
