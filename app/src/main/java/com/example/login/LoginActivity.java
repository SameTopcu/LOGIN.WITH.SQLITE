package com.example.login;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button btnlogın;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.editTextUsername1);
        password=findViewById(R.id.editTextPassword1);
        btnlogın=findViewById(R.id.buttonLogin1);
        DB=new DBHelper(this);

        btnlogın.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this,"İstenilen yerleri girin.",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass=DB.checkusernamepassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(LoginActivity.this,"Başarıyla giriş yaptınız.",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"Kullanıcı adı veya şifre hatalı.",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}