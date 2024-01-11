package com.example.doan1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList trasua_id, trasua_title, trasua_category, trasua_price;
    Animation translate_anim;
    CustomAdapter(Activity activity, Context context, ArrayList trasua_id, ArrayList trasua_title, ArrayList trasua_category, ArrayList trasua_price){
        this.activity = activity;
        this.context = context;
        this.trasua_id = trasua_id;
        this.trasua_title = trasua_title;
        this.trasua_category = trasua_category;
        this.trasua_price = trasua_price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.book_id_txt.setText(String.valueOf(trasua_id.get(position)));
        holder.book_title_txt.setText(String.valueOf(trasua_title.get(position)));
        holder.book_author_txt.setText(String.valueOf(trasua_category.get(position)));
        holder.book_pages_txt.setText(String.valueOf(trasua_price.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(trasua_id.get(position)));
                intent.putExtra("title", String.valueOf(trasua_title.get(position)));
                intent.putExtra("category", String.valueOf(trasua_category.get(position)));
                intent.putExtra("price", String.valueOf(trasua_price.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }


    @Override
    public int getItemCount() {
        return trasua_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            book_pages_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
//            Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
