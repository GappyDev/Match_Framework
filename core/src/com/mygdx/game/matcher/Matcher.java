package com.mygdx.game.matcher;

import com.mygdx.game.interfaces.Destructable;
import com.mygdx.game.interfaces.MatchHandler;
import com.mygdx.game.objects.general_objects.Box;
import com.mygdx.game.objects.general_objects.LinearBox;

import java.util.ArrayList;

public class Matcher implements Destructable, MatchHandler
{

    //Attributes
    protected ArrayList<Box> boxesThatMatched;
    protected ArrayList<Box> boxesToRemove;
    protected Matcher next;

    //constructor
    public Matcher(Matcher next)
    {

        this.next = next;
        boxesThatMatched = new ArrayList<Box>();

    }

    public void clearMatchedBoxArray()
    {

    }

    @Override
    public void Destroy(ArrayList<LinearBox> boxes)
    {



    }


    @Override
    public boolean HasMatch(Box b1 , Box b2, ArrayList<LinearBox> boxes)
    {
        return false;
    }

}
