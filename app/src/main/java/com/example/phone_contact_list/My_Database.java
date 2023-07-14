package com.example.phone_contact_list;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class My_Database extends SQLiteOpenHelper {
    public My_Database(Context context) {
        super(context, "Contact-book", null, 1);
        Log.d("TTT", "My_Database: Create Contact");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="Create Table Contact_book(ID integer primary key autoincrement,NAME text,SURNAME text,NUMBER text,IMGURI text)";
        db.execSQL(query);
        Log.d("TTT", "My_Database: Create Table");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(String name, String surname, String number, String imgpath) {
        String query="insert into Contact_book(NAME,SURNAME,NUMBER,IMGURI)values('"+name+"','"+surname+"','"+number+"','"+imgpath+"')";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }

    public Cursor ShowData() {
        String query="select * from Contact_book";
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }

    public void updateContact(int id, String name, String surname, String number) {
        String query="update Contact_book set NAME='"+name+"',SURNAME='"+surname+"',NUMBER='"+number+"'where ID="+id+"";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }
}
