package com.example.myapplication;

import android.graphics.drawable.Icon;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class View_Holder extends RecyclerView.ViewHolder {

    TextView Fname;
    TextView Lname;
    TextView Mobile;
    TextView Web;
    TextView Email;
    ImageView Edit;
    ImageView Call;
    ImageView Sms;
    ImageView Wp;
    ImageView Emailic;

    public View_Holder(@NonNull View itemView) {
        super(itemView);
        Fname=itemView.findViewById(R.id.FnameV);
        Lname=itemView.findViewById(R.id.lnamev);
        Mobile=itemView.findViewById(R.id.phone);
        Web=itemView.findViewById(R.id.web);
        Email=itemView.findViewById(R.id.email);
        Edit = (ImageView) itemView.findViewById(R.id.editic);
        Call = (ImageView) itemView.findViewById(R.id.callic);
        Sms = (ImageView) itemView.findViewById(R.id.smsic);
        Wp = (ImageView) itemView.findViewById(R.id.wp);
        Emailic = (ImageView) itemView.findViewById(R.id.emailic);

    }

}
