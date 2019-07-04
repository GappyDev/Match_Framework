package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.Factories.Factory;
import com.mygdx.game.Factories.Zuma_Factory;

public abstract class  MyGame<E> extends ApplicationAdapter
{

    protected Factory f = new Zuma_Factory();

}
