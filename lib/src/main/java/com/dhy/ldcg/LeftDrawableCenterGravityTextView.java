package com.dhy.ldcg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * left drawable center gravity.
 * show text and left_drawable in center
 */
public class LeftDrawableCenterGravityTextView extends android.support.v7.widget.AppCompatTextView {
    public LeftDrawableCenterGravityTextView(Context context) {
        super(context);
        init();
    }

    public LeftDrawableCenterGravityTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LeftDrawableCenterGravityTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init() {
        setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        Drawable drawableLeft = drawables[0];
        if (drawableLeft != null && getMeasuredWidth() > 0) {
            float textWidth = getPaint().measureText(getText().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth = drawableLeft.getIntrinsicWidth();
            float bodyWidth = textWidth + drawablePadding + drawableWidth;
            canvas.translate((getMeasuredWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }
}
