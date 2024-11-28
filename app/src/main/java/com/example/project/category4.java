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

public class category4 extends AppCompatActivity {

    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category4);
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
                Intent intent = new Intent(category4.this, faq4.class);
                startActivity(intent);
            }
        });

        //카테고리 재선택
        reselectCategoryButton = findViewById(R.id.reselectCategoryButton);
        reselectCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category4.this, category.class);
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
                question.setText("부동산 정보와 관련해 유용한 사이트를 알려드릴게요!\n" +
                        "\n" +
                        "리걸엔진 \n" +
                        "법률 업무 돕는 검색 AI \n" +
                        "사이트 : https://legalengine.co.kr\n" +
                        "안심전세포털 (HUG)\n" +
                        "부동산 거래를 위한 보증 서비스와 전세사기 예방 정보를 제공\n" +
                        "사이트 : https://www.khug.or.kr/jeonse/index.jsp\n" +
                        "\n" +
                        "이 외에 더 궁금한 점이 있다면 \n" +
                        "챗 gpt에 접속하여 물어보세요!\n" +
                        "https://chatgpt.com/g/g-FvT4UOsoA-caesgpt");
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