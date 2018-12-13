package com.project.hanlonglin.classsystem.veiw.diyview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class AutoGridView extends GridView {

    public AutoGridView(Context context) {
        super(context);
    }

    public AutoGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //重写onMesure 解决gridView和scrollView的冲突
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
