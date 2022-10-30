package com.perval.openglfirsttries.utils;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {

    public static String retrieveFileContent(Context context, int resourceId){
        StringBuilder body = new StringBuilder();

        try{
            InputStream is = context.getResources().openRawResource(resourceId);
            InputStreamReader  isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String nextLine = "";
            while( (nextLine=br.readLine()) !=null){
                body.append(nextLine);
                body.append("\n");
            }
        }catch(IOException io){
            throw new RuntimeException("Could not open resource: " + resourceId, io);
        }catch(Resources.NotFoundException nfe){
            throw new RuntimeException("Resource not found " + resourceId, nfe);
        }


        return body.toString();
    }
}
