package com.example.retractablewindowborder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.webkit.WebView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.MotionEvent;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.RadioButton;
import android.app.Activity;

public class newproject extends AppCompatActivity {

    private int currentHeight = 0;
    private int currentWidth = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_newproject2);

//set navbar  color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#DFDFDF"));


        }

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();



        }


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);





        // Set status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#E7E9EA"));


        // Set an OnClickListener on the ImageButton2 to act as a back button
        ImageButton imageButton2 = findViewById(R.id.imageButton4);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(newproject.this, MyGallery.class);
                startActivity(intent);
                finish();
            }
        });




// Get the ConstraintLayout that contains the EditText view
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

// Get the EditText view
        EditText myEditText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText1);
        EditText editText3 = findViewById(R.id.editText3);
        myEditText.setText("1000");
        editText2.setText("1000");
        Button button56 = findViewById(R.id.button2);


        // Set an OnItemSelectedListener on the Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item from the Spinner
                String selectedItem = parent.getItemAtPosition(position).toString();

                // Update the EditText fields based on the selected item
                if (selectedItem.equals("Custom")) {


                } else if (selectedItem.equals("+ Import Image")) {
                    myEditText.setText("200");
                    editText2.setText("300");
                }  else if (selectedItem.equals("1:1 (4k)")) {
                    myEditText.setText("4096");
                    editText2.setText("4096");
                }else if (selectedItem.equals("3:4 (4k)")) {
                    myEditText.setText("4096");
                    editText2.setText("3072");
                }
                else if (selectedItem.equals("9:16 (4k)")) {
                    myEditText.setText("3840");
                    editText2.setText("2160");
                }
                else if (selectedItem.equals("instagram (potrait)")) {
                    myEditText.setText("1350");
                    editText2.setText("1080");
                }else if (selectedItem.equals("twitter (post)")) {
                    myEditText.setText("675");
                    editText2.setText("1200");
                }
                else if (selectedItem.equals("Manga Page (B4)")) {
                    myEditText.setText("4169");
                    editText2.setText("2953");
                }
                else if (selectedItem.equals("A4")) {
                    myEditText.setText("3508");
                    editText2.setText("2480");
                }
                else if (selectedItem.equals("A5")) {
                    myEditText.setText("2480");
                    editText2.setText("1754");
                }
                else if (selectedItem.equals("B5")) {
                    myEditText.setText("2953");
                    editText2.setText("2079");
                }
                else if (selectedItem.equals("twitter (header)")) {
                    myEditText.setText("500");
                    editText2.setText("1500");
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }

            
        });



// Set a touch listener to the ConstraintLayout
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Check if the touch event occurred outside of the EditText
                if (event.getAction() == MotionEvent.ACTION_DOWN && myEditText.hasFocus()) {
                    Rect outRect = new Rect();
                    myEditText.getGlobalVisibleRect(outRect);
                    if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                        // If the touch event occurred outside of the EditText, clear its focus
                        myEditText.clearFocus();
                    }
                }
                return false;
            }
        });


        // Set a touch listener to the ConstraintLayout
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Check if the touch event occurred outside of the EditText
                if (event.getAction() == MotionEvent.ACTION_DOWN && editText3.hasFocus()) {
                    Rect outRect = new Rect();
                    editText3.getGlobalVisibleRect(outRect);
                    if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                        // If the touch event occurred outside of the EditText, clear its focus
                        editText3.clearFocus();
                    }
                }
                return false;
            }
        });




        TextView textViewx = findViewById(R.id.WidthTextView);
        SeekBar seekBar = findViewById(R.id.seekBar);
        SeekBar seekBar2 = findViewById(R.id.seekBar2);
        TextView textView = findViewById(R.id.HeightTextView);



