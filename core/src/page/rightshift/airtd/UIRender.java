package page.rightshift.airtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static page.rightshift.airtd.TDGame.*;

public class UIRender {
    public static void renderText() {
        SpriteBatch textBatch = new SpriteBatch();
        textBatch.begin();

        TDGame.font.draw(textBatch, "health: " + TDGame.health + "   " + "money: " + TDGame.money +
                        "    " + "placing tower: " + towernames[selectedtower] + " ($" + towerprices[selectedtower] + ")" +
                        "    objects: " + toDraw.size() + "   fps: " + Gdx.graphics.getFramesPerSecond()
                , 15, 35);

        TDGame.font.draw(textBatch, "started: " + getBoolToString(spawnEnabled) +
                        "      wave: " + (wavenumber) +
                        "        autostart: " + getBoolToString(autostart)
                , 15, 460);


        textBatch.end();
    }
}
