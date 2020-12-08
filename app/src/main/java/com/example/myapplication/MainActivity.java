package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment,new Login_frag());
//        ft.addToBackStack(null);
//        ft.commit();
    }

    Intent i;
    public void Signup(View view) {
        i=new Intent(this,Registration.class);
        startActivity(i);
    }
    public void SignIn(View view){
        i=new Intent(this,Login.class);
        startActivity(i);
    }
}