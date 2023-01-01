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
import com.perval.openglfirsttries.glutils.entity.Piece;
import com.perval.openglfirsttries.glutils.entity.PieceBuilder;
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
    private Piece piece;
    private final float[] projectionMatrix = new float[16];

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

        //Initialize vertex data / array holder
        //The constructors has an inner call to vertexHolder
        //commented as the gl object is created in the build method
        //glObject = new GlObject();
        piece = PieceBuilder.build();
        //Initialize shaders, color shader is the one used for rendering triangles
        colorshader = new ColorShader(context);

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        glViewport(0,0, width, height);



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

        float boundingBoxWidth = 300;
        float boundingBoxHeight = 300;

        float aspectRatio;

        if(width>height){
            //Landscape
            aspectRatio = (float) width / (float) height;
            orthoM(projectionMatrix, 0, -aspectRatio*boundingBoxHeight, aspectRatio*boundingBoxHeight, -boundingBoxHeight, boundingBoxHeight, -1f, 1f);
        } else {
            //Portrait or square
            aspectRatio = (float) height / (float) width;
            orthoM(projectionMatrix, 0, -boundingBoxWidth, boundingBoxWidth, -boundingBoxWidth*aspectRatio, boundingBoxWidth*aspectRatio, -1f, 1f);
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
        //glObject.bindData(colorshader);
        //Draw the arrays or call the method that does that
        //glObject.draw();
        //This does the bind and draw for each glObject
        piece.bindAndDraw(colorshader);

    }
}
