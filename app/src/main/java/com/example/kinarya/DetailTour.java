package com.example.kinarya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailTour extends AppCompatActivity {

    Button btn_booking, btn_itinerary;
    TextView nama_tour, lama_tour, ket_tour;
    ImageView foto_tour;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tour);

        btn_booking = findViewById(R.id.btn_booking);
        btn_itinerary = findViewById(R.id.btn_itinerary);

        nama_tour = findViewById(R.id.nama_tour);
        lama_tour = findViewById(R.id.lama_tour);
        ket_tour = findViewById(R.id.ket_tour);
        foto_tour = findViewById(R.id.foto_tour);



        // mengambil data dari Intent
        Bundle bundle = getIntent().getExtras();
        String jenis_tour_baru = bundle.getString("jenis_tour");

        // mengambil data dari firebase berdasarkan Intent
        reference = FirebaseDatabase.getInstance().getReference().child("Tour").child(jenis_tour_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // menimpa data yang ada dengan data yang baru
                nama_tour.setText(dataSnapshot.child("nama_tour").getValue().toString());
                lama_tour.setText(dataSnapshot.child("lama_tour").getValue().toString());
                ket_tour.setText(dataSnapshot.child("ket_tour").getValue().toString());
                Picasso.with(DetailTour.this)
                        .load(dataSnapshot.child("foto_tour").
                                getValue().toString()).centerCrop().fit()
                        .into(foto_tour);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoform = new Intent(DetailTour.this,FormAct.class );
                startActivity(gotoform);
            }
        });

        btn_itinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoitinerary = new Intent(DetailTour.this, ItineraryUmrohAct.class );
                startActivity(gotoitinerary);
            }
        });
    }
}
