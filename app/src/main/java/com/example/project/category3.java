package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class category3 extends AppCompatActivity {

    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView guideText, content,question;
        Button reselectCategoryButton, send;
        EditText messageInput;
        LinearLayout chatContainer;

        guideText = findViewById(R.id.guideText);
        chatContainer = findViewById(R.id.chatContainer);
        send = findViewById(R.id.send);
        messageInput = findViewById(R.id.messageInput);
        content = findViewById(R.id.content);
        question = findViewById(R.id.question);

        //자주묻는질문과답변
        Button faqButton = findViewById(R.id.faqButton);
        faqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category3.this, faq3.class);
                startActivity(intent);
            }
        });

        //카테고리 재선택
        reselectCategoryButton = findViewById(R.id.reselectCategoryButton);
        reselectCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category3.this, category.class);
                startActivity(intent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = messageInput.getText().toString();
                content.setText(inputText);
                chatContainer.setVisibility(View.VISIBLE);
                guideText.setVisibility(View.GONE);
                question.setVisibility(View.VISIBLE);
                question.setText("법률상 계약해지 통보는 종료일로부터 \n" +
                        "2개월전에 해야돼요. 계약에 관한 얘기\n" +
                        "가 오가지 않았다면, 묵시적 갱신으로 \n" +
                        "계약이 자동으로 연장되는 것인데 주택 \n" +
                        "임대차 보호법상 계약이 갱신된 경우라\n" +
                        "면 세입자 가 언제든 전세금을 돌려받\n" +
                        "을 수 있고, 전세금반환 소송을 제기할 \n" +
                        "수 있어요");
            }
        });

        //시간
        time = findViewById(R.id.time);
        updateTime();

    }

    private void updateTime() {
        // 현재 시간을 포맷에 맞게 가져오기
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        time.setText(currentTime);
    }
}