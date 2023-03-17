package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class Tower extends Thing {
    int tick;
    int targettick;
    int targetradius;
    Thing target;

    boolean canFire() {
        if (target != null) {
            if (target.health > 0.1) {
                if (target.position.x < 640) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean canTarget() {
        if(target == null || target.health < 5 || target.position.x < 640) {
            Circle towerCircle = new Circle(this.sprite.getX(), this.sprite.getY(), targetradius);
            if(target != null) {
                if (towerCircle.contains(new Vector2(target.sprite.getX(), target.sprite.getY()))) {
                    return true;
                }
            }
        }
        return false;
    }

    void handleNewTarget(LinkedList<Thing> list) {
        if (targettick < 25) { // set the re-target time when the target is no longer valid
            targettick += 1;
            if (canTarget()) {
                target = findNewTarget(list);
            }
        } else {
            target = findNewTarget(list);
            targettick = 0;
        }
    }

    void targetToEnemy() {
        if (target != null) {
            double angleRadians = Math.atan2(target.position.y - position.y, target.position.x - position.x);
            float angleDegree = (float) angleRadians * MathUtils.radiansToDegrees - 90;
            sprite.setRotation(angleDegree);
        }
    }

    Thing findNewTarget(LinkedList<Thing> list) {
        for (Thing e : list) {
            if (e.thingtype == 1 && e.thingdata != 1) {
                return e;
            }
        }

        return null;
    }

    Tower(Vector2 pos, Texture t, int r) {
        position = pos;
        target = null;

        tex = t;
        this.targetradius = r;
        sprite = new Sprite(tex);
        sprite.setPosition(pos.x, pos.y);
    }

    public void think(LinkedList<Thing> list, TDGame game) {
        return;
    }
}
