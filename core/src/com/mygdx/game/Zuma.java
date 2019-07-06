package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.factories.Zuma_Factory;
import com.mygdx.game.movement.IdleMovement;
import com.mygdx.game.movement.LinearMovement;
import com.mygdx.game.movement.ProjectileMovement;
import com.mygdx.game.objects.general_objects.LinearBox;
import com.mygdx.game.objects.zuma_objects.Cannon;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Camera;


public class Zuma extends MyGame
{
	//GAME DIMENSIONS
	public static final int width = 400;
	public static final int height = 800;

	//OJECTS DIMENSIONS
	private final float cannon_width = 200;
	private final float cannon_height = 200;

	//attributes
	private SpriteBatch batch;
	private Cannon cannon;
	LinearBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, projectile;

	//methods
	@Override
	public void create() {

		batch = new SpriteBatch();
		factory = new Zuma_Factory();


		//cannon
		cannon = factory.createCannon(width / 2 - factory.getDm().cannon_width / 2, 0, new IdleMovement());

		//boxes temp tiles temp

		c1 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), 0, 450f);
		c2 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -80, 450f);
		c3 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -160, 450f);
		c4 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -240, 450f);
		c5 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -320, 450f);
		c6 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -400, 450f);
		c7 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -480, 450f);
		c8 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -560, 450f);
		c9 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -640, 450f);
		c10 = factory.createLinearBox(new LinearMovement(), null, null, factory.createTile(5), -720, 450f);
		projectile = factory.createLinearBox(new IdleMovement(), null, null, factory.createTile(5), width / 2 - factory.getDm().tile_width / 2, 110f);


		//set neighbors
		c1.setNeighbors(null, c2);
		c2.setNeighbors(c1, c3);
		c3.setNeighbors(c2, c4);
		c4.setNeighbors(c3, c5);
		c5.setNeighbors(c4, c6);
		c6.setNeighbors(c5, c7);
		c7.setNeighbors(c6, c8);
		c8.setNeighbors(c7, c9);
		c9.setNeighbors(c8, c10);
		c10.setNeighbors(c9, null);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();

		cannon.draw(batch);
		c1.draw(batch);
		c2.draw(batch);
		c3.draw(batch);
		c4.draw(batch);
		c5.draw(batch);
		c6.draw(batch);
		c7.draw(batch);
		c8.draw(batch);
		c9.draw(batch);
		c10.draw(batch);
		projectile.draw(batch);

		c1.movement.move(delta, c1);
		c2.movement.move(delta, c2);
		c3.movement.move(delta, c3);
		c4.movement.move(delta, c4);
		c5.movement.move(delta, c5);
		c6.movement.move(delta, c6);
		c7.movement.move(delta, c7);
		c8.movement.move(delta, c8);
		c9.movement.move(delta, c9);
		c10.movement.move(delta, c10);


		cannon.movement.move(delta, cannon);
		projectile.movement.move(delta, projectile);

		//set projectile movement
		if (Gdx.input.justTouched())
		{

			projectile.movement = new ProjectileMovement();

		}


	}

	@Override
	public void dispose() {
		batch.dispose();
		cannon.dispose();
	}

}
