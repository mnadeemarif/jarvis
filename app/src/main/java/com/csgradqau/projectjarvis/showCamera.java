package com.csgradqau.projectjarvis;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.hardware.camera2.*;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraX;

public class showCamera extends SurfaceView implements SurfaceHolder.Callback {
    CameraX camera;
    public showCamera(Context context, CameraX camera){
        super(context);
        this.camera = camera;
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }
}
