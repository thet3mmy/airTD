package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class MachinegunTower extends Tower {

    MachinegunTower(Vector2 pos) {
        super(pos, new Texture("aagun.png"), 128);
    }

    @Override
    public void think(LinkedList<Thing> list, TDGame game) {
        sprite.setPosition(position.x, position.y);

        handleNewTarget(list);
        targetToEnemy();
        Vector2 centerOfTower = new Vector2(position.x + 32, position.y + 32);

        if (canFire()) {
            Vector2 targetPos = new Vector2(target.position.x + 40, target.position.y + 40);
            tick += 1;
            if (tick == 6) {
                list.add(new Bullet(2, 16, centerOfTower, targetPos, list, new Texture("bullet.png"), target));
            }
            if (tick == 12) {
                list.add(new Bullet(2, 16, centerOfTower, targetPos, list, new Texture("bullet.png"), target));
                tick = 0;
            }
        }
    }
}