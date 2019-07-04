package com.mygdx.game.matcher;

import com.mygdx.game.objects.general_objects.Box;

import java.util.ArrayList;

public abstract class Matcher
{

    //Attributes
    protected ArrayList<Box> boxThatMatched;
    protected Matcher next;


    //Methods
    protected abstract Boolean HasMatch();


}
