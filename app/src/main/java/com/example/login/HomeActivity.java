package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        text=findViewById(R.id.textView);

        Intent intent=getIntent();
        String kullanıcıadı=intent.getStringExtra("user");

        text.setText("Hoşgeldiniz :"+kullanıcıadı+"");

    }
}