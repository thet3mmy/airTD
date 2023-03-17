package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class FlakTower extends Tower {

    FlakTower(Vector2 pos, LinkedList<Thing> dlist) { super(pos, new Texture("flakgun.png"), 96); this.dlist = dlist; }
    LinkedList<Thing> dlist;

    @Override
    public void think(LinkedList<Thing> list, TDGame game) {
        sprite.setPosition(position.x, position.y);

        handleNewTarget(list);
        targetToEnemy();
        Vector2 centerOfTower = new Vector2(position.x + 32, position.y + 32);

        if(canFire()) {
            Vector2 targetPos = new Vector2(target.position.x + 40, target.position.y + 40);
            tick += 1;
            if(tick == 60) {
                list.add(new FlakBullet(2, 4, centerOfTower, targetPos, list, dlist, new Texture("flakbullet.png"), target));
                tick = 0;
            }
        }
    }
}
