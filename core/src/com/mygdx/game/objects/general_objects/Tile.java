package com.mygdx.game.objects.general_objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.GameObject;

public class Tile<F> extends GameObject
{
    //Attributes
    Texture texture;
    F value;

    public Tile(Texture texture, F value,float w, float h)
    {
        this.texture = texture;
        this.value = value;
        this.width = w; this.height = h;

    }

    //constructor


    //methods
    public F getValue()
    {
        return value;
    }

    public void setPosition(GameObject object)
    {

        this.position = object.position;

    }

    @Override
    public void draw(SpriteBatch batch)
    {
       batch.begin();
       batch.draw(texture,position.x,position.y,this.width,this.height);
       batch.end();
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }
}
