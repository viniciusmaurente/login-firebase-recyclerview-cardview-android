package com.br.app4all.activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.app4all.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;
    TextView textViewDesc;
    View v;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView   = itemView.findViewById(R.id.image_single_view);
        textView    = itemView.findViewById(R.id.textView_single_title);
        textViewDesc= itemView.findViewById(R.id.event_desc);
        v = itemView;
    }
}

