package com.perval.openglfirsttries.glutils.entity;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;
import static android.opengl.GLES20.glDrawArrays;
import static com.perval.openglfirsttries.utils.Constants.BYTES_PER_FLOAT;

import com.perval.openglfirsttries.glutils.VertexHolder;
import com.perval.openglfirsttries.glutils.shaders.ColorShader;

public class GlObject {
    private final VertexHolder vertexHolder;

    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 0;
    private static final int STRIDE = (POSITION_COMPONENT_COUNT)*BYTES_PER_FLOAT;

    private static final float[] VERTEX_DATA = {
            //Triangle fan
            0f,     0f,
            -0.5f,  -0.8f,
            0.5f,  -0.8f,
            0.5f,   0.8f,
            -0.5f,   0.8f,
            -0.5f,  -0.8f
    };

    public GlObject(){
        vertexHolder = new VertexHolder(VERTEX_DATA);
    }

    public void bindData(ColorShader colorShader){
        vertexHolder.setVertexAttribPointer(0, colorShader.getPositionAttributeLocation(), POSITION_COMPONENT_COUNT, 0);
    }

    public void draw(){
        glDrawArrays(GL_TRIANGLE_FAN, 0, 6);
    }


}
