package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        dbHelper = new DbHelper(this);
        emailt=email.getText().toString();
        passt=pass.getText().toString();

    }


    public void Submit(View view) {
        boolean val;
        Log.e("TAG", "email: "+email.getText().toString() );
        Log.e("TAG", "pass: "+pass.getText().toString());
        val=dbHelper.search(email.getText().toString(),pass.getText().toString());
        if (val==true){
            Intent intent=new Intent(Login.this,recyclerviev.class);
            startActivity(intent);
        }
        else {
            Toast t=Toast.makeText(getApplicationContext(),"Inavlid ID or password",Toast.LENGTH_LONG);
            t.show();
        }
    }
}