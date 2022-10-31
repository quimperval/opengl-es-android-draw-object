package com.perval.openglfirsttries.glutils.entity;

public class PieceBuilder {

    public static Piece build(){
        float[] VERTEX_DATA = {
                //Triangle fan
                /* 0f,     0f,
                 -0.5f,  -0.8f,
                 0.5f,  -0.8f,
                 0.5f,   0.8f,
                 -0.5f,   0.8f,
                 -0.5f,  -0.8f*/
                0f,0f,
                0f,98.4f,
                -36.5f,98.4f,
                -36.5f,36.5f,
                -98.4f,36.5f,
                -98.4f,-36.5f,
                -36.5f,-36.5f,
                -36.5f,-98.4f,
                0f,-98.4f,
                36.5f,-98.4f,
                36.5f,-36.5f,
                98.4f,-36.5f,
                98.4f,0f,
                98.4f,36.5f,
                36.5f,36.5f,
                36.5f,98.4f,
                0f,98.4f

        };
        GlObject  mainBody = new GlObject(VERTEX_DATA);
        float[] FLANGE_A_VERTEX = {
                0f,98.4f,
                76.2f,98.4f,
                76.2f,114.3f,
                -76.2f,114.3f,
                -76.2f,98.4f
        };

        float[] FLANGE_B_VERTEX = {
                0f,-98.4f,
                76.2f,-98.4f,
                76.2f,-114.3f,
                -76.2f,-114.3f,
                -76.2f,-98.4f

        };
        float[] FLANGE_C_VERTEX = {
                98.4f,0f,
                98.4f,76.2f,
                114.3f,76.2f,
                114.3f,-76.2f,
                98.4f,-76.2f,


        };
        float[] FLANGE_D_VERTEX = {
                -98.4f,0f,
                -98.4f,76.2f,
                -114.3f,76.2f,
                -114.3f,-76.2f,
                -98.4f,-76.2f
        };



                GlObject  flangeA = new GlObject(FLANGE_A_VERTEX);
        GlObject  flangeB = new GlObject(FLANGE_B_VERTEX);
        GlObject  flangeC = new GlObject(FLANGE_C_VERTEX);
        GlObject  flangeD = new GlObject(FLANGE_D_VERTEX);
        Piece piece = new Piece();

        piece.addObject(mainBody);
        piece.addObject(flangeA);
        piece.addObject(flangeB);
        piece.addObject(flangeC);
        piece.addObject(flangeD);

        return piece;
    }
}
