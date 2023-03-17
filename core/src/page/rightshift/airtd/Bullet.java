package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class Bullet extends Projectile {
    Bullet(int tt, int speed, Vector2 startpos,
           Vector2 targetpos, LinkedList<Thing> list, Texture t, Thing tar) {
        super(tt, speed, startpos, targetpos, list, t, tar);
    }

    @Override
    public void think(LinkedList<Thing> list, TDGame game) {
        move();

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
