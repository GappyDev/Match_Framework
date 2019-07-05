package com.mygdx.game.factories;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.GameObject;

public abstract class Factory
{

    public abstract GameObject createLinearBox(Movement movement);
    public abstract GameObject createCannon(Texture texture, float x, float y, Movement m);

}
