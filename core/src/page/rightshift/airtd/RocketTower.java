package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class RocketTower extends Tower {
    RocketTower(Vector2 pos) {
        super(pos, new Texture("rocketgun.png"), 400);
    }

    public void think(LinkedList<Thing> list, TDGame game) {
        sprite.setPosition(position.x, position.y);

        handleNewTarget(list);
        targetToEnemy();
        Vector2 centerOfTower = new Vector2(position.x + 32, position.y + 32);

        if(canFire()) {
            Vector2 targetPos = new Vector2(target.position.x + 40, target.position.y + 40);
            tick += 1;
            if (tick > 60) {
                list.add(new Bullet(3, 8, centerOfTower, targetPos, list, new Texture("rocket.png"), target));
                tick = 0;
            }
        }
    }
}

