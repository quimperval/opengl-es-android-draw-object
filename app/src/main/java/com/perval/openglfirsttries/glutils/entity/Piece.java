package com.perval.openglfirsttries.glutils.entity;

import com.perval.openglfirsttries.glutils.shaders.ColorShader;

import java.util.LinkedList;
import java.util.List;

public class Piece {

    private List<GlObject> objects = new LinkedList<GlObject>();

    public Piece(){

    }

    public Piece(List<GlObject> objects){
        this.objects = objects;
    }

    public List<GlObject> getObjects() {
        return objects;
    }

    public void setObjects(List<GlObject> objects) {
        this.objects = objects;
    }

    public void bindAndDraw(ColorShader colorshader){
        for(GlObject object : objects){
            object.bindData(colorshader);
            object.draw();
        }
    }

    public void draw(){
        for(GlObject object : objects){
            object.draw();
        }
    }

    public void addObject(GlObject newObj){
        this.objects.add(newObj);
    }
}
