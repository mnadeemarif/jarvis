package com.csgradqau.projectjarvis;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class test extends AppCompatActivity implements ServiceConnection,SerialListener {

    private static final int REQUEST_ENABLE_BT = 1;
    private TextView testData;
    private String deviceAddress;
    private SerialService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        testData = findViewById(R.id.testValues);


//        if (home.mmSocket.isConnected()) {
//            InputStream inputStream;
//            try {
//                inputStream = home.mmSocket.getInputStream();
//            } catch (IOException e) {
//                Log.e("Connection test ", "in test class");
//            }
//
//        } else {
//                Toast.makeText(this,"Not Connected !",Toast.LENGTH_LONG);
//        }


    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

    @Override
    public void onSerialConnect() {

    }

    @Override
    public void onSerialConnectError(Exception e) {

    }

    @Override
    public void onSerialRead(byte[] data) {

    }

    @Override
    public void onSerialIoError(Exception e) {

    }
}