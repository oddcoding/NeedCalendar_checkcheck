package com.example.needcalendar;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodayCalendar extends AppCompatActivity {

    Context context;
    Button button;
    private RecyclerView mPostRecyclerView;
    private checklist mAdapter;
    private List<list> mDatas;

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private ChecklistAdapter adapter1;
    private ChecklistAdapter adapter2;
    private ChecklistAdapter adapter;
    private List<ListItem> checklistItems;
    private DatabaseHelper dbHelper;
    private TextView textView;
    private TextView titleTextView;
    private TextView placeTextView;
    private TextView memoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily);

        recyclerView2 = findViewById(R.id.list_rv);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        // DB 연결한 부분
        dbHelper = new DatabaseHelper(this);
        checklistItems = dbHelper.getAllItems();

        adapter = new ChecklistAdapter(checklistItems, context);
        recyclerView2.setAdapter(adapter);


    }
}






