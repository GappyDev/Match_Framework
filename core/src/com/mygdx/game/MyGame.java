package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.Factories.Factory;

public abstract class  MyGame<E> extends ApplicationAdapter
{

    protected Factory<E> factory;

}
