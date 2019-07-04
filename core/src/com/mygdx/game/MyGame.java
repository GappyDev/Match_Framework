package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.factories.Factory;

public abstract class  MyGame<E extends Factory> extends ApplicationAdapter
{

    protected Factory<E> factory;


}
