package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import static android.widget.Toast.LENGTH_LONG;

public class Registration extends AppCompatActivity {
    TextView name,lname,mob,email,web,password,confpass;
    Button b;
    DbHelper dbHelper;
    private Context context;
    Data data;
    Intent intent = getIntent();
    String ID=null;
    String Fname,Lname,Email,Phone,Website;
    String Fnamet,Lnamet,Emailt,Phonet,Websitet,passwordt;


    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
//         View view = inflater.inflate(R.layout.registration, container, false);
         name=findViewById(R.id.name);
         lname=findViewById(R.id.lname);
         mob=findViewById(R.id.phone);
         email=findViewById(R.id.email);
         web=findViewById(R.id.web);
         password=findViewById(R.id.password);
         confpass=findViewById(R.id.Conformpass);

         b=findViewById(R.id.Button);
         dbHelper = new DbHelper(this);

         Fnamet=name.getText().toString();
         Lnamet=lname.getText().toString();
         Emailt=email.getText().toString();
         Websitet=web.getText().toString();
         Phone=mob.getText().toString();
         passwordt=password.getText().toString();


         intent = getIntent();
         if(intent!=null) {
             ID = intent.getStringExtra("ID");
             Fname = intent.getStringExtra("Fname");
             Lname = intent.getStringExtra("Lname");
             Email = intent.getStringExtra("Email");
             Phone = intent.getStringExtra("Phone");
             Website = intent.getStringExtra("Website");

             name.setText(Fname);
             lname.setText(Lname);
             email.setText(Email);
             mob.setText(Phone);
             web.setText(Website);
         }
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                //validation part

                if (Fnamet== null && Lnamet == null && Emailt == null && Websitet ==null && (Phonet ==null)) {
                    Toast t=Toast.makeText(getApplicationContext(),"Enter the Whole Data",LENGTH_LONG);
                    t.show();
                }
                if(passwordt.equals(confpass.getText().toString()))
                {
                    Toast t=Toast.makeText(getApplicationContext(),"Enter the same Password",LENGTH_LONG);
                    t.show();
                }
//                else {


                Log.e("Intent", "onClick: "+intent+"ID=> "+ID);
                data=new Data(name.getText().toString(),lname.getText().toString(),mob.getText().toString(),web.getText().toString(),email.getText().toString(),passwordt);
                if(ID==null){
                dbHelper.insertD(data);
                    Log.e("parthi","data--->"+data);
                    // Log.e("sub", "submit: data inserted");
                    Toast t=Toast.makeText(getApplicationContext(),"data iserted", LENGTH_LONG);
                    t.show();
                    Intent intent=new Intent(Registration.this,recyclerviev.class);
                    startActivity(intent);
                }
                else {
                    dbHelper.Update(data);
                    Log.e("parthi","data--->"+data);
                    // Log.e("sub", "submit: data inserted");
                    Toast t=Toast.makeText(getApplicationContext(),"data iserted", LENGTH_LONG);
                    t.show();
                    Intent intent=new Intent(Registration.this,recyclerviev.class);
                    startActivity(intent);
                }

            }
        });

//}

    }


}
