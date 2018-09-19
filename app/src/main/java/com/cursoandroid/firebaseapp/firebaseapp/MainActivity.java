package com.cursoandroid.firebaseapp.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databaseReferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Usuario usuario = new Usuario();

        usuario.setNome("Cris");
        usuario.setSobrenome("Deus");
        usuario.setIdade(50);

        usuarioReferencia.child("004").setValue(usuario);
        */


      /* Produtos produtos = new Produtos();

       produtos.setId(001);
       produtos.setCor("preto");
       produtos.setFabricante("garoto");
       produtos.setDescricao("chocolate brancooo");

       usuarioReferencia.child("001").setValue(produtos);*/

      usuarioReferencia.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              Log.i("FIREBASE",dataSnapshot.getValue().toString());

          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError) {

          }
      });



    }
}
