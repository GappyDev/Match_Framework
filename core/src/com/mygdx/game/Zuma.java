package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.factories.Zuma_Factory;
import com.mygdx.game.movement.IdleMovement;
import com.mygdx.game.movement.LinearMovement;
import com.mygdx.game.objects.GameObject;

public class Zuma extends MyGame
{
	//GAME DIMENSIONS
	public static  final int width = 400;
	public static final int height = 800;

	//attributes
	private SpriteBatch batch;
	private GameObject cannon;

	//methods
	@Override
	public void create ()
	{

		batch = new SpriteBatch();
		factory = new Zuma_Factory();

		//cannon
		Texture cannon_texture = new Texture("badlogic.jpg");//temp texture
		cannon = factory.createCannon(cannon_texture,width/2 -cannon_texture.getWidth()/2 ,0, new IdleMovement());

	}

	@Override
	public void render ()
	{
		Gdx.gl.glClearColor(0, 0, 1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();

		cannon.draw(batch);
		cannon.movement.move(delta,cannon);

	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
		cannon.dispose();
	}
}
