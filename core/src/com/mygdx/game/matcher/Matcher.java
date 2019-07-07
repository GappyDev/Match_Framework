package com.mygdx.game.matcher;

import com.mygdx.game.interfaces.Destructable;
import com.mygdx.game.interfaces.MatchHandler;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.general_objects.Box;

import java.util.ArrayList;

public abstract class Matcher implements Destructable, MatchHandler
{

    //Attributes
    protected ArrayList<Box> boxesThatMatched;
    protected Matcher next;

    @Override
    public void Destroy(GameObject object)
    {

    }

}
