package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.factories.Zuma_Factory;
import com.mygdx.game.movement.IdleMovement;
import com.mygdx.game.movement.LinearMovement;
import com.mygdx.game.objects.GameObject;
import com.mygdx.game.objects.general_objects.Box;
import com.mygdx.game.objects.general_objects.LinearBox;

import java.util.ArrayList;

public class Zuma extends MyGame
{
	//GAME DIMENSIONS
	public static  final int width = 400;
	public static final int height = 800;

	//attributes
	private SpriteBatch batch;
	private GameObject cannon;
	LinearBox c1,c2,c3;

	//methods
	@Override
	public void create ()
	{

		batch = new SpriteBatch();
		factory = new Zuma_Factory();

		//cannon
		Texture cannon_texture = new Texture("badlogic.jpg");//temp texture
		cannon = factory.createCannon(cannon_texture,width/2 -cannon_texture.getWidth()/2 ,0, new IdleMovement());

		//boxes temp attributes temp
		c3 = factory.createLinearBox(new LinearMovement(),null,null,cannon_texture,5,0,600.5f);
		c2 = factory.createLinearBox(new LinearMovement(),null,null,cannon_texture,5,-2,600.5f);
		c1 =factory.createLinearBox(new LinearMovement(),null,null,cannon_texture,5,-4,600.5f);

	}

	@Override
	public void render ()
	{
		Gdx.gl.glClearColor(0, 0, 1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();

		cannon.draw(batch);
		c1.draw(batch);
		c2.draw(batch);
		c3.draw(batch);
		c1.movement.move(delta,c1);
		c2.movement.move(delta,c2);
		c3.movement.move(delta,c3);


		cannon.movement.move(delta,cannon);

	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
		cannon.dispose();
	}
}
