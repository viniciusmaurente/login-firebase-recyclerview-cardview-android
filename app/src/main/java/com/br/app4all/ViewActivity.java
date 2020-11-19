package com.br.app4all;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.security.Key;

public class ViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;


    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        imageView   =   findViewById(R.id.image_single_view_Activity);
        textView    =   findViewById(R.id.textView_single_title_Activity);

        ref         =   FirebaseDatabase.getInstance().getReference().child("Evento");

        String EventKey = getIntent().getStringExtra("EventKey");

        ref.child("EventKey").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String eventName = snapshot.child("EventName").getValue().toString();
                    String ImageUrl = snapshot.child("ImageUrl").getValue().toString();

                    Picasso.get().load(ImageUrl).into(imageView);
                    textView.setText(eventName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}