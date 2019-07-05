package com.mygdx.game.objects.general_objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.GameObject;

public class Tile<F> extends GameObject
{
    //Attributes
    Texture texture;
    F value;

    public Tile(Texture texture, F value)
    {
        this.texture = texture;
        this.value = value;
    }

    //constructor


    //methods
    public F getValue()
    {
        return value;
    }

    @Override
    public void draw(SpriteBatch batch)
    {

    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }
}
