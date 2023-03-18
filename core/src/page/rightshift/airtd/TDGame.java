package page.rightshift.airtd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.LinkedList;

public class TDGame extends ApplicationAdapter {
	static LinkedList<Thing> toDraw;
	static LinkedList<Thing> c_toDraw;
	static LinkedList<Thing> toDestroy;

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
	static int gameState = 0;
	static Thing startButton;

	public static String getBoolToString(boolean b) {if(b){return "Yes";} else {return "No";}}

	@Override
	public void create () {
		toDraw = new LinkedList<>();
		c_toDraw = new LinkedList<>();
		toDestroy = new LinkedList<>();

		batch = new SpriteBatch();
		font = new BitmapFont();
		font.getData().setScale(1);

		health = 100;
		money = 150000;
		ticks = 0;
		wavenumber = 1;

		startButton = new Thing();
		startButton.tex = new Texture("startbutton.png");
		startButton.sprite = new Sprite(startButton.tex);
		startButton.sprite.setPosition(65, 65);
		startButton.thingtype = -1;
	}

	private void renderList() {
		// begin rendering stuff
		batch.begin();

		// draw everything on the list
		for (Thing e : c_toDraw) {
			e.sprite.draw(batch);
		}

		batch.end();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
		InputController.handleControls();
		renderList();

		if (gameState == 0) {
			batch.begin();
			startButton.sprite.draw(batch);
			batch.end();
		} else {
			if (spawnEnabled) {
				WaveController.spawnPlanes();
			}
			c_toDraw = (LinkedList<Thing>) toDraw.clone();

			UIRender.renderText();
			// we are done drawing

			for (Thing e : c_toDraw) {
				e.think(toDraw, this);
			}
			for (Thing e : toDestroy) {
				e.destroy();
			}
		}
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