package com.mygdx.game.data_manager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;


public  class DataManager
{
    //static attributes

    //DIMENSIONS
    public final float tile_width = 70.5f;
    public final float tile_height = 90.5f;
    public final float cannon_width = 100;
    public final float cannon_height = 130;

    //GAME CONSTANT VALUES
    public final int amountOfBoxes = 10;
    public final int distanceBetweenBoxes = -110;
    public final int boxPosY = 350;
    public final int fluctuation = 3; //values of tile
    public Vector2 CannonTip = new Vector2(129.5f,100f);

    //TEXTURES
    public final Texture tempTexture = new Texture("badlogic.jpg");
    public final Texture tempTexture2 = new Texture("bird.png");
    public final Texture tempTexture3 = new Texture("Logo arbolito.png");
    public final Texture frogTexture = new Texture("frog.png");
    public final Texture texture1 = new Texture("gem1.png");
    public final Texture texture2 = new Texture("gem2.png");
    public final Texture texture3 = new Texture("gem3.png");
    public final Texture texture4 = new Texture("gem4.png");
    public final Texture texture5 = new Texture("gem5.png");
    public final ArrayList<Texture> tileTextures = new ArrayList<Texture>();

    //SETTING UP TILE TEXTURES
    public void setTileTextures()
    {

        tileTextures.add(texture1);
        tileTextures.add(texture3);
        tileTextures.add(texture4);
        tileTextures.add(texture5);
        tileTextures.add(texture2);


    }


}
