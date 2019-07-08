package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.factories.Zuma_Factory;
import com.mygdx.game.interfaces.RemoveObjectFromCollection;
import com.mygdx.game.matcher.Matcher;
import com.mygdx.game.movement.LinearMovement;
import com.mygdx.game.movement.ProjectileMovement;
import com.mygdx.game.objects.general_objects.*;
import com.mygdx.game.interfaces.CollisionHandler;
import com.mygdx.game.objects.zuma_objects.Cannon;

import java.util.ArrayList;
import java.util.Random;

public class Zuma extends MyGame implements CollisionHandler, RemoveObjectFromCollection<LinearBox>
{
	//GAME DIMENSIONS
	public static final int width = 800;
	public static final int height = 450;

	//attributes
	private SpriteBatch batch;
	private Cannon cannon;
	private Tile tileDisplay,dis2;
	private float clockIni = 1f, clock,gclock,gclockIni= 2f;
	private Matcher gameMatcher;
	private int index =0;
	private boolean generateOverTime= false;
	private Background background;
	//collections
	private ArrayList<LinearBox> boxCollection;
	private ArrayList<Tile> gameTiles;
	private ArrayList<LinearBox>bullets;

	//Music and sound effects
	private Music gameTheme;
	private Sound popEffect;
	private Sound shotEffect;

	//METHODS

	private void generateBoxOverTime(float delta)
	{
		Random rand = new Random();

		if(gclock<=0)
		{
			LinearBox box = new LinearBox(new LinearMovement(),boxCollection.get(boxCollection.size()-1),null,-factory.getDm().tile_width,factory.getDm().boxPosY,factory.getDm().tile_width,factory.getDm().tile_height);
			Tile tile = gameTiles.get(rand.nextInt(gameTiles.size()));
			box.setBoxTile(tile);
			boxCollection.add(box);

			gclock = gclockIni;

		}else gclock-=delta;

	}

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

		if(Gdx.input.justTouched())
		{
			shotEffect.play(0.35f);
			LinearBox bullet = new LinearBox(new ProjectileMovement(), null, null,width/2 - factory.getDm().tile_width/2, factory.getDm().CannonTip.y, factory.getDm().cannon_width, factory.getDm().cannon_height);
			bullet.setBoxTile(tile);
			bullets.add(bullet);
		}
	}

	private Tile getBulletTile(int index)
	{

		return gameTiles.get(index);

	}

	private void changeTileOverTime(float delta)
	{
		if (index > gameTiles.size()-1) index = 0;

		if(clock <= 0) //changes the tile to shoot and display over time
		{
			tileDisplay = getBulletTile(index);
			clock = clockIni;
			index ++;

		}else clock -= delta;

	}

	private void resetNeighbors(ArrayList<LinearBox> inGameBoxes)
	{

		for (int i = 0; i<inGameBoxes.size();i++)
		{

			try
			{

				if(i == 0)inGameBoxes.get(i).setNeighbors(null,inGameBoxes.get(i+1));
				else if(i == inGameBoxes.size()-1)inGameBoxes.get(i).setNeighbors(inGameBoxes.get(i-1),null);
				else inGameBoxes.get(i).setNeighbors(inGameBoxes.get(i-1),inGameBoxes.get(i+1));

			}catch(Exception e)
			{

				if(i == inGameBoxes.size()-1)inGameBoxes.get(i).setNeighbors(inGameBoxes.get(i-1),null);
				else inGameBoxes.get(i).setNeighbors(inGameBoxes.get(i-1),inGameBoxes.get(i+1));

			}

		}

	}

	//OVERRIDDEN METHODS
	@Override
	public void create()
	{
		//game constants
		batch = new SpriteBatch();
		factory = new Zuma_Factory();
		bullets = new ArrayList<LinearBox>();

		//game matcher observer
		gameMatcher = factory.createLinearMatcher(null);

		//generate game tiles
		boxCollection =factory.generateGameBoxes();
		gameTiles = factory.generateGameTiles();

		//connect collections box and tile
		connectBoxAndTile(boxCollection,gameTiles);

		//create additional game objects
		cannon = factory.createCannon(width / 2 - factory.getDm().cannon_width / 2, 0);

		//initialize audio
		popEffect = Gdx.audio.newSound(Gdx.files.internal("pop.wav"));
		shotEffect = Gdx.audio.newSound(Gdx.files.internal("yoshitongue.mp3"));
		gameTheme = Gdx.audio.newMusic(Gdx.files.internal("Uwa so temperate_undertale.mp3"));
		gameTheme.setLooping(true);
		gameTheme.setVolume(0.4f);
		gameTheme.play();

		//initialize background 
		background = new Background(new Texture("wall.png"));

	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//draw background
		float delta = Gdx.graphics.getDeltaTime();//get delta Time
		background.draw(batch); //draw background
		handleCollision(); //handle collision between bullets and boxes
		//activate box generation overTime
		if(boxCollection.get(boxCollection.size()-1).position.x > 0)generateOverTime = true;
		if(generateOverTime){generateBoxOverTime(delta);resetNeighbors(boxCollection);}

		//draw
		cannon.draw(batch);//cannon
		changeTileOverTime(delta);//bullet tile display
		dis2 = tileDisplay;//display tile to shoot
		dis2.position = new Vector2(width/2 - factory.getDm().tile_width/2,70);
		dis2.draw(batch);

		//Behaviors
		shoot(tileDisplay);

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
	public void dispose()
	{
		batch.dispose();
		cannon.dispose();
	}

	@Override
	public void handleCollision()
	{

		//check bullets collection and in game boxes collection for any collision
		for (LinearBox bullet:bullets)
		{

			for (LinearBox box:boxCollection)
			{

				if(bullet.collider.overlaps(box.collider))
				{

					bullet.movement = new LinearMovement(); //stop bullet

					//System.out.println("Call match"); //debug
					bullet.setNeighbors(box,(LinearBox) box.getNeighboor(LinearNeighbors.Left));//set bullet neighbors
					gameMatcher.HasMatch(bullet,bullet.getNeighboor(LinearNeighbors.Right),boxCollection);//call match between bullet and its left neighbor
					bullet.setNeighbors(box,(LinearBox) box.getNeighboor(LinearNeighbors.Right));//reset bullet neighbors
					gameMatcher.HasMatch(bullet,bullet.getNeighboor(LinearNeighbors.Left),boxCollection); //call match between bullet and right neighbor

				}

			}
			gameMatcher.clearMatchedBoxArray();
			removeFromCollection(boxCollection);//remove matched boxes in the boxes collection

		}
		removeFromCollection(bullets); //remove matched bullets in the bullets collection

	}

	@Override
	public void removeFromCollection(ArrayList<LinearBox> collection)
	{

		ArrayList<Box> remove = new ArrayList<Box>();
		for (Box box:collection)
		{
			if (box.getMatchedStatus()) remove.add(box);
		}
		collection.removeAll(remove);

	}

}
