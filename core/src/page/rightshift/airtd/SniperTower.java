package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class SniperTower extends Tower {
    SniperTower(Vector2 pos) {
        super(pos, new Texture("snipergun.png"), 999999);
    }

    public void think(LinkedList<Thing> list, TDGame game) {
        sprite.setPosition(position.x, position.y);

        handleNewTarget(list);
        targetToEnemy();

        if(canFire()) {
            tick += 1;
            if (tick > 60) {
                target.health = 0; // instakill the target every 60 frames (1 sec)
                tick = 0;
            }
        }
    }
}

