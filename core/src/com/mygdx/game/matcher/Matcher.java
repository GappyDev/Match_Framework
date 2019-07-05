package com.mygdx.game.matcher;

import com.mygdx.game.Destructable;
import com.mygdx.game.objects.general_objects.Box;

import java.util.ArrayList;

public abstract class Matcher implements Destructable
{

    //Attributes
    protected ArrayList<Box> boxesThatMatched;
    protected Matcher next;


    //Methods
    protected abstract Boolean HasMatch();


}
