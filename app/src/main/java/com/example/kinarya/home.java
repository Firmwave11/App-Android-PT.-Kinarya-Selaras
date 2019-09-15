package com.example.kinarya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class home extends AppCompatActivity {

    TextView home_title;
    Animation rtl, btt, ttb;
    ImageView btn_paris, btn_umroh, btn_israel;
    LinearLayout btn_tour, btn_testi, btn_about, menus;
    HorizontalScrollView hsv_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_title = findViewById(R.id.home_title);
        btn_paris = findViewById(R.id.btn_paris);
        btn_umroh = findViewById(R.id.btn_umroh);
        btn_israel = findViewById(R.id.btn_israel);
        btn_tour = findViewById(R.id.btn_tour);
        btn_testi = findViewById(R.id.btn_testi);
        btn_about = findViewById(R.id.btn_about);
        menus = findViewById(R.id.menus);
        hsv_home = findViewById(R.id.hsv_home);

        //load animation
        rtl = AnimationUtils.loadAnimation(this,R.anim.rtl);
        btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this,R.anim.ttb);


        //run animation
        home_title.startAnimation(ttb);
        menus.startAnimation(btt);
        hsv_home.startAnimation(rtl);


        btn_paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoparis = new Intent(home.this, DetailTour.class );
                // meletakkan data pada Intent
                gotoparis.putExtra("jenis_tour", "Paris");
                startActivity(gotoparis);
            }
        });

        btn_umroh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoumroh = new Intent(home.this, DetailTour.class );
                gotoumroh.putExtra("jenis_tour", "Umroh");
                startActivity(gotoumroh);
            }
        });

        btn_israel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoisrael = new Intent(home.this, DetailTour.class );
                gotoisrael.putExtra("jenis_tour", "Israel");
                startActivity(gotoisrael);
            }
        });

        btn_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototour = new Intent(home.this,ToursAct.class);
                startActivity(gototour);
            }
        });

        btn_testi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototesti = new Intent(home.this,TestiAct.class);
                startActivity(gototesti);
            }
        });

        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoabout = new Intent(home.this,AboutAct.class);
                startActivity(gotoabout);
            }
        });
    }
}
