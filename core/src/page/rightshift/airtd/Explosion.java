package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class Explosion extends Thing {
    int timer;

    Explosion(Vector2 pos) {
        super();
        tex = new Texture("boom.png");
        sprite = new Sprite(tex);
        sprite.setPosition(pos.x, pos.y);
    }

    @Override
    public void think(LinkedList<Thing> list, TDGame game) {
        timer += 1;
        if (timer > 30) {
            tex.dispose();
            list.remove(this);
        }
    }
}
