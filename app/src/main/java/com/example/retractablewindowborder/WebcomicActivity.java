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
import android.view.View;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import androidx.cardview.widget.CardView;
import android.widget.SeekBar;
import android.widget.TextView;
public class WebcomicActivity extends AppCompatActivity {
    private CardView cardViewdown;
    private ImageButton toggleButtondown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webcomic);



// Set status bar color to black
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#000000")); // Hex color for black






        // Retrieve the user's input values from the Intent
        int height = getIntent().getIntExtra("height", 0);
        int width = getIntent().getIntExtra("width", 0);

        // Create a new Bitmap object with the user's input values
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        // Create a new Canvas object that is backed by the Bitmap
        Canvas canvas = new Canvas(bitmap);


        // Set the Bitmap as the background of the canvas view
        CanvasView canvasView = findViewById(R.id.canvasview);
        canvasView.setBackground(new BitmapDrawable(getResources(), bitmap));

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