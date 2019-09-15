package com.example.kinarya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutAct extends AppCompatActivity {

    Button btn_lokasi, btn_visimisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btn_lokasi = findViewById(R.id.btn_lokasi);
        btn_visimisi = findViewById(R.id.btn_visimisi);

        btn_lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotolocation = new Intent(AboutAct.this,Lokasi.class );
                startActivity(gotolocation);
            }
        });

        btn_visimisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotovisimisi = new Intent(AboutAct.this,VisidanmisiAct.class );
                startActivity(gotovisimisi);
            }
        });
    }
}
