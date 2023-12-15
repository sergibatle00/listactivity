package com.example.listactivity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OverlapActivity extends AppCompatActivity {
    Button big;
    Button small;
    int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overlap);
        List<Integer> selectedColors = new ArrayList<>();
        colors = new int[6];
        colors[0] = ContextCompat.getColor(this, R.color.red);
        colors[1] = ContextCompat.getColor(this, R.color.purple);
        colors[2] = ContextCompat.getColor(this, R.color.blue);
        colors[3] = ContextCompat.getColor(this, R.color.yellow);
        colors[4] = ContextCompat.getColor(this, R.color.orange);
        colors[5] = ContextCompat.getColor(this, R.color.black);

        big = findViewById(R.id.big);
        small = findViewById(R.id.small);

        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColors.clear();
                Random rd = new Random();

                while (selectedColors.size() < 2) {
                    int randomIndex = rd.nextInt(colors.length);
                    int color = colors[randomIndex];

                    if (!selectedColors.contains(color)) {
                        selectedColors.add(color);
                    }
                }
                int bigBack = selectedColors.get(0);
                int bigText = selectedColors.get(1);

                big.setBackgroundTintList(ColorStateList.valueOf(bigBack));
                big.setTextColor(bigText);
            }
        });

        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColors.clear();
                Random rd = new Random();

                while (selectedColors.size() < 2) {
                    int randomIndex = rd.nextInt(colors.length);
                    int color = colors[randomIndex];

                    if (!selectedColors.contains(color)) {
                        selectedColors.add(color);
                    }
                }
                int smallBack = selectedColors.get(0);
                int smallText = selectedColors.get(1);

                small.setBackgroundTintList(ColorStateList.valueOf(smallBack));
                small.setTextColor(smallText);
            }
        });
    }
}
