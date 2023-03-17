package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class PathController extends Thing {

    PathController(Vector2 pos, int d) {
        thingtype = 4;
        thingdata = d;

        tex = new Texture("dircont.png");
        sprite = new Sprite(tex);
        sprite.setPosition(pos.x, pos.y);
    }

    @Override
    public void think() {

    }
}
