package com.mygdx.game.objects.general_objects;

public enum LinearNeighboors
{

    Right,Left;
    public LinearNeighboors getOpossite()
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
