package com.example.kinarya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Animation app_splash;
    ImageView app_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this,R.anim.app_splash);

        //load element
        app_logo = findViewById(R.id.app_logo);

        //run animation
        app_logo.startAnimation(app_splash);

        //setting timer untuk 2s
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // merubah activity ke activity lain
                Intent gogetstarted = new Intent(MainActivity.this, home.class);
                startActivity(gogetstarted);
                finish();
            }
        }, 2000);
    }
}
