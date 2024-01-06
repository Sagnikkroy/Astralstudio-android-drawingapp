package com.example.retractablewindowborder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Button;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import androidx.cardview.widget.CardView;
import android.view.animation.TranslateAnimation;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class canvasactivity extends AppCompatActivity {
    private SurfaceView canvo;
    private ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0f;
    private float rotation = 0;
    private float initialAngle = 0;
    private boolean isRotating = false;
 private ConstraintLayout Parentview ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvasactivity);

        canvo = findViewById(R.id.mainsurfaceView);

        // Retrieve the Bundle data passed from the previous activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Retrieve height and width values from the Bundle
            int height = bundle.getInt("height");
            int width = bundle.getInt("width");

            // Set the height and width of the SurfaceView programmatically
            ViewGroup.LayoutParams params = canvo.getLayoutParams();
            params.height = height;
            params.width = width;
            canvo.setLayoutParams(params);
        }




        canvo = findViewById(R.id.mainsurfaceView);
        Parentview = findViewById(R.id.parentcon);
        ImageButton imageButton = findViewById(R.id.imageButton5);
        CardView cardView = findViewById(R.id.toolbar);
        ImageButton colourSelectButton = findViewById(R.id.colourselect);
        CardView colorselectioncard = findViewById(R.id.colorsolsce); // Typo fixed here (assuming the correct ID is "colorsolsce")



        // Initialize ScaleGestureDetector
        scaleGestureDetector = new ScaleGestureDetector(this, new MyScaleGestureListener());

        Parentview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Pass touch events to ScaleGestureDetector
                scaleGestureDetector.onTouchEvent(event);

                // Handle rotation and scaling with touch on parent view
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        if (event.getPointerCount() == 2) {
                            isRotating = true;
                            initialAngle = getAngle(event);
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (isRotating && event.getPointerCount() == 2) {
                            float angle = getAngle(event);
                            rotation = rotation + (angle - initialAngle);
                            canvo.setRotation(rotation);
                            initialAngle = angle;
                        }
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                    case MotionEvent.ACTION_UP:
                        isRotating = false;
                        break;
                }
                return true;
            }
        });




// Fade in animation
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(400); // Set duration as needed (in milliseconds)
        colorselectioncard.setAnimation(fadeIn);

// Fade out animation
        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(400); // Set duration as needed (in milliseconds)
        colorselectioncard.setAnimation(fadeOut);
        // Slide left animation
        TranslateAnimation slideLeft = new TranslateAnimation(0, -colorselectioncard.getWidth(), 0, 0);
        slideLeft.setDuration(500); // Set duration as needed (in milliseconds)
        colorselectioncard.setAnimation(slideLeft);
// Slide right animation
        TranslateAnimation slideRight = new TranslateAnimation(0, colorselectioncard.getWidth(), 0, 0);
        slideRight.setDuration(500); // Set duration as needed (in milliseconds)
        colorselectioncard.setAnimation(slideRight);
// Slide up animation
        TranslateAnimation slideUp = new TranslateAnimation(0, 0, 0, -colorselectioncard.getHeight());
        slideUp.setDuration(500); // Set duration as needed (in milliseconds)
        colorselectioncard.setAnimation(slideUp);
// Slide down animation
        TranslateAnimation slideDown = new TranslateAnimation(0, 0, 0, colorselectioncard.getHeight());
        slideDown.setDuration(500); // Set duration as needed (in milliseconds)
        colorselectioncard.setAnimation(slideDown);










        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardView.getVisibility() == View.GONE) {


                    cardView.setVisibility(View.VISIBLE);
                } else {

                    cardView.setVisibility(View.GONE);
                }
            }
        });








        ImageButton imageButton2 = findViewById(R.id.imageButton6);
        CardView cardViewsliderbar = findViewById(R.id.adjustbar);


        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardViewsliderbar.getVisibility() == View.VISIBLE) {

                    cardViewsliderbar.setVisibility(View.GONE);
                    colorselectioncard.setVisibility(View.GONE);

                } else {

                    cardViewsliderbar.setVisibility(View.VISIBLE);
                }
            }
        });

        ImageButton imageButtonselector = findViewById(R.id.imageButtonchanger);
        CardView cardViewselector = findViewById(R.id.selectorcard);

        ImageButton imageButton3 = findViewById(R.id.imageButtonrightbottom);
        CardView cardViewlayer = findViewById(R.id.layercard);

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardViewlayer.getVisibility() == View.VISIBLE) {
                    cardViewlayer.setVisibility(View.GONE);
                } else {
                    cardViewlayer.setVisibility(View.VISIBLE);
                    colorselectioncard.setVisibility(View.GONE);
                    cardViewselector.setVisibility(View.GONE);

                }
            }
        });




        colourSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colorselectioncard.getVisibility() == View.VISIBLE) {
                    // Start fade-out animation
                    colorselectioncard.startAnimation(fadeOut);
                    colorselectioncard.setVisibility(View.GONE);

                } else {
                    // Start fade-in animation
                    colorselectioncard.startAnimation(fadeIn);
                    colorselectioncard.setVisibility(View.VISIBLE);
                    cardViewselector.setVisibility(View.GONE);
                    cardViewlayer.setVisibility(View.GONE); // Assuming cardViewlayer should be hidden when colorselectioncard is visible
                }
            }
        });





        imageButtonselector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardViewselector.getVisibility() == View.GONE) {

                    cardViewselector.startAnimation(fadeIn);
                    cardViewselector.setVisibility(View.VISIBLE);
                    cardViewlayer.setVisibility(View.GONE);
                    colorselectioncard.setVisibility(View.GONE);

                } else {

                    cardViewselector.setVisibility(View.GONE);
                }
            }
        });



        // Set status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#0B0B0E"));

        //set navbar  color

            getWindow().setNavigationBarColor(Color.parseColor("#0B0B0E"));




        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
    //back button message alert!!!
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Go back to My Gallery?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(canvasactivity.this, MyGallery.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();



    }
    // Inner class to handle pinch-to-zoom scaling
    private class MyScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scaleFactor *= detector.getScaleFactor();

            // Limit the scale factor if needed
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));

            // Apply the scale to your SurfaceView
            canvo.setScaleX(scaleFactor);
            canvo.setScaleY(scaleFactor);

            return true;
        }
    }

    // Method to calculate angle between two touch points
    private float getAngle(MotionEvent event) {
        float deltaX = event.getX(1) - event.getX(0);
        float deltaY = event.getY(1) - event.getY(0);
        double radians = Math.atan2(deltaY, deltaX);
        return (float) Math.toDegrees(radians);
    }

}

