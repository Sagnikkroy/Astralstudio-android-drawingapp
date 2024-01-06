package com.example.retractablewindowborder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.RectF;
import android.graphics.Path;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLES20;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


import android.view.ScaleGestureDetector;


public class CanvasView extends View {
    private Bitmap mBitmap;

    private Canvas mCanvas;

    private Path mPath = new Path();

    private Paint mPaint;
    private RectF mRect;
    private float mLastTouchX, mLastTouchY;




    public CanvasView(Context context, AttributeSet attrs) {


        super(context, attrs);

        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8);
        mPaint.setStrokeJoin(Paint.Join.ROUND); // set stroke join to round
        mPaint.setStrokeCap(Paint.Cap.ROUND); // set stroke cap to round

        // Calculate the rectangle bounds to center it
        int width = getWidth();
        int height = getHeight();
        int rectSize = Math.min(width, height) / 2;
        int left = (width - rectSize) / 2;
        int top = (height - rectSize) / 2;
        int right = left + rectSize;
        int bottom = top + rectSize;
        mRect = new RectF(left, top, right, bottom);



    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        // Recalculate the rectangle bounds when the size changes
        int width = getWidth();
        int height = getHeight();
        int rectSize = Math.min(width, height) / 2;
        int left = (width - rectSize) / 2;
        int top = (height - rectSize) / 2;
        int right = left + rectSize;
        int bottom = top + rectSize;
        mRect.set(left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, 0, 0, null);



        // Draw the path
        canvas.drawPath(mPath, mPaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        mPaint.setAntiAlias(true);

        float x = event.getX();
        float y = event.getY();

        // Check if the touch event is inside the rectangle bounds
        if (mRect.contains(x, y)) {
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

        return false;
    }}




