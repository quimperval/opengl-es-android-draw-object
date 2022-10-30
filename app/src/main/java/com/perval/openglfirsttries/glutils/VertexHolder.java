package com.perval.openglfirsttries.glutils;

import static android.opengl.GLES20.GL_FLOAT;
import static android.opengl.GLES20.glEnableVertexAttribArray;
import static android.opengl.GLES20.glVertexAttribPointer;
import static com.perval.openglfirsttries.utils.Constants.BYTES_PER_FLOAT;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class VertexHolder {

    private final FloatBuffer floatBuffer;

    public VertexHolder(float[] vertexData){
        floatBuffer = ByteBuffer.
                allocateDirect(vertexData.length*BYTES_PER_FLOAT).
                order(ByteOrder.nativeOrder()).
                asFloatBuffer().
                put(vertexData);
    }

    public void setVertexAttribPointer(int dataOffset, int attribLocation,
                                       int componentCount, int stride){
        floatBuffer.position(dataOffset);
        glVertexAttribPointer(attribLocation, componentCount, GL_FLOAT,
                false, stride, floatBuffer);
        glEnableVertexAttribArray(attribLocation);
        floatBuffer.position(0);
    }

}
