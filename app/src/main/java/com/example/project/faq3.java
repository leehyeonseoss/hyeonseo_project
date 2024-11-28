package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class faq3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_faq3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView number,question;
        EditText messageInput1;
        Button backButton, send1;

        number = findViewById(R.id.number);
        question = findViewById(R.id.question);
        messageInput1 = findViewById(R.id.messageInput1);
        send1 = findViewById(R.id.send1);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(faq3.this, category3.class);
                startActivity(intent);
            }
        });

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = messageInput1.getText().toString().trim();
                if (input.equals("1")) {
                    question.setText("1.등기부 등본 확인\n" +
                    "계약 전에 반드시 등기부등본을 열람하여 소유권,\n" +
                            "근저당, 가압류 등의 권리관계를 확인합니다.\n" +
                            "등기소나 주민센터에서 열람 가능합니다.\n" +
                            "2.전입신고 및 확정일 받기 \n" +
                            "3.계약서 보관\n" +
                            "4.전세 보증 보험 가입\n");
                } else if (input.equals("2")) {
                    question.setText("https://easylaw.go.kr/CSP/CnpClsMain.laf?csmSeq=649&ccfNo=4&cciNo=2&cnpClsNo=1 에서 확인해보세요 ");
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