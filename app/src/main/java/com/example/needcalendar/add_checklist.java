package com.example.needcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class add_checklist  extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button okButton;
    private RecyclerView recyclerView1; // 체크박스가 체크된 경우의 리사이클러뷰
    private RecyclerView recyclerView2; // 체크박스가 해제된 경우의 리사이클러뷰
    private checklist adapter1; // recyclerView1의 어댑터
    private checklist adapter2;
    private DatabaseHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_checklist);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        okButton = findViewById(R.id.ok);

        // OK 버튼에 클릭 리스너를 설정합니다.
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // EditText에서 텍스트를 가져옵니다.
                String title = editText1.getText().toString();
                String place = editText2.getText().toString();
                String memo = editText3.getText().toString();

                /**
                 * 수정
                 */
                long eventId = dbHelper.insertData(title, place, memo);

                // 데이터베이스에 데이터를 추가합니다.
                // 추가 결과를 확인하고 필요한 작업을 수행합니다.
                if (eventId != -1) {
                    // 데이터가 성공적으로 추가됨
                    // 추가 후에 필요한 작업을 수행하세요
                    Toast.makeText(add_checklist.this, "일정이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(add_checklist.this, MainActivity.class);
                    startActivity(intent); // 메인 화면으로 이동

                } else {
                    // 데이터 추가 실패
                    // 실패한 경우 필요한 작업을 수행하세요
                    Toast.makeText(add_schedule.this, "일정 추가에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }


//                editText1.setText("");
//                editText2.setText("");
//                editText3.setText("");

                TextView titleTextView = findViewById(R.id.editText1);
                TextView placeTextView = findViewById(R.id.editText2);
                TextView memoTextView = findViewById(R.id.editText3);

                title = editText1.getText().toString();
                place = editText2.getText().toString();
                memo = editText3.getText().toString();

                titleTextView.setText(title);
                placeTextView.setText(place);
                memoTextView.setText(memo);

            }

        };



}
