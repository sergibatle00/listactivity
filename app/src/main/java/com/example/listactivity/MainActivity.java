package com.example.listactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Intent intent;
    ArrayList<String> options = new ArrayList<>(Arrays.asList(
            "Radio button",
            "Box model",
            "URL DEMO",
            "Overlap"
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String select = parent.getItemAtPosition(position).toString();

                switch (select) {
                    case "Radio button":
                        intent = new Intent(getApplicationContext(), RadioButtonActivity.class);
                        startActivity(intent);
                        break;
                    case "Box model":
                        intent = new Intent(getApplicationContext(), BoxModelActivity.class);
                        startActivity(intent);
                        break;
                    case "URL DEMO":
                        intent = new Intent(getApplicationContext(), URLActivity.class);
                        startActivity(intent);
                        break;
                    case "Overlap":
                        intent = new Intent(getApplicationContext(), OverlapActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}