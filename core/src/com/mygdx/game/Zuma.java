package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.factories.Zuma_Factory;
import com.mygdx.game.movement.IdleMovement;
import com.mygdx.game.objects.general_objects.LinearBox;
import com.mygdx.game.objects.general_objects.Tile;
import com.mygdx.game.objects.zuma_objects.Cannon;

import java.util.ArrayList;
import java.util.Random;

public class Zuma extends MyGame
{
	//GAME DIMENSIONS
	public static final int width = 400;
	public static final int height = 600;

	//attributes
	private SpriteBatch batch;
	private Cannon cannon;
	//collections
	private ArrayList<LinearBox> boxCollection;
	private ArrayList<Tile> gameTiles;

	//METHODS

	private void connectBoxAndTile(ArrayList<LinearBox> boxes, ArrayList<Tile> tiles)
	{

		Random rand = new Random();

		for (LinearBox b: boxes)
		{

			b.setBoxTile(tiles.get(rand.nextInt(tiles.size())));
			b.setTilePositionToBoxPos();

		}

	}

	//OVERRIDE METHODS
	@Override
	public void create() {

		batch = new SpriteBatch();
		factory = new Zuma_Factory();

		//generate game tiles and boxes
		boxCollection =factory.generateGameBoxes();
		gameTiles = factory.generateGameTiles();
		//connect collections box and tile
		connectBoxAndTile(boxCollection,gameTiles);

		cannon = factory.createCannon(width / 2 - factory.getDm().cannon_width / 2, 0, new IdleMovement());

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();

		//boxes
		for (LinearBox box:boxCollection)
		{
			box.setTilePositionToBoxPos();
			box.draw(batch);
			box.movement.move(delta,box);

		}

	}


	@Override
	public void dispose() {
		batch.dispose();
		cannon.dispose();
	}

}
