package com.mygdx.game.objects.general_objects;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.objects.GameObject;

public class Tile<F> extends GameObject
{
    //Attributes
    Texture texture;
    F value;

    //methods
    public F getValue()
    {
        return value;
    }

}
