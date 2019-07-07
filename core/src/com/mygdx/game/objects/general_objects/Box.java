package com.mygdx.game.objects.general_objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.Destructable;

public  class Box<D> extends GameObject implements Destructable
{

    //Attributes
    Tile tile;
    Neighborhood neighbors;

    //methods
    public  Box getNeighboor(D direction)
    {
        return neighbors.getBox(direction);

    }

    public void setPosition(float x, float y){this.position = new Vector2(x,y);}

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

    public Tile getTile()
    {
        return tile;
    }
}
