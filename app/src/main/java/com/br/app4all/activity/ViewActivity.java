package com.br.app4all.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import com.br.app4all.R;
import com.br.app4all.model.Usuario;

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
    TextView textViewDesc;
    TextView dataEvent;

    private Usuario usuarioLogado;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //Configurações iniciais
        ref            =   FirebaseDatabase.getInstance().getReference().child("Evento");
        imageView      =   findViewById(R.id.image_single_view_Activity);
        textView       =   findViewById(R.id.textView_single_title_Activity);
        textViewDesc   =   findViewById(R.id.desc_evento);
        dataEvent      =   findViewById(R.id.desc_data_evento);

        String EventKey = getIntent().getStringExtra("EventKey");

        ref.child(EventKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){

                    String EventName = snapshot.child("EventName").getValue().toString();
                    String EventDesc = snapshot.child("EventDesc").getValue().toString();
                    String ImageUrl = snapshot.child("ImageUrl").getValue().toString();
                    String DataEvent = snapshot.child("DataEvent").getValue().toString();

                    Picasso.get().load(ImageUrl).into(imageView);
                    dataEvent.setText(DataEvent);
                    textView.setText(EventName);
                    textViewDesc.setText(EventDesc);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}