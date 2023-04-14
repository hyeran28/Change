package org.tensorflow.lite.examples.detection.change;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;


    Button btn_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btn_sub = findViewById(R.id.button_sub);

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // ListView 초기화
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, getItems());
        listView.setAdapter(adapter);

        // ListView 아이템 선택 리스너 등록
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
                ArrayList<String> selectedItems = new ArrayList<>();
                for (int i = 0; i < checkedItemPositions.size(); i++) {
                    int pos = checkedItemPositions.keyAt(i);
                    if (checkedItemPositions.valueAt(i))
                        selectedItems.add(adapter.getItem(pos));
                }

                // 선택된 아이템 처리
                Toast.makeText(AddActivity.this, "선택된 항목: " + selectedItems.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // ListView에 표시할 항목들 반환
    private String[] getItems() {
        return new String[]{"항목1", "항목2", "항목3", "항목4", "항목5"};
    }
}








