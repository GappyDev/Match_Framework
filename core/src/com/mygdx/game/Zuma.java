package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Factories.Factory;

public class Zuma<E extends Factory> extends MyGame<E>
{
	SpriteBatch batch;

	@Override
	public void create ()
	{
		batch = new SpriteBatch();
	}

	@Override
	public void render ()
	{
		Gdx.gl.glClearColor(0, 0, 1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
	}
}
