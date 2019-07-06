package com.mygdx.game.factories;

import com.mygdx.game.data_manager.DataManager;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.general_objects.LinearBox;
import com.mygdx.game.objects.general_objects.Tile;
import com.mygdx.game.objects.zuma_objects.Cannon;

public abstract class Factory
{

    protected DataManager dm;
    public abstract LinearBox createLinearBox(Movement m, LinearBox r, LinearBox l, Tile tile, float x, float y);
    public abstract Cannon createCannon(float x, float y, Movement m);
    public abstract Tile createTile(int val);

    //GETTER
    public DataManager getDm()
    {
        return dm;
    }

}
