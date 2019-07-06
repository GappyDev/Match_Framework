package com.mygdx.game.objects.general_objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.Destructable;

public  class Box<D> extends GameObject implements Destructable
{

    //Attributes
    Tile tile;
    Neighborhood neighboors;

    //methods
    public  Box getNeighboor(D direction)
    {

        return neighboors.getBox(direction);


    }

    @Override
    public void Destroy(GameObject object)
    {
        dispose();
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        tile.draw(batch);
    }

    @Override
    public void dispose()
    {

        tile.dispose();

    }
}
