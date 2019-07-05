package com.mygdx.game.objects.zuma_objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.general_objects.Box;


public class Cannon extends GameObject
{
   //attributes
    private Box projectile; //add secondary shot later
    private Texture texture;


    //constructor

    public Cannon(Texture t, float x, float y, Movement m) //pixel units
    {
        this.texture = t;
        this.position = new Vector2();
        this.position.x = x;
        this.position.y = y;
        this.movement = m;
    }


    //reload
    private void reload(){}

    //shoot
    private void shoot(GameObject projectile){}

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.begin();
        batch.draw(this.texture,this.position.x,this.position.y);
        batch.end();
    }

    @Override
    public void dispose()
    {
        texture.dispose();
    }


}
