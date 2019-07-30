package com.tobitoikimori.sunsystem;

import com.badlogic.gdx.graphics.Texture;

public class Body {
    public Texture ObjectBody;
    public int Width,Height,ObjectPosX,ObjectPosY;

    private int PosX(int ParentX, float R, double Time){
        int x1;
        x1 =(int) (ParentX + R * Math.cos(Time));
        return x1;
    }
    private int PosY(int ParentY, float R, double Time){
        int y1;
        y1 = (int) (ParentY + R * Math.sin(Time));
        return y1;
    }
    public void getPos(int ParentX, int ParentY, int R, double Time){
        ObjectPosX = PosX(ParentX,R, Time) + Width/2;
        ObjectPosY = PosY(ParentY,R, Time) + Height/2;
    }
}
