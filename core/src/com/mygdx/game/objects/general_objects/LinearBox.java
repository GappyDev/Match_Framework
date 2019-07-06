package com.mygdx.game.objects.general_objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.movement.LinearMovement;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.GameObject;

public class LinearBox extends Box<LinearNeighboors>
{

    //constructor
    public LinearBox(Movement m, LinearBox r, LinearBox l,Tile tile, float x, float y,float w, float h)
    {

        this.movement = m;
        this.position = new Vector2();

        this.position.x = x;
        this.position.y = y;

        this.tile = tile;
        this.tile.setPosition(this);

        this.width = w; this.height = h;

        //Neighbors
        this.neighboors = new Neighborhood<LinearNeighboors, LinearBox>();

    }

    public void setNeighbors(LinearBox right, LinearBox left)
    {

        this.neighboors.add(LinearNeighboors.Right,right);
        this.neighboors.add(LinearNeighboors.Left,left);

    }

    //methods
    @Override
    public void Destroy(GameObject object)
    {

    }

    @Override
    public void draw(SpriteBatch batch)
    {
        super.draw(batch);
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}
