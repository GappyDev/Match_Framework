package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.factories.Zuma_Factory;
import com.mygdx.game.movement.ProjectileMovement;
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
	private Tile tileDisplay,dis2;
	private float clockIni = 1f, clock;
	//collections
	private ArrayList<LinearBox> boxCollection;
	private ArrayList<Tile> gameTiles;
	private ArrayList<LinearBox>bullets;

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

	private void shoot(Tile tile)
	{

		int i = 0;
		if(Gdx.input.justTouched())
		{
			LinearBox bullet = new LinearBox(new ProjectileMovement(), null, null,width/2 - factory.getDm().tile_width/2, factory.getDm().CannonTip.y, factory.getDm().cannon_width, factory.getDm().cannon_height);
			bullet.setBoxTile(tile);
			bullets.add(bullet);
		}
	}

	private Tile getBulletTile()
	{

		Random rand  = new Random();
		return gameTiles.get(rand.nextInt(gameTiles.size()-1));

	}

	//OVERRIDDEN METHODS
	@Override
	public void create()
	{
		//game constants
		batch = new SpriteBatch();
		factory = new Zuma_Factory();
		bullets = new ArrayList<LinearBox>();

		//generate game tiles and boxes
		boxCollection =factory.generateGameBoxes();
		gameTiles = factory.generateGameTiles();

		//connect collections box and tile
		connectBoxAndTile(boxCollection,gameTiles);

		//create additional game objects
		cannon = factory.createCannon(width / 2 - factory.getDm().cannon_width / 2, 0);

	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float delta = Gdx.graphics.getDeltaTime();


		//draw

		//bullet tile display
		if(clock <= 0) //changes the tile to shoot and display over time
		{
			tileDisplay = getBulletTile();
			System.out.println("change");
			clock = clockIni;
		}else clock -= delta;

		//display tile to shoot
		dis2 = tileDisplay;
		dis2.position = new Vector2(width - factory.getDm().tile_width,0);
		dis2.draw(batch);

		shoot(tileDisplay);
		//cannon
		cannon.draw(batch);

		//in game boxes
		for (LinearBox box:boxCollection)
		{
			box.setTilePositionToBoxPos();
			box.movement.move(delta,box);
			box.draw(batch);
		}

		///bullets
		ArrayList<LinearBox> bulletsToRemove = new ArrayList<LinearBox>();
		for (LinearBox box : bullets)
		{
			box.setTilePositionToBoxPos();
			box.movement.move(delta,box);
			box.draw(batch);
			if(box.remove) bulletsToRemove.add(box);
		}
		bullets.removeAll(bulletsToRemove);


	}


	@Override
	public void dispose() {
		batch.dispose();
		cannon.dispose();
	}

}
