package com.example.kinarya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.Normalizer;

public class FormAct extends AppCompatActivity {

    Button btn_submit;
    EditText nama, destinasi, email, telepon, tanggal;
    DatabaseReference reference;

    String NAMA_KEY = "nama";
    String nama_key = "";

    String textNama, textDestinasi, textEmail, textTelepon, textTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btn_submit = findViewById(R.id.btn_submit);

        nama = findViewById(R.id.nama);
        destinasi = findViewById(R.id.destinasi);
        email = findViewById(R.id.email);
        telepon = findViewById(R.id.telepon);
        tanggal = findViewById(R.id.tanggal);

        textNama = nama.getText().toString();
        textDestinasi = destinasi.getText().toString();
        textEmail = email.getText().toString();
        textTelepon = telepon.getText().toString();
        textTanggal = tanggal.getText().toString();

        btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { SharedPreferences sharedPreferences = getSharedPreferences(NAMA_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(nama_key, nama.getText().toString());
                editor.apply();

                reference = FirebaseDatabase.getInstance().getReference().child("Form").child(nama.getText().toString());
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("nama").setValue(nama.getText().toString());
                        dataSnapshot.getRef().child("nama_tour").setValue(destinasi.getText().toString());
                        dataSnapshot.getRef().child("email").setValue(email.getText().toString());
                        dataSnapshot.getRef().child("telepon").setValue(telepon.getText().toString());
                        dataSnapshot.getRef().child("tanggal").setValue(tanggal.getText().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                Intent gotosukses = new Intent(FormAct.this, SuksesAct.class);
                startActivity(gotosukses);

                }
            });

    }
}