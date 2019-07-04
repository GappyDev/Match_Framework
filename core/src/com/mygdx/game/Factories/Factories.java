package com.mygdx.game.Factories;

public enum Factories
{

    Zuma,CandyCrush,Tetris;

    public Factory setFactory()
    {

        switch (this)
        {

            case Zuma:
                return new Zuma_Factory();

            default:
                return null;


        }

    }

}
