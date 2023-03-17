package page.rightshift.airtd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.LinkedList;

public class TDGame extends ApplicationAdapter {
	static LinkedList<Thing> toDraw;
	static LinkedList<Thing> c_toDraw;
	static LinkedList<Thing> toDestroy;

	Thing map;
	static SpriteBatch batch;
	static BitmapFont font;

	static int health;
	static int money;
	static int selectedtower;
	static int ticks;
	static int wavenumber;

	static boolean autostart = true;
	static boolean spawnEnabled = false;

	static String[] towernames = {"Machinegun tower", "Rocket tower", "Flak tower", "Sniper tower"};
	static int[] towerprices = {130, 200, 320, 140};

	public static String getBoolToString(boolean b) {if(b){return "Yes";} else {return "No";}}

	@Override
	public void create () {
		toDraw = new LinkedList<>();
		c_toDraw = new LinkedList<>();
		toDestroy = new LinkedList<>();

		batch = new SpriteBatch();
		font = new BitmapFont();
		font.getData().setScale(1);

		map = new Thing(new Vector2(0, 0), new Texture("map.png"));
		health = 100;
		money = 150;
		ticks = 0;
		wavenumber = 1;

		// add the map object to the list
		toDraw.add(map);
		toDraw.add(new PathController(new Vector2(300, 210), 4));
		toDraw.add(new PathController(new Vector2(300, 70), 3));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		if (spawnEnabled) {WaveController.spawnPlanes();}
		c_toDraw = (LinkedList<Thing>) toDraw.clone();

		// begin rendering stuff
		batch.begin();

		// draw everything on the list
		for(Thing e : c_toDraw) {
			e.sprite.draw(batch);
		}

		batch.end();
		UIRender.renderText();
		// we are done drawing

		for(Thing e : c_toDraw) { e.think(toDraw, this); }
		for(Thing e : toDestroy) { e.destroy(); }

		InputController.handleControls();
	}



	@Override
	public void dispose() {
		batch.dispose();

		// dispose everything drawable on the list
		for(Thing e : toDraw) {
			e.tex.dispose();
		}
	}
}