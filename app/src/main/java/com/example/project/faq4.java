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

public class faq4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_faq4);
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
                Intent intent = new Intent(faq4.this, category4.class);
                startActivity(intent);
            }
        });

        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = messageInput1.getText().toString().trim();
                if (input.equals("1")) {
                    question.setText("2024년 현재 서울의 평균 집값은 평수와 지역에 따라 다소 차이가 있습니다.\n" +
                            "서울에서 가장 인기 있는 평형인 84㎡의 아파트는\n"+
                            "평균 10억 원 이상으로 형성되어 있으며,\n"+
                            "60㎡ 아파트는 약 7억 원, 40㎡ 아파트는 5억 원 이상입니다\n");
                } else if (input.equals("2")) {
                    question.setText("https://apply.lh.or.kr/lhapply/main.do#gnrlPop 에서 청약정보, 일정을 확인해보세요 ");
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