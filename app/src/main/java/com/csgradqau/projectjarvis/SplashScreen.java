package com.csgradqau.projectjarvis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN=2500;
    Animation top,bottom;

    TextView text;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);
        top= AnimationUtils.loadAnimation(this,R.anim.splash_top_animation);
        bottom= AnimationUtils.loadAnimation(this,R.anim.splash_bottom_animation);

        text=findViewById(R.id.smartHome);
        image=findViewById(R.id.splashLogo);

        text.setAnimation(bottom);
        image.setAnimation(top);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,home.class);

                Pair[] pair=new Pair[2];

                pair[0]=new Pair<View,String>(text,"s_text");
                pair[1]=new Pair<View,String>(image,"s_logo");

                ActivityOptions op=ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pair);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent,op.toBundle());

                //finish(); it will exit this activity no more calls
            }
        },SPLASH_SCREEN);


    }
}