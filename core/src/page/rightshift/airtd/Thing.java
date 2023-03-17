package page.rightshift.airtd;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;

import java.util.LinkedList;

public class Thing {
    Vector2 position = new Vector2();
    Texture tex = null;
    Sprite sprite;
    int thingtype = 0;
    int thingdata = 0;
    float health;

    Thing(Vector2 pos, Texture t) {
        position = pos;
        tex = t;
        sprite = new Sprite(tex);
    }

    public Thing() {}

    public void destroy() { return; }

    public void think() {
        return;
    }

    public void think(LinkedList<Thing> list, TDGame game) {
        return;
    }
}
