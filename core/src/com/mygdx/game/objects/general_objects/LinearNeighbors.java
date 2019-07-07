package com.mygdx.game.objects.general_objects;

public enum LinearNeighbors
{

    Right,Left;
    public LinearNeighbors getOpossite()
    {

        switch(this)
        {

            case Left:
                return Right;

            case Right:
                return Left;

            default:
                return null;

        }

    }

}
