package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class faq1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_faq1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView number,question;
        EditText messageInput1;
        Button send1;

        number = findViewById(R.id.number);
        question = findViewById(R.id.question);
        messageInput1 = findViewById(R.id.messageInput1);
        send1 = findViewById(R.id.send1);


        //채팅창 돌아가기
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(faq1.this, Category1Activity.class);
                startActivity(intent);
            }
        });

        //번호 입력하면 답 주는 거, 다른 faq에 코드 카피하고 text를 카테고리에 맞게 수정 
        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = messageInput1.getText().toString().trim();
                if (input.equals("1")) {
                    question.setText("청년월세제도\n신청일 기준 주민등록등본상 서울시에 거주\n"+
                            "주민등록등본상 서울시에 거주하고 신청연도 기준 만19세~만39세 청년\n" +
                            "임차보증금 8천만원 이하 및 월세 60만원이하 건물에 월세로 거주하는 무주택자\n" +
                            "기준 중위소득 150% 이하 청년 1인 가구");
                } else if (input.equals("2")) {
                    question.setText("https://housing.seoul.go.kr/site/main/polcyManageInfo/customized/list 에서 내게 맞는 정책을 확인해보세요 ");
                } else {
                    question.setText("숫자를 입력하세요");
                }
                number.setText(input);
                number.setVisibility(View.VISIBLE);
                question.setVisibility(View.VISIBLE);
            }
        });

    }
}