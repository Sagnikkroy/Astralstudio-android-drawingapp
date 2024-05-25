package com.example.retractablewindowborder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.View;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import androidx.cardview.widget.CardView;

import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
public class WebcomicActivity extends AppCompatActivity {
    private CardView cardViewdown;
    private ImageButton toggleButtondown;
    private LinearLayout container;
    private int canvasCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcomic);

        container = findViewById(R.id.container);






// Set status bar color to black
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#000000")); // Hex color for black









        // Hide the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();}

// Get references to the CardView and Button views
            cardViewdown = findViewById(R.id.downcard);
            toggleButtondown = findViewById(R.id.imageButtondown);
        CardView cardviewcontrols = findViewById(R.id.UPcard);

            toggleButtondown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cardViewdown.getVisibility() == View.VISIBLE) {
                        cardViewdown.setVisibility(View.GONE);
                        cardviewcontrols.setVisibility(View.GONE);
                    } else {
                        cardViewdown.setVisibility(View.VISIBLE);
                        cardviewcontrols.setVisibility(View.VISIBLE);
                    }
                }
            });







    }


    public void addCanvasView(View view) {
        // Retrieve the Bundle data passed from the previous activity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Retrieve height and width values from the Bundle
            int height = bundle.getInt("height");
            int width = bundle.getInt("width");

            // Create a new CanvasView with the retrieved height and width
            CanvasView canvasView = new CanvasView(this, null);
            canvasView.setId(View.generateViewId());

            // Set the height and width of the CanvasView programmatically
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
            canvasView.setLayoutParams(params);

            // Center the CanvasView horizontally within the LinearLayout
            params.gravity = Gravity.CENTER_HORIZONTAL;

            // Add CanvasView to the LinearLayout
            container.addView(canvasView);

            // Increment the canvasCounter
            canvasCounter++;
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
                        Intent intent = new Intent(WebcomicActivity.this, MyGallery.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}