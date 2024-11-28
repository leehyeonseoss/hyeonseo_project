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

public class category2 extends AppCompatActivity {

    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category2);
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
                Intent intent = new Intent(category2.this, faq2.class);
                startActivity(intent);
            }
        });

        //카테고리 재선택
        reselectCategoryButton = findViewById(R.id.reselectCategoryButton);
        reselectCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category2.this, category.class);
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
                question.setText("1.등기부 등본 확인\n" +
                        "계약 전에 반드시 등기부등본을 열람하여 소유권,\n" +
                        "근저당, 가압류 등의 권리관계를 확인합니다.\n" +
                        "등기소나 주민센터에서 열람 가능합니다.\n" +
                        "2.전입신고 및 확정일 받기 \n" +
                        "3.계약서 보관\n" +
                        "4.전세 보증 보험 가입\n" +
                        "\n"+
                        "계약서 작성시 항목들을 꼼꼼히 확인\n" +
                        "하시고 양측 모두 서명해야해요.");
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