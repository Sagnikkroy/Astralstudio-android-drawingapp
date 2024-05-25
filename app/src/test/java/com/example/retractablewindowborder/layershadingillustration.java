package com.example.retractablewindowborder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class layershadingillustration extends AppCompatActivity {


    private CanvasAdapter adapter;
    private ArrayList<CanvasItem> canvasList;
    private SurfaceView mainsurfaceView; // Declare mainsurfaceView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvasactivity);

        // Assuming you have a ListView with the ID 'myListView'
        ListView listView = findViewById(R.id.myListView);
        mainsurfaceView = findViewById(R.id.mainsurfaceView); // Initialize mainsurfaceView

        // Create an initial list of canvases
        canvasList = new ArrayList<>();
        // Create and set the adapter
        adapter = new CanvasAdapter(this, canvasList);
        listView.setAdapter(adapter);


        // Create an initial list of canvases (dummy items for testing)
        canvasList = new ArrayList<>();
        canvasList.add(new CanvasItem("Layer 1", null));
        canvasList.add(new CanvasItem("Layer 2", null));
        canvasList.add(new CanvasItem("Layer 3", null));

        ImageButton addCanvasButton = findViewById(R.id.imageButton);
        addCanvasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the dimensions of the SurfaceView
                int surfaceWidth = mainsurfaceView.getWidth();
                int surfaceHeight = mainsurfaceView.getHeight();

                // Create a new bitmap for the canvas with the same dimensions as the SurfaceView
                Bitmap newBitmap = Bitmap.createBitmap(surfaceWidth, surfaceHeight, Bitmap.Config.ARGB_8888);

                // Generate a name for the new canvas (e.g., "Layer 3", "Layer 4", etc.)
                String newName = "Layer " + (canvasList.size() + 1);

                // Add the new canvas to the list
                canvasList.add(new CanvasItem(newName, newBitmap));

                // Notify the adapter that the data set has changed
                adapter.notifyDataSetChanged();
            }
        });
    }

    private static class CanvasItem {
        private String name;
        private Bitmap bitmap; // Change Canvas to Bitmap

        public CanvasItem(String name, Bitmap bitmap) {
            this.name = name;
            this.bitmap = bitmap;
        }

        public String getName() {
            return name;
        }

        public Bitmap getBitmap() {
            return bitmap;
        }
    }

    private class CanvasAdapter extends ArrayAdapter<CanvasItem> {

        private Context context;
        private ArrayList<CanvasItem> canvasItems;

        public CanvasAdapter(Context context, ArrayList<CanvasItem> canvasItems) {
            super(context, 0, canvasItems);
            this.context = context;
            this.canvasItems = canvasItems;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            CanvasItem item = getItem(position);

            TextView textView = convertView.findViewById(android.R.id.text1);

            if (item != null) {
                textView.setText(item.getName());
            }

            return convertView;
        }
    }
}