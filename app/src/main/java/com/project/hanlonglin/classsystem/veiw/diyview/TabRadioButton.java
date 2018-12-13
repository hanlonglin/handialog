package com.project.hanlonglin.classsystem.veiw.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class TabRadioButton extends RadioButton {
    public TabRadioButton(Context context) {
        super(context);
        init();
    }

    public TabRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TabRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Drawable[] drawables;
    int width = 50;
    int height = 50;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        overWriteTopDrawable(canvas);
    }

    private void init() {
        drawables = getCompoundDrawables();
    }

    public void setDrawableSize(int width, int height) {
        this.width = width;
        this.height = height;
        invalidate();
    }

    private void overWriteTopDrawable(Canvas canvas) {
        if (drawables != null) {
            Drawable drawableTop = drawables[1];
            if (drawableTop != null) {
                drawableTop.setBounds(0, 0, width, height);
                setCompoundDrawables(drawables[0], drawableTop, drawables[2], drawables[3]);
            }
        }
    }
}
