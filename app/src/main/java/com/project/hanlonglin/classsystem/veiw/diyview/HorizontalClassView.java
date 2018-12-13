package com.project.hanlonglin.classsystem.veiw.diyview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.HorizontalScrollView;

import com.project.hanlonglin.classsystem.veiw.diyview.model.Point;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by hanlonglin on 2018/12/13.
 */

public class HorizontalClassView extends HorizontalScrollView {

    HashMap<Point, Integer> hashMap = new HashMap<>(); //存储所有图标
    Paint paintNormal;

    public HorizontalClassView(Context context) {
        super(context);
        init();
    }

    public HorizontalClassView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalClassView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getWidth();
        int height=getHeight();
        Log.e("TAG","width:"+width+"height:"+height);
        drawAllIcon(canvas);
    }

    private void init() {
        paintNormal = new Paint();
        paintNormal.setColor(Color.RED);
        paintNormal.setTextSize(20);
        paintNormal.setStrokeWidth(2);
    }

    private void drawAllIcon(Canvas canvas) {
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Point, Integer> entry = (Map.Entry<Point, Integer>) iterator.next();
            Point p = entry.getKey();
            int res = entry.getValue();
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), res);
            Bitmap bitmap1=Bitmap.createScaledBitmap(bitmap,20,20,true);
            canvas.drawBitmap(bitmap1, p.getX(), p.getY(), paintNormal);
        }
    }

    public void addIcon(int x,int y,int res){
        Point point=new Point(x,y);
        hashMap.put(point,res);
        invalidate();
    }
}
