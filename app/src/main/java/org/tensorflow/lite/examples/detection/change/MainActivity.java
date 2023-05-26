package org.tensorflow.lite.examples.detection.change;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button cameraButton;
    private LinearLayout itemListLayout;
    private EditText newItemEditText;

    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraButton = findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LabellingActivity.class);
                startActivity(intent);
            }
        });

        itemListLayout = findViewById(R.id.itemListLayout);
        newItemEditText = findViewById(R.id.newItemEditText);

        itemList = new ArrayList<>();

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = newItemEditText.getText().toString();
                if (!newItem.isEmpty()) {
                    addItem(newItem);
                    newItemEditText.setText("");
                }
            }
        });
    }

    private void addItem(String item) {
        itemList.add(item);

        TextView itemTextView = new TextView(this);
        itemTextView.setText(item);

        Button deleteButton = new Button(this);
        deleteButton.setText("삭제");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(item);
            }
        });

        LinearLayout itemLayout = new LinearLayout(this);
        itemLayout.setOrientation(LinearLayout.HORIZONTAL);
        itemLayout.addView(itemTextView);
        itemLayout.addView(deleteButton);

        itemListLayout.addView(itemLayout);
    }

    private void removeItem(String item) {
        itemList.remove(item);

        for (int i = 0; i < itemListLayout.getChildCount(); i++) {
            View child = itemListLayout.getChildAt(i);
            if (child instanceof LinearLayout) {
                LinearLayout itemLayout = (LinearLayout) child;
                TextView itemTextView = (TextView) itemLayout.getChildAt(0);
                if (itemTextView.getText().toString().equals(item)) {
                    itemListLayout.removeView(itemLayout);
                    break;
                }
            }
        }
    }
}
