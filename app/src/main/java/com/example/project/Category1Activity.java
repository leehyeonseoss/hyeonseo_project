package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Category1Activity extends AppCompatActivity {


    private TextView time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView guideText, content, question;
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
                Intent intent = new Intent(Category1Activity.this, faq1.class);
                startActivity(intent);
            }
        });

        //카테고리 재선택
        reselectCategoryButton = findViewById(R.id.reselectCategoryButton);
        reselectCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category1Activity.this, category.class);
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
                question.setText("1.청년 전세자금 대출\n" +
                        "주택도시기금의 버팀목 전세자금 대출\n" +
                        "등을 통해 저금리로 전세자금을 대출\n" +
                        "받을 수 있는 혜택입니다. \n" +
                        "\n" +
                        "2.청년 월세 지원 \n" +
                        "월세 부담을 줄이기 위해 최대 월 20\n" +
                        "만원 까지 지원 받을 수 있는 혜택입니\n" +
                        "다.");
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

