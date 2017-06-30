package com.dhy.aedittext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * show hint and left_drawable in center, left when focused or none empty text
 */
public class AEditText extends android.support.v7.widget.AppCompatEditText {
    public AEditText(Context context) {
        super(context);
        init();
    }

    public AEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AEditText(Context context, AttributeSet attrs, int defStyleAttr) {
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
        if (drawableLeft != null && shouldCenter() && getMeasuredWidth() > 0) {
            float textWidth = getPaint().measureText(getHint().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth = drawableLeft.getIntrinsicWidth();
            float bodyWidth = textWidth + drawablePadding + drawableWidth;
            canvas.translate((getMeasuredWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }

    boolean shouldCenter() {
        return length() == 0 && !isFocused();
    }
}
