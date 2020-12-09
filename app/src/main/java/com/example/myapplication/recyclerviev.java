package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class recyclerviev extends AppCompatActivity {
    View_Holder holder;
     RecyclerView   mRecycler;
    private DbHelper db = new DbHelper(this);
    ArrayList<Data> data;
    Data d;
    DbHelper mDatabase;
    Recyadapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerviev);
        data = db.listData();

        Log.e("parthi", "data--->" + data);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerview);
        mRecycler.setHasFixedSize(true);

        mDatabase = new DbHelper(this);
        madapter = new Recyadapter(this, data);


        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        Log.e("pos", "onSwiped:2------ " + data.size());
        mRecycler.setAdapter(new Recyadapter(this, data));

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                Toast.makeText(getApplicationContext(), "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                int position = viewHolder.getAdapterPosition();
                Toast.makeText(recyclerviev.this, "Swiped on " + position, Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
//                Log.e("pos", "onSwiped:------ " + position + "||" + "||" + viewHolder+"||"+d.Email);
                mDatabase.Delete(d.getId());
                //madapter.notifyItemRemoved(position);
                //madapter.notifyItemRangeChanged(position, data.size());

                data.remove(position);
                madapter = new Recyadapter(recyclerviev.this, data);
                Log.e("pos", "onSwiped:1------ " + data.size());
                mRecycler.setAdapter(madapter);
                madapter.notifyDataSetChanged();
//                position=0;
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecycler);
    }
}