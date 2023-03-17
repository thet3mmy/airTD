package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class Projectile extends Thing {
    Vector2 direction;
    LinkedList<Thing> list;
    int ticks;
    int speed;
    Thing target;
    Vector2 startpos;
    Vector2 targetpos;

    Projectile(int tt, int speed, Vector2 startpos, Vector2 targetpos, LinkedList<Thing> list, Texture t, Thing tar) {
        thingtype = tt;
        this.list = list;
        this.speed = speed;
        this.target = tar;
        tex = t;
        sprite = new Sprite(tex);
        sprite.setPosition(startpos.x, startpos.y);

        this.startpos = startpos;
        this.targetpos = targetpos;

        direction = targetpos.sub(startpos);
        direction.nor();
    }

    void move() {
        sprite.setPosition(sprite.getX() + (direction.x * speed), sprite.getY() + (direction.y * speed));

        targetpos.x = target.position.x + 32;
        targetpos.y = target.position.y + 32;

        direction = targetpos.sub(startpos);
        direction.nor();
    }

    public void think() {
        move();
    }
}
