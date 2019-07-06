package com.mygdx.game.data_manager;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class DataManager
{

    //static attributes

    //DIMENSIONS
    public final float tile_width = 70.5f;
    public final float tile_height = 70.5f;
    public final float cannon_width = 100;
    public final float cannon_height = 100;

    //GAME CONSTANT VALUES
    public final int amountOfBoxes = 10;
    public final int distanceBetweenBoxes = -80;
    public final int boxPosY = 450;
    public final int fluctuation = 3; //values of tile

    //TEXTURES
    public final Texture tempTexture = new Texture("badlogic.jpg");
    public final Texture tempTexture2 = new Texture("bird.png");
    public final Texture tempTexture3 = new Texture("Logo arbolito.png");
    public final ArrayList<Texture> tileTextures = new ArrayList<Texture>();

    //SETTING UP TILE TEXTURES
    public void setTileTextures()
    {

        tileTextures.add(tempTexture); //temp texture
        tileTextures.add(tempTexture2); //temp texture
        tileTextures.add(tempTexture3); //temp texture
        tileTextures.add(tempTexture); //temp texture
        tileTextures.add(tempTexture); //temp texture
        tileTextures.add(tempTexture); //temp texture
        tileTextures.add(tempTexture); //temp texture
        tileTextures.add(tempTexture); //temp texture
        tileTextures.add(tempTexture); //temp texture
        tileTextures.add(tempTexture); //temp texture


    }



}
