package com.br.app4all;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.br.app4all.model.Usuario;
import com.br.app4all.util.ConfiguracaoFirebase;
import com.br.app4all.util.UsuarioFirebase;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.security.Key;

public class ViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    TextView textViewDesc;
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

        //Recuperar dados do usuário
        FirebaseUser usuarioPerfil = UsuarioFirebase.getUsuarioAtual();
        textView.setText( usuarioPerfil.getDisplayName() );
        textViewDesc.setText( usuarioPerfil.getEmail() );
        imageView.setImageURI(usuarioPerfil.getPhotoUrl());

        String EventKey = getIntent().getStringExtra("EventKey");

        ref.child(EventKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String EventName = snapshot.child("EventName").getValue().toString();
                    String EventDesc = snapshot.child("EventDesc").getValue().toString();
                    String ImageUrl = snapshot.child("ImageUrl").getValue().toString();

                    Picasso.get().load(ImageUrl).into(imageView);
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