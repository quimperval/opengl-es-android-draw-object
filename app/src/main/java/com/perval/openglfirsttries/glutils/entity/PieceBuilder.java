package com.perval.openglfirsttries.glutils.entity;

public class PieceBuilder {

    public static Piece build(){
        GlObject  glObject = new GlObject();
        Piece piece = new Piece();
        piece.addObject(glObject);

        return piece;
    }
}
