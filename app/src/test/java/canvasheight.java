import android.graphics.Rect;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.retractablewindowborder.R;

public class canvasheight {

    private EditText myEditText;

    public void setupConstraintLayout(ConstraintLayout constraintLayout) {
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN && myEditText.hasFocus()) {
                    Rect outRect = new Rect();
                    myEditText.getGlobalVisibleRect(outRect);
                    if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                        myEditText.clearFocus();
                    }
                }
                return false;
            }
        });
    }


    }

