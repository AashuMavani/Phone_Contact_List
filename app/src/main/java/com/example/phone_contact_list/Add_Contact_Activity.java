package com.example.phone_contact_list;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Add_Contact_Activity extends AppCompatActivity {
    ImageView back_button, more, add_image;
    Button save;
    EditText NAME, SURNAME, NUMBER, email;
    Uri image_uri;
    Bitmap bitmap;
    String imgname;
    String imgpath;
   My_Database my_database=new My_Database(Add_Contact_Activity.this);
   int id;
   String name1,surname1,number1,imgpath1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        back_button = findViewById(R.id.back_button);
        more = findViewById(R.id.more);
        add_image = findViewById(R.id.add_img);
        save = findViewById(R.id.save);
        NAME = findViewById(R.id.NAME);
        SURNAME = findViewById(R.id.SURNAME);
        NUMBER = findViewById(R.id.NUMBER);
        email = findViewById(R.id.email);


        id=getIntent().getIntExtra("id",0);
        name1=getIntent().getStringExtra("name");
        surname1=getIntent().getStringExtra("surname");
        number1=getIntent().getStringExtra("number");
        //imgpath1=getIntent().getStringExtra("imgpath");

        if (getIntent().getExtras()!=null)
        {
            NAME.setText(""+name1);
            SURNAME.setText(""+surname1);
            NUMBER.setText(""+number1);
        }
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Add_Contact_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (getIntent().getExtras()==null)
              {
                  String n1=NAME.getText().toString();
                  String n2=SURNAME.getText().toString();
                  String n3=NUMBER.getText().toString();
                  my_database.addContact(""+n1,""+n2,""+n3,imgpath);
              }else
              {
                  String n1=NAME.getText().toString();
                  String n2=SURNAME.getText().toString();
                  String n3=NUMBER.getText().toString();
                  my_database.updateContact(id,""+n1,""+n2,""+n3);
              }
              Intent intent=new Intent(Add_Contact_Activity.this,MainActivity.class);
              startActivity(intent);
            }
        });




    }


}