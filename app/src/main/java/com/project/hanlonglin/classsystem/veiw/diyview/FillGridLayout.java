package com.project.hanlonglin.classsystem.veiw.diyview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class FillGridLayout extends GridLayout {
    int screenWidth;
    int columnCount;

    public FillGridLayout(Context context) {
        super(context);
        init(context);
    }

    public FillGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FillGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        screenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
        int columnCount=getColumnCount();
        Log.e("TAB","screenWidth:"+screenWidth+",columnCount:"+columnCount);
        if(columnCount==0) return ;
        for(int i=0;i<getChildCount();i++){
            View v= getChildAt(i);
            v.setMinimumWidth(screenWidth/columnCount);
        }
        Log.e("TAG","fillGridLayout width:"+getWidth());
        Log.e("init","height:"+getHeight()+",width:"+getWidth());
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        Log.e("onMeasure","height:"+getHeight()+",width:"+getWidth());
        //setMinimumWidth(screenWidth);
    }
}
