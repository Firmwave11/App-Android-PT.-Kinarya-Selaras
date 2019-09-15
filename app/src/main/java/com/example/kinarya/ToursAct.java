package com.example.kinarya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ToursAct extends AppCompatActivity {

    ImageView btn_paris, btn_umroh, btn_israel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours);

        btn_paris = findViewById(R.id.btn_paris);
        btn_umroh = findViewById(R.id.btn_umroh);
        btn_israel = findViewById(R.id.btn_israel);

        btn_paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoparis = new Intent(ToursAct.this, DetailTour.class );
                gotoparis.putExtra("jenis_tour", "Paris");
                startActivity(gotoparis);
            }
        });

        btn_umroh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoumroh = new Intent(ToursAct.this, DetailTour.class );
                gotoumroh.putExtra("jenis_tour", "Umroh");
                startActivity(gotoumroh);
            }
        });

        btn_israel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoisrael = new Intent(ToursAct.this, DetailTour.class );
                gotoisrael.putExtra("jenis_tour", "Israel");
                startActivity(gotoisrael);
            }
        });

    }
}
