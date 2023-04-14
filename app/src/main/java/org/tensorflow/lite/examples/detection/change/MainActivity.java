package org.tensorflow.lite.examples.detection.change;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button btn_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main = findViewById(R.id.add);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent);
            }
        });


            Button developer_info_btn = (Button) findViewById(R.id.camera);
            developer_info_btn.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(), LabellingActivity.class);
              startActivity(intent);
              }
            });


        }
    }