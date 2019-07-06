package com.mygdx.game.movement;

import com.mygdx.game.objects.GameObject;


public class ProjectileMovement extends Movement
{
    float SPEED = 900f;

    @Override
    public void move(final float deltaTime, final GameObject object)
    {

       object.position.add(0,SPEED * deltaTime);


    }


}
