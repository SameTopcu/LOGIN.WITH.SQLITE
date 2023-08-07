package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText kulad;
    EditText sifre;
    EditText tekrarsifre;
    Button kayıt;
    Button gırıs;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kulad=findViewById(R.id.editTextUsername);
        sifre=findViewById(R.id.editTextPassword);
        kayıt=findViewById(R.id.buttonRegister);
        gırıs=findViewById(R.id.buttonLogin);
        tekrarsifre=findViewById(R.id.editTextTextPassword2);
        DB= new DBHelper(this);



        kayıt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=kulad.getText().toString();
                String pass=sifre.getText().toString();
                String tekrar=tekrarsifre.getText().toString();

                if(user.equals("") || pass.equals("") || tekrar.equals("")){
                    Toast.makeText(MainActivity.this,"Lütfen istenilen yerleri boş bırakmayın.",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (pass.equals(tekrar)) {
                        Boolean checkuser=DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert=DB.insertData(user,pass);
                            if (insert==true){
                                Toast.makeText(MainActivity.this,"Başarıyla kayıt oldunuz.",Toast.LENGTH_SHORT).show();
                                //Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                //startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this,"Kayıt Olunamadı.",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this,"Böyle bir hesap bulunuyor lütfen giriş yapın.",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"Paralolar Uyuşmuyor lütfen tekrar deneyiniz.",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        gırıs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}