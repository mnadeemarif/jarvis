package com.csgradqau.projectjarvis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class rearCam extends AppCompatActivity implements SurfaceHolder.Callback {

    protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;
    private SurfaceView SurView;
    private SurfaceHolder camHolder;
    private boolean previewRunning;
    final Context context = this;
    public static Camera camera = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rear_cam);

        SurView = (SurfaceView)findViewById(R.id.sview);
        camHolder = SurView.getHolder();
        camHolder.addCallback(this);
        camHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

        if(previewRunning){
            camera.stopPreview();
        }
        Camera.Parameters camParams = camera.getParameters();
        Camera.Size size = camParams.getSupportedPreviewSizes().get(0);
        camParams.setPreviewSize(size.width, size.height);
        camera.setParameters(camParams);
        try{
            camera.setPreviewDisplay(holder);
            camera.startPreview();
            previewRunning=true;
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        camera.stopPreview();
        camera.release();
        camera=null;
    }
}