package com.example.phone_contact_list;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phone_contact_list.Model.Contact;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Recyclerview_Adapter extends RecyclerView.Adapter<Recyclerview_Adapter.viewholder> {
    MainActivity mainActivity;
    ArrayList<Contact> contactlist;
    public Recyclerview_Adapter(MainActivity mainActivity, ArrayList<Contact> contactlist) {
        this.mainActivity=mainActivity;
        this.contactlist=contactlist;
    }

    @NonNull
    @Override
    public Recyclerview_Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.recyclerview_item_layout,parent,false);
        viewholder holder=new viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview_Adapter.viewholder holder, @SuppressLint("RecyclerView") int position) {
     holder.t1.setText(contactlist.get(position).getName());
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(mainActivity, Add_Contact_Activity.class);
             intent.putExtra("id",contactlist.get(position).getId());
             intent.putExtra("name",contactlist.get(position).getName());
             intent.putExtra("surname",contactlist.get(position).getSurname());
             intent.putExtra("number",contactlist.get(position).getNumber());
             //intent.putExtra("imgpath",contactlist.get(position).getImgpath());
             mainActivity.startActivity(intent);
         }
     });

     
    }

    @Override
    public int getItemCount() {
        return contactlist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
       CircleImageView item_image;
       TextView t1;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            item_image=itemView.findViewById(R.id.item_image);
            t1=itemView.findViewById(R.id.item_name);
        }
    }
}
