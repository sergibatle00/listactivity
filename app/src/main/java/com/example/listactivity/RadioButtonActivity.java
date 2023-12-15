package com.example.listactivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class RadioButtonActivity extends AppCompatActivity {
    RadioGroup orientation;
    RadioGroup position;
    RadioButton vertical;
    RadioButton horizontal;
    RadioButton left;
    RadioButton center;
    RadioButton right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_button);

        orientation = findViewById(R.id.orientation);
        position = findViewById(R.id.position);
        vertical = findViewById(R.id.vertical);
        horizontal = findViewById(R.id.horizontal);
        left =  findViewById(R.id.left);
        right = findViewById(R.id.right);
        center = findViewById(R.id.center);

        orientation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (horizontal.isChecked()) {
                    orientation.setOrientation(RadioGroup.HORIZONTAL);
                }else {
                    orientation.setOrientation(RadioGroup.VERTICAL);
                }
            }
        });

        position.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ViewGroup.LayoutParams layoutParams = position.getLayoutParams();

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) position.getLayoutParams();

                params.gravity = Gravity.CENTER_VERTICAL;
                LinearLayout.LayoutParams linearLayoutParams = (LinearLayout.LayoutParams) layoutParams;

                if (left.isChecked()) {
                    linearLayoutParams.gravity = Gravity.LEFT;
                    position.setLayoutParams(linearLayoutParams);
                }

                if (center.isChecked()) {
                    linearLayoutParams.gravity = Gravity.CENTER;
                    position.setLayoutParams(linearLayoutParams);
                }

                if (right.isChecked()) {
                    linearLayoutParams.gravity = Gravity.RIGHT;
                    position.setLayoutParams(linearLayoutParams);
                }
            }
        });

    }
}
