package com.example.phone_contact_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.phone_contact_list.Model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView contact;
    RecyclerView recyclerView;
    ArrayList<Contact>contactlist=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact = findViewById(R.id.contact);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        ShowData();

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Add_Contact_Activity.class);
                startActivity(intent);
            }
        });
        Recyclerview_Adapter adapter=new Recyclerview_Adapter(MainActivity.this,contactlist);
        recyclerView.setAdapter(adapter);

    }

    private void ShowData() {
        My_Database my_database=new My_Database(MainActivity.this);
         Cursor cursor=my_database.ShowData();
         while (cursor.moveToNext())
         {
           int id=cursor.getInt(0);
           String name=cursor.getString(1);
           String surname=cursor.getString(2);
           String number=cursor.getString(3);
           String imguri=cursor.getString(4);
           Contact contact1=new Contact(id,name,surname,number,imguri);
           contactlist.add(contact1);
             Log.d("AAA", "ShowData: Create Data"+contact);


         }

    }

}