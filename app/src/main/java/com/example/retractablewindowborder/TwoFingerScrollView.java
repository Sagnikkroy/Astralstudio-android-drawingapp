package com.example.retractablewindowborder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class TwoFingerScrollView extends ScrollView {

    private int activePointers = 0;

    public TwoFingerScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                activePointers++;
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                activePointers--;
                break;
        }

        // Allow scrolling only when two fingers are active
        return activePointers >= 2 || super.onTouchEvent(event);
    }
}
