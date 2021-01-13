package com.csgradqau.projectjarvis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class sensorStatus extends AppCompatActivity {
    private MaterialButton rearCam;
    private MaterialButton frontCam;
    private MaterialButton ultrasonic;
    private MaterialButton speed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_status);
        rearCam = findViewById(R.id.rearCamStatus);
        frontCam = findViewById(R.id.frontCamStatus);
        ultrasonic = findViewById(R.id.ultrasonic);
        speed = findViewById(R.id.speedSensor);

        rearCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Rear Cam");
            }
        });

        frontCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Front Cam");
            }
        });

        ultrasonic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Ultrasonic");
            }
        });

        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog("Speed Sensor");
            }
        });

    }

    void showDialg(String x,Boolean y, String z){
        LayoutInflater lif = LayoutInflater.from(getApplicationContext());
        View view = lif.inflate(R.layout.status_dialog,null);
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(sensorStatus.this);
        alertDialogBuilderUserInput.setView(view);
        final TextView title = view.findViewById(R.id.dialg_title);
        final ImageView pic = view.findViewById(R.id.dialog_pic);
        final TextView status = view.findViewById(R.id.dialog_data);
        title.setText(x);
        if(y){
            pic.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else{
            pic.setBackgroundColor(getResources().getColor(R.color.red));
        }
        status.setText(z);
        alertDialogBuilderUserInput.show();
    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
    void dialog(String name){
        Boolean x = checkCameraHardware(getApplicationContext());
        String data;
        if (x){
            data = "Working";
        }
        else{
            data ="Faulty";
        }
        showDialg(name,x,data);
    }
}