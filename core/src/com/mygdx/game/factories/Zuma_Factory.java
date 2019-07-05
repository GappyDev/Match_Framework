package com.mygdx.game.factories;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.general_objects.LinearBox;
import com.mygdx.game.objects.zuma_objects.Cannon;

public class Zuma_Factory extends Factory
{

    public GameObject createLinearBox(Movement movement)
    {

       // return new LinearBox();
        return null;
    }

    public GameObject createCannon(Texture texture, float x, float y, Movement m)
    {

        return new Cannon(texture,x,y,m);

    }


}