// Add a TextWatcher to the EditText
        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Update the current height value
                if (!TextUtils.isEmpty(s)) {
                    currentHeight = Integer.parseInt(s.toString());
                } else {
                    currentHeight = 0;
                }

                // Update the rectangle with the new aspect ratio
                updateRectangleSize(currentHeight, currentWidth);




                // Update the TextView with the new input
                textViewx.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Get the current text as a string
                String text = s.toString();


                // Check if the text is empty
                if (text.isEmpty()) {
                    return;
                }

                // Parse the text as an integer
                int value;
                try {
                    value = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    // If the text is not a valid integer, set the value to 0
                    value = 0;
                }

                // Check if the value is within the allowed range
                if (value < 1) {
                    value = 1;
                } else if (value > 9999) {
                    value = 9999;
                }

                // Update the text with the nearest valid value
                if (value != Integer.parseInt(text)) {
                    myEditText.setText(Integer.toString(value));
                }

            }


        });


        final EditText editText = findViewById(R.id.editText);



        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                // Update the value of the EditText widget as the user slides the SeekBar
                editText2.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {
                // Not used in this example
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {
                // Not used in this example
            }
        });


        // Set a touch listener to the ConstraintLayout
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Check if the touch event occurred outside of the EditText
                if (event.getAction() == MotionEvent.ACTION_DOWN && editText2.hasFocus()) {
                    Rect outRect = new Rect();
                    editText2.getGlobalVisibleRect(outRect);
                    if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                        // If the touch event occurred outside of the EditText, clear its focus
                        editText2.clearFocus();
                    }
                }
                return false;
            }
        });



        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView illustration = findViewById(R.id.textView3);
                Spinner customization = findViewById(R.id.spinner);
                TextView dpi = findViewById(R.id.textView4);
                TextView animation = findViewById(R.id.animtxt);
                TextView webcomictxt = findViewById(R.id.webcomtxt);
                animation.setVisibility(View.INVISIBLE);
                webcomictxt.setVisibility(View.INVISIBLE);


                switch (checkedId) {
                    case R.id.radioButton1:
                        illustration.setVisibility(View.VISIBLE);
                        customization.setVisibility(View.VISIBLE);
                        dpi.setVisibility(View.VISIBLE);
                        animation.setVisibility(View.GONE);
                        webcomictxt.setVisibility(View.GONE);
                        break;
                    case R.id.radioButton2:
                        illustration.setVisibility(View.GONE);
                        customization.setVisibility(View.GONE);
                        dpi.setVisibility(View.GONE);
                        animation.setVisibility(View.VISIBLE);
                        webcomictxt.setVisibility(View.GONE);
                        break;
                    case R.id.radioButton3:
                        illustration.setVisibility(View.GONE);
                        customization.setVisibility(View.GONE);
                        dpi.setVisibility(View.GONE);
                        animation.setVisibility(View.GONE);
                        webcomictxt.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        // Add a TextWatcher to the EditText
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used in this example

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Update the current width value
                if (!TextUtils.isEmpty(s)) {
                    currentWidth = Integer.parseInt(s.toString());
                } else {
                    currentWidth = 0;
                }

                // Update the rectangle with the new aspect ratio
                updateRectangleSize(currentHeight, currentWidth);



                // Update the TextView with the new input
                textView.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Get the current text as a string
                String text = s.toString();

                // Check if the text is empty
                if (text.isEmpty()) {
                    return;
                }

                // Parse the text as an integer
                int value;
                try {
                    value = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    // If the text is not a valid integer, set the value to 0
                    value = 0;
                }

                // Check if the value is within the allowed range
                if (value < 1) {
                    value = 1;
                } else if (value > 9999) {
                    value = 9999;
                }

                // Update the text with the nearest valid value
                if (value != Integer.parseInt(text)) {
                    editText2.setText(Integer.toString(value));
                }
            }


        });

//CREATE CANVAS
        button56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered by the user for height and width
                int height = Integer.parseInt(myEditText.getText().toString());
                int width = Integer.parseInt(editText2.getText().toString());
                RadioButton illustrationRadioButton = findViewById(R.id.radioButton1);
                RadioButton animationRadioButton = findViewById(R.id.radioButton2);
                RadioButton webcomicRadioButton = findViewById(R.id.radioButton3);

                // Determine which radio button is selected
                String canvasType = "";
                Class<? extends Activity> targetActivityClass = null;
                if (illustrationRadioButton.isChecked()) {
                    canvasType = "illustration";
                    targetActivityClass = canvasactivity.class;

                }
                else if (animationRadioButton.isChecked()) {
                    canvasType = "animation";
                    targetActivityClass = AnimationActivity.class;
                } else if (webcomicRadioButton.isChecked()) {
                    canvasType = "webcomic";
                    targetActivityClass = WebcomicActivity.class;
                }

                // Create a Bundle to pass the canvas size and type values to your target activity
                Bundle bundle = new Bundle();
                bundle.putInt("height", height);
                bundle.putInt("width", width);
                bundle.putString("canvasType", canvasType);

                // Start your target activity and pass the Bundle

                Intent intent = new Intent(newproject.this, targetActivityClass);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update the value of the EditText widget as the user slides the SeekBar
                myEditText.setText(String.valueOf(progress + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not used in this example
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not used in this example
            }
        });










    }


    private void updateRectangleSize(int height, int width) {
        // Calculate the new aspect ratio
        float aspectRatio = (float) width / (float) height;

        // Get a reference to the rectangle view
        View rectangleView = findViewById(R.id.rectangle_view);

        // Get the current layout parameters of the rectangle view
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rectangleView.getLayoutParams();

        // Calculate the new width and height based on the aspect ratio
        int newWidth, newHeight;
        if (width > height) {
            newWidth = layoutParams.width;
            newHeight = Math.round(newWidth / aspectRatio);
        } else {
            newHeight = layoutParams.height;
            newWidth = Math.round(newHeight * aspectRatio);
        }

        // Set a minimum value for the width and height
        int minWidth = 8;
        int minHeight = 8;

        // Check if the new width is less than the minimum width, and if so, set it to the minimum width
        if (newWidth < minWidth) {
            newWidth = minWidth;
            newHeight = Math.round(newWidth / aspectRatio);
        }

        // Check if the new height is less than the minimum height, and if so, set it to the minimum height
        if (newHeight < minHeight) {
            newHeight = minHeight;
            newWidth = Math.round(newHeight * aspectRatio);
        }

        // Calculate the new margin values
        int leftMargin = (layoutParams.width - newWidth) / 2;
        int topMargin = (layoutParams.height - newHeight) / 2;

        // Update the margin values of the layout parameters
        layoutParams.leftMargin = leftMargin;
        layoutParams.topMargin = topMargin;
        layoutParams.rightMargin = layoutParams.width - newWidth - leftMargin;
        layoutParams.bottomMargin = layoutParams.height - newHeight - topMargin;

        // Set the updated layout parameters on the rectangle view
        rectangleView.setLayoutParams(layoutParams);
    }






}