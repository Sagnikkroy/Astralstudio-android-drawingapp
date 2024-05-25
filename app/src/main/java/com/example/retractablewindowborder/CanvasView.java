package com.example.retractablewindowborder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath = new Path();
    private Paint mPaint;
    private float mLastTouchX, mLastTouchY;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setAlpha(50);
        mPaint.setColor(Color.RED);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mLastTouchX = 0;
        mLastTouchY = 0;
    }

    private void initCanvas() {
        if (getWidth() > 0 && getHeight() > 0) {
            mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
            mCanvas.drawColor(Color.WHITE);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initCanvas();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBitmap != null) {
            // Draw the bitmap on the canvas
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }

        // Draw the path
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mPaint.setAntiAlias(true);

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                mLastTouchX = x;
                mLastTouchY = y;
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.quadTo(mLastTouchX, mLastTouchY, (x + mLastTouchX) / 2, (y + mLastTouchY) / 2);
                mLastTouchX = x;
                mLastTouchY = y;
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }
}
