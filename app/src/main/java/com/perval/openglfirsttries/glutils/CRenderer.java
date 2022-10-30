package com.perval.openglfirsttries.glutils;
import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glViewport;
import static android.opengl.Matrix.orthoM;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.telecom.Call;

import com.perval.openglfirsttries.glutils.entity.GlObject;
import com.perval.openglfirsttries.glutils.shaders.ColorShader;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CRenderer implements Renderer {

    Context context;

    public CRenderer(Context context){
        this.context = context;
    }
    private GlObject glObject;
    private ColorShader colorshader;

    private final float[] projectionMatrix = new float[16];

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

        //Initialize vertex data / array holder
        //The constructors has an inner call to vertexHolder
        glObject = new GlObject();
        //Initialize shaders, color shader is the one used for rendering triangles
        colorshader = new ColorShader(context);



        //get the uColor Location or call the method that does that

        //get the aPosition location or call the method that does that

        //in the floatArray/Buffer set the position or call the method that does that.

        //Call glVertexAttribPointer or call the method that does that for

        //Call glEnableVertexAttribArray or call the method that does that

        //get the uMatrix location or call the method that does that.
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        glViewport(0,0, width, height);
        final float aspectRatio = width>height ?
                (float) width / (float) height :
                (float) height / (float) width;
        //Set the aspect ration, call the projection matrix and call the orthoM method

        /*orthoM
         *projectionMarix - float[] m - the destination array
         * mOffset - the offset in to m which the result is written
         * float left - the minimum range of the x-axis
         * float right - the maximum range of the x-axis
         * float bottom - the minimum range of the y-axis
         * float top - the maximum range ot the y-axis
         * float near - the minimum range of the z-axis
         * float far - the maximum range of the z-axis
         *
         */
        if(width>height){
            //Landscape
            orthoM(projectionMatrix, 0, -aspectRatio, aspectRatio, -1f, 1f, -1f, 1f);
        } else {
            //Portrait or square
            orthoM(projectionMatrix, 0, -1f, 1f, -aspectRatio, aspectRatio, -1f, 1f);
        }
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        glClear(GL_COLOR_BUFFER_BIT);
        //Use programs in shaders
        colorshader.useProgram();
        //Set uniforms
        /*
         * call glUniformMatrix4fv or call the method that does that, for setting the projectionMatrix
         * the setUniforms method runs the glUniformMatrix4fv
         * Call the method with the glUniform4f or
         * The setUniforms method runs the glUniform4f
         */
        colorshader.setUniforms(projectionMatrix, 0, 0, 1);
        //Bind shader to object with entities to be drawn
        glObject.bindData(colorshader);
        //Draw the arrays or call the method that does that
        glObject.draw();

    }
}
