package com.tobitoikimori.sunsystem;

import com.badlogic.gdx.graphics.Texture;

public class Planet extends Body {


    public Planet(Texture BodyTexture, int WIDTH, int HEIGHT){
        ObjectBody = BodyTexture;
        Width = WIDTH;
        Height = HEIGHT;
    }
}

