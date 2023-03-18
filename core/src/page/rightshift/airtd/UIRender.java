package page.rightshift.airtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

import static page.rightshift.airtd.TDGame.*;

public class UIRender {
    public static SpriteBatch textBatch;
    public static Thing startButton;

    public static void buildMap() {
        // add the map object to the list
        toDraw = new LinkedList<>();

        toDraw.add(new Thing(new Vector2(0, 0), new Texture("map.png")));
        toDraw.add(new PathController(new Vector2(300, 210), 4));
        toDraw.add(new PathController(new Vector2(300, 70), 3));
    }

    public static void exitMenu() {
        buildMap();
        gameState = 1;
    }

    public static void buildMenu() {
        startButton = new Thing();
        startButton.tex = new Texture("startbutton.png");
        startButton.sprite = new Sprite(startButton.tex);
        startButton.sprite.setPosition(65, 65);
        startButton.thingtype = -1;
        toDraw.add(startButton);
    }

    public static void renderText() {
        SpriteBatch textBatch = new SpriteBatch();
        BitmapFont font = new BitmapFont();
        textBatch.begin();

        font.draw(textBatch, "health: " + TDGame.health + "   " + "money: " + TDGame.money +
                        "    " + "placing tower: " + towernames[selectedtower] + " ($" + towerprices[selectedtower] + ")" +
                        "    objects: " + toDraw.size() + "   fps: " + Gdx.graphics.getFramesPerSecond()
                , 15, 35);

        font.draw(textBatch, "started: " + getBoolToString(spawnEnabled) +
                        "      wave: " + (wavenumber) +
                        "        autostart: " + getBoolToString(autostart)
                , 15, 460);


        textBatch.end();
    }
}
