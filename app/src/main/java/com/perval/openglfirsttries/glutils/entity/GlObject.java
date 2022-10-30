package com.perval.openglfirsttries.glutils.entity;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;
import static android.opengl.GLES20.glDrawArrays;
import static com.perval.openglfirsttries.utils.Constants.BYTES_PER_FLOAT;

import android.util.Log;

import com.perval.openglfirsttries.glutils.VertexHolder;
import com.perval.openglfirsttries.glutils.shaders.ColorShader;

public class GlObject {
    private VertexHolder vertexHolder;

    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 0;
    private static final int STRIDE = (POSITION_COMPONENT_COUNT)*BYTES_PER_FLOAT;

    private int limit;

    private int mode;
    private int start;
    public GlObject(){
        float[] VERTEX_DATA = {
                //Triangle fan
               /* 0f,     0f,
                -0.5f,  -0.8f,
                0.5f,  -0.8f,
                0.5f,   0.8f,
                -0.5f,   0.8f,
                -0.5f,  -0.8f*/
                0f,0f,
                0f,98.4f,
                -36.5f,98.4f,
                -36.5f,36.5f,
                -98.4f,36.5f,
                -98.4f,-36.5f,
                -36.5f,-36.5f,
                -36.5f,-98.4f,
                0f,-98.4f,
                36.5f,-98.4f,
                36.5f,-36.5f,
                98.4f,-36.5f,
                98.4f,0f,
                98.4f,36.5f,
                36.5f,36.5f,
                36.5f,98.4f,
                -36.5f,98.4f

        };
        this.start = 0;
        this.limit = VERTEX_DATA.length/(POSITION_COMPONENT_COUNT + TEXTURE_COORDINATES_COMPONENT_COUNT);
        this.mode = GL_TRIANGLE_FAN;
        vertexHolder = new VertexHolder(VERTEX_DATA);
    }

    public void bindData(ColorShader colorShader){
        vertexHolder.setVertexAttribPointer(0, colorShader.getPositionAttributeLocation(), POSITION_COMPONENT_COUNT, 0);
    }

    public void draw(){

        int mStart = 0;
        int mEnd = 6;
        Log.i("GL_Object", "Start "+ start );
        Log.i("GL_Object", "End "+ limit );
        glDrawArrays(mode, start, limit);
    }
}
