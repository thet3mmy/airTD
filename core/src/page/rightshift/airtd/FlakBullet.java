package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class FlakBullet extends Projectile {
    LinkedList<Thing> dlist;

    FlakBullet(int tt, int speed, Vector2 startpos,
               Vector2 targetpos, LinkedList<Thing> list, LinkedList<Thing> dlist, Texture t, Thing tar) {
        super(tt, speed, startpos, targetpos, list, t, tar);
        this.dlist = dlist;
    }

    @Override
    public void think(LinkedList<Thing> list, TDGame game) {
        move();

        // think about when to detonate and do damage
        for (Thing e : list) {
            if (e.thingtype == 1) {
                Rectangle rect = new Rectangle();
                rect.setPosition(sprite.getX() - 32, sprite.getY() - 32);
                rect.setSize(64, 64);

                for (Thing f: list) {
                    if (f.sprite.getBoundingRectangle().overlaps(rect)) {
                        f.health -= 1;
                    }
                }
            }
        }

        ticks += 1;
        if (ticks > 75) {
            tex.dispose();
            list.remove(this);
        }
    }

    public void destroy() {
        tex.dispose();
        list.remove(this);
    }
}
