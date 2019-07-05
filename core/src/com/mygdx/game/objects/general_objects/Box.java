package com.mygdx.game.objects.general_objects;

import com.mygdx.game.objects.GameObject;
import com.mygdx.game.Destructable;

public  class Box<D> extends GameObject implements Destructable
{

    //Attributes
    Tile tile;
    Neighborhood neighborhood;

    //methods
    public  Box getNeighboor(D direction)
    {

        return neighborhood.getBox(direction);


    }

    @Override
    public void Destroy(GameObject object) { }
}
