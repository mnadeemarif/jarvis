package com.csgradqau.projectjarvis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
public class home extends AppCompatActivity {

    private static final int REQUEST_DISCOVER_BT = 1;
    static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private MaterialButton btnconnectSensors,btncruiseMode,btnparkingMode,btncameraView,btnsetSafeDistance,btnsensorStatus;
    private ActionBar actionBar;
    Intent move;
//    private BluetoothAdapter bAdapter;
//    static BluetoothSocket mmSocket;
//    public static String data = "";
    //private static ConnectThread connectThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        actionBar = getActionBar();
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        btnconnectSensors = findViewById(R.id.connectSensors);
        btncruiseMode = findViewById(R.id.cruiseMode);
        btnparkingMode = findViewById(R.id.parkingMode);
        btncameraView = findViewById(R.id.cameraView);
        btnsetSafeDistance = findViewById(R.id.setSafeDistance);
        btnsensorStatus = findViewById(R.id.sensorStatus);
        Intent connectActivity = new Intent(this, connectSensors.class);
        btnconnectSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(connectActivity);
            }
        });
        Intent cruiseActivity = new Intent(this,cruiseMode.class);
        btncruiseMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cruiseActivity);
            }
        });

        Intent parkingActivity = new Intent(this,parkingMode.class);
        btnparkingMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(parkingActivity);
            }
        });

        Intent cameraActivity = new Intent(this,cameraMode.class);
        btncameraView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cameraActivity);
            }
        });

        Intent safeDistanceActivity = new Intent(this,safeDistance.class);
        btnsetSafeDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(safeDistanceActivity);
            }
        });

        Intent statusActivity = new Intent(this,sensorStatus.class);
        btnsensorStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(statusActivity);
            }
        });


}



}
