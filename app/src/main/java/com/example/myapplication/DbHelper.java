package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class DbHelper extends SQLiteOpenHelper {
    public static final String Databse_name = "user.db";
    public static final String Table_name = "details";
    public static final String ID = "id";
    public static final String fname = "fname";
    public static final String lname = "lname";
    public static final String phone = "phone";
    public static final String email = "email";
    public static final String web = "web";
    public static final String pass="password";
    private static final String TAG = "Main";

    public DbHelper(@Nullable Context context) {
        super(context, Databse_name, null, 12);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table details " +
                        "(id integer primary key, fname text,lname text,email text, phone text,web text,pass text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS details");
        onCreate(db);

    }

    public void insertD(Data data) {
        Log.e("listdata", "data.getFname(): 1" +data.getFname());
        ContentValues contentValues = new ContentValues();
        contentValues.put(fname, data.getFname());
        contentValues.put(lname, data.getLname());
        contentValues.put(email, data.getEmail());
        contentValues.put(phone, data.getMobile());
        contentValues.put(web, data.getWeb());
        contentValues.put(pass,data.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Table_name, null, contentValues);
    }
    public ArrayList<Data> listData(){
            String query="select * FROM " + Table_name;
            SQLiteDatabase db=this.getReadableDatabase();
            ArrayList<Data> storeData= new ArrayList<>();

        Log.e("listdata", "listData: 1" +storeData);
        Cursor cursor=db.rawQuery(query,null);

        Log.e("TAG", "cursor count===: "+cursor.getCount() );

//        while (cursor.moveToNext()) {
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(0);
                String Fname = cursor.getString(1);
                Log.e("id", "listData" + Fname);
                String Lname = cursor.getString(2);
                String email = cursor.getString(3);
                String phone = cursor.getString(4);
                String web = cursor.getString(5);
                storeData.add(new Data(Fname, Lname,phone,web,email,pass));
                Log.e(TAG, "listData: " + id);
            }
//        }
        }
        cursor.close();
        return storeData;
    }
    void Update(Data data){
        ContentValues contentValues =new ContentValues();

        contentValues.put(fname,data.getFname());
        contentValues.put(lname,data.getLname());
        contentValues.put(email,data.getEmail());
        contentValues.put(phone,data.getMobile());
        contentValues.put(web,data.getWeb());
        SQLiteDatabase db = this.getReadableDatabase();
        db.update(Table_name,contentValues,ID +" =   ? ",null);
    }

    void Delete(String id){
        SQLiteDatabase db =this.getWritableDatabase();
        db.delete(Table_name, id+" = ? ",new String[]{String.valueOf(id)});
    }
    void search(String Email,String Pass){
        String query="Select "+Email + "From " + Table_name+ "where "+ pass +"="+ Pass;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery(query,null);
        String s=cursor.getString(0);
        Log.e("String", "search: Login==> "+s);
//        if (cursor.moveToFirst()){
//            while (cursor.moveToNext()){
//
//            }
//        }
    }
}