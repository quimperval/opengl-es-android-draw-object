package com.perval.openglfirsttries.glutils.shaders;

import static android.opengl.GLES20.glUseProgram;

import android.content.Context;

import com.perval.openglfirsttries.glutils.ShaderTools;
import com.perval.openglfirsttries.utils.FileUtils;

public class GenericShader {
    //Uniform constants
    protected static final String U_MATRIX = "u_Matrix";
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";
    protected static final String U_COLOR = "u_Color";

    //Attribute constants
    protected static final String A_POSITION = "a_Position";
    protected static final String A_COLOR = "a_Color";

    //Shader program id
    protected final int programId;

    protected GenericShader(Context context,int vertexShaderResourceId, int fragmentShaderResourceId){
        programId = ShaderTools.buildProgram(
                FileUtils.retrieveFileContent(context, vertexShaderResourceId),
                FileUtils.retrieveFileContent(context, fragmentShaderResourceId));
    }

    public void useProgram(){
        //Set the currentOpen gl shader to this program
        glUseProgram(programId);
    }

}
