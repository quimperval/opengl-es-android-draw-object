package com.perval.openglfirsttries.glutils.shaders;

import static android.opengl.GLES20.glGetAttribLocation;
import static android.opengl.GLES20.glGetUniformLocation;
import static android.opengl.GLES20.glUniform4f;
import static android.opengl.GLES20.glUniformMatrix4fv;

import android.content.Context;

import com.perval.openglfirsttries.R;
import com.perval.openglfirsttries.glutils.CRenderer;

public class ColorShader extends GenericShader {
    //Uniforms location
    private final int uMatrixLocation;
    private final int uColorLocation;
    //Attribute locations
    private final int aPositionLocation;

    public ColorShader(Context context) {
        super(context, R.raw.simple_vertex_shader, R.raw.simple_fragment_shader);

        //retrieve the uniform location from the shader program
        uMatrixLocation = glGetUniformLocation(programId, U_MATRIX);
        uColorLocation = glGetUniformLocation(programId, U_COLOR);

        //Retrieve the attribute locations for the shader program
        aPositionLocation = glGetAttribLocation(programId, A_POSITION);
    }

    public void setUniforms(float[] projectionMatrix, float red, float green, float blue){
        //Pass the matrix into the shader program
        glUniformMatrix4fv(uMatrixLocation, 1, false, projectionMatrix, 0);
        glUniform4f(uColorLocation, red, green, blue, 1f);
    }

    public int getPositionAttributeLocation(){
        return aPositionLocation;
    }


}
