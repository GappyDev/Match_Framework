package com.mygdx.game.factories;

import com.mygdx.game.data_manager.DataManager;
import com.mygdx.game.movement.Movement;
import com.mygdx.game.objects.general_objects.LinearBox;
import com.mygdx.game.objects.general_objects.Tile;
import com.mygdx.game.objects.zuma_objects.Cannon;



public class Zuma_Factory extends Factory
{


    //constructor
    public Zuma_Factory()
    {
        dm = new DataManager();
    }

    //methods
    @Override
    public LinearBox createLinearBox(Movement m, LinearBox r, LinearBox l, Tile tile, float pos_x, float pos_y)
    {
       return new LinearBox(m,r,l,tile,pos_x,pos_y,dm.tile_width,dm.tile_height);
    }
    @Override
    public Cannon createCannon(float pos_x, float pos_y, Movement m)
    {
        return new Cannon(dm.tempTexture,dm.cannon_width,dm.cannon_height,pos_x,pos_y,m);
    }
    @Override
    public Tile createTile(int val)
    {
        return new Tile(dm.tempTexture,val,dm.tile_width,dm.tile_height);
    }


}
