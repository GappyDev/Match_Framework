package com.mygdx.game.objects.general_objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.objects.GameObject;

public class Tile<F> extends GameObject
{
    //Attributes
    Texture texture;
    F value;

    public Tile(Texture texture, F value,Vector2 pos)
    {
        this.texture = texture;
        this.value = value;
        this.position = pos;
    }

    //constructor


    //methods
    public F getValue()
    {
        return value;
    }

    public void updateTilePosition(Vector2 pos)
    {

        this.position = pos;

    }

    @Override
    public void draw(SpriteBatch batch)
    {
       batch.begin();
       batch.draw(texture,position.x,position.y,100.5f,100.5f);
       batch.end();
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }
}
