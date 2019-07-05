package com.mygdx.game.factories;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.general_objects.LinearBox;

public abstract class Factory
{

    public abstract LinearBox createLinearBox(Movement m, LinearBox r, LinearBox l, Texture tileTexture, int val, float x, float y);
    public abstract GameObject createCannon(Texture texture, float x, float y, Movement m);

}
