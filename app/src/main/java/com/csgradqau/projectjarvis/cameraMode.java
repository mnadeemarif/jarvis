package com.csgradqau.projectjarvis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class cameraMode extends AppCompatActivity {
    private MaterialButton frontCam;
    private MaterialButton rearCam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_mode);
        frontCam = findViewById(R.id.frontBtn);
        rearCam = findViewById(R.id.rearBtn);
        Intent front = new Intent(this, com.csgradqau.projectjarvis.frontCam.class);
        Intent rear = new Intent(this, com.csgradqau.projectjarvis.rearCam.class);
        frontCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(front);
            }
        });
        rearCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(rear);
            }
        });
    }
}