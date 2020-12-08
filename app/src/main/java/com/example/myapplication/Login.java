package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView email,pass;
    DbHelper dbHelper;
    String emailt,passt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.emailreg);
        pass=findViewById(R.id.passreg);

        emailt=email.getText().toString();
        passt=pass.getText().toString();

    }


    public void Submit(View view) {
        dbHelper.search(emailt,passt);
    }
}