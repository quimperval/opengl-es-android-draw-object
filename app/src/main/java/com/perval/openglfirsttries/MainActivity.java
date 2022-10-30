package com.perval.openglfirsttries;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.perval.openglfirsttries.glutils.CRenderer;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        //Set a renderer
        glSurfaceView.setRenderer(new CRenderer(this));

        setContentView(glSurfaceView);
    }

    @Override
    protected void onPause(){
        super.onPause();
        glSurfaceView.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        glSurfaceView.onResume();
    }

}