package com.mygdx.game.factories;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.general_objects.LinearBox;
import com.mygdx.game.objects.zuma_objects.Cannon;

public class Zuma_Factory extends Factory
{

    public LinearBox createLinearBox(Movement m, LinearBox r, LinearBox l, Texture tileTexture, int val, float x, float y)
    {

       return new LinearBox(m,r,l,tileTexture,val,x,y);

    }

    public GameObject createCannon(Texture texture, float x, float y, Movement m)
    {

        return new Cannon(texture,x,y,m);

    }


}
