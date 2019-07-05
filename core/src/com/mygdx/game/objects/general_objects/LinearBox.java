package com.mygdx.game.objects.general_objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.movement.LinearMovement;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.GameObject;

public class LinearBox extends Box<LinearNeighboors>
{



    //attributes
    public Neighborhood<LinearNeighboors,LinearBox> vright;
    public Neighborhood<LinearNeighboors,LinearBox> vleft;

    //constructor
    public LinearBox(Movement m, LinearBox r, LinearBox l, Texture tileTexture, int val, float x, float y)
    {

        this.movement = new LinearMovement();
        this.position = new Vector2();
        this.position.x = x;
        this.position.y = y;
        this.tile = new Tile(tileTexture,val,this.position);


        //Neighbors
        vright = new Neighborhood<LinearNeighboors, LinearBox>();
        vleft = new Neighborhood<LinearNeighboors, LinearBox>();


      /*  vright.add(LinearNeighboors.Right,r);
        vleft.add(LinearNeighboors.Left,l);*/


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
