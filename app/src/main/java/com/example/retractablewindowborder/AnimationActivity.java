package com.example.retractablewindowborder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
import android.view.animation.Animation;

import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
public class AnimationActivity extends AppCompatActivity {
    private SurfaceView canvo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }



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



// Hide the navigation bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // Hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
//back button message alert!!!
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Go back to My Gallery?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(AnimationActivity.this, MyGallery.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }



}