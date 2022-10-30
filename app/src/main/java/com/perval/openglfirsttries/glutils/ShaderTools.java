package com.perval.openglfirsttries.glutils;

import static android.opengl.GLES20.GL_COMPILE_STATUS;
import static android.opengl.GLES20.GL_FRAGMENT_SHADER;
import static android.opengl.GLES20.GL_LINK_STATUS;
import static android.opengl.GLES20.GL_VERTEX_SHADER;
import static android.opengl.GLES20.glAttachShader;
import static android.opengl.GLES20.glCompileShader;
import static android.opengl.GLES20.glCreateProgram;
import static android.opengl.GLES20.glCreateShader;
import static android.opengl.GLES20.glDeleteProgram;
import static android.opengl.GLES20.glDeleteShader;
import static android.opengl.GLES20.glGetProgramInfoLog;
import static android.opengl.GLES20.glGetProgramiv;
import static android.opengl.GLES20.glGetShaderInfoLog;
import static android.opengl.GLES20.glGetShaderiv;
import static android.opengl.GLES20.glLinkProgram;
import static android.opengl.GLES20.glShaderSource;

import android.util.Log;

import com.perval.openglfirsttries.utils.Constants;

public class ShaderTools {

    private static final String TAG = "ShaderTools";

    public static int buildVertexShader(String shaderCode){
        return buildShader(GL_VERTEX_SHADER, shaderCode);
    }

    public static int buildFragmentShader(String shaderCode){
        return buildShader(GL_FRAGMENT_SHADER, shaderCode);
    }

    private static int buildShader(int type, String shaderCode){
        final int shaderId = glCreateShader(type);

        if(shaderId==0){
            if(Constants.SHOW_LOGS){
                Log.w(TAG, "Unable to create a shader");
            }
        }

        //Link the source to the shader
        glShaderSource(shaderId, shaderCode);

        //Compile the shader
        glCompileShader(shaderId);

        //Variable to hold the compilation status
        final int[] compilationStatus = new int[1];

        glGetShaderiv(shaderId, GL_COMPILE_STATUS, compilationStatus, 0);

        if(Constants.SHOW_LOGS){
            Log.v(TAG, "Compilation results: " + shaderId + glGetShaderInfoLog(shaderId));
        }

        if(compilationStatus[0]==0){
            //Delete the shader object
            glDeleteShader(shaderId);
            if(Constants.SHOW_LOGS){
                Log.w(TAG, "Compilation failed");
            }
        }

        return shaderId;
    }

    public static int buildProgram(String vertexShaderCode, String fragmentShadercode){
        int programId;
        //build the shaders
        int vertexShader = buildVertexShader(vertexShaderCode);
        int fragmentShader = buildFragmentShader(fragmentShadercode);

        //Link them into a shader program
        programId= linkProgram(vertexShader, fragmentShader);

        return programId;
    }

    public static int linkProgram(int vertexShaderId, int fragmentShaderId){
        final int programId = glCreateProgram();

        if(programId==0){
            if(Constants.SHOW_LOGS){
                Log.w(TAG, "Unable to create program");
            }
            return 0;
        }

        glAttachShader(programId, vertexShaderId);
        glAttachShader(programId, fragmentShaderId);

        glLinkProgram(programId);

        final int[] linkStatus = new int[1];

        glGetProgramiv(programId, GL_LINK_STATUS, linkStatus, 0);

        if(Constants.SHOW_LOGS){
            Log.v(TAG, "Results of linking program:\n"
                    +glGetProgramInfoLog(programId));
        }

        //If the link process failed
        if(linkStatus[0]==0){
            glDeleteProgram(programId);
            if(Constants.SHOW_LOGS){
                Log.w(TAG, "Linking of program failed");
            }
        }

        return programId;
    }


}
