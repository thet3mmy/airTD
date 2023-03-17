package page.rightshift.airtd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class PlaneEnemy extends Thing {
    public int type;
    public Vector2 vel;

    PlaneEnemy(int type) {
        super(new Vector2(0, 0), new Texture("redplane.png"));

        thingtype = 1;
        this.type = type;
        vel = new Vector2(2, 0);

        switch(type) {
            case 1:
                tex = new Texture("redplane.png");
                health = 15;
                break;
            case 2:
                tex = new Texture("orangeplane.png");
                health = 25;
                break;
            case 3:
                tex = new Texture("yellowplane.png");
                health = 90;
                break;
            case 4:
                tex = new Texture("greenplane.png");
                health = 150;
                break;
            case 5:
                tex = new Texture("cyanplane.png");
                thingdata = 1;
                health = 25;
                break;
            default:
                tex = null;
                break;
        }

        // reset sprite
        sprite = new Sprite(tex);
        position = new Vector2(0, 210);
        sprite.setPosition(0, 210);
    }

    public void think(LinkedList<Thing> list, TDGame game) {
        sprite.setPosition(position.x, position.y);

        if (type == 2) {
            position.x += (vel.x * 3);
            position.y += (vel.y * 3);
        } else {
            position.x += vel.x;
            position.y += vel.y;
        }

        if (position.x > 640) {
            list.remove(this);
            tex.dispose();

            switch(type) {
                case 1:
                    game.health -= 5;
                    break;
                case 2:
                    game.health -= 15;
                    break;
                case 3:
                    game.health -= 25;
                    break;
                case 4:
                    game.health -= 55;
                    break;
                case 5:
                    game.health -= 35;
                    break;
            }
            list.add(new Explosion(position));
        }

        if (health < 1) {
            list.add(new Explosion(position));
            list.remove(this);
            game.money += 2;

            PlaneEnemy newPlane;
            switch(type) {
                case 2:
                    newPlane = new PlaneEnemy(1);
                    newPlane.sprite.setPosition(this.sprite.getX(), this.sprite.getY());
                    list.add(newPlane);
                    break;

                case 3:
                    newPlane = new PlaneEnemy(2);
                    newPlane.sprite.setPosition(this.sprite.getX(), this.sprite.getY());
                    list.add(newPlane);
                    break;
                case 4:
                    newPlane = new PlaneEnemy(3);
                    newPlane.sprite.setPosition(this.sprite.getX(), this.sprite.getY());
                    list.add(newPlane);
                    break;
            }

            tex.dispose();
        }

        for(Thing e : list) {
            if (this.sprite.getBoundingRectangle().overlaps(e.sprite.getBoundingRectangle())) {
                if(e.thingtype > 1) {
                    switch(e.thingtype) {
                        case 2:
                            if (type != 4 && thingdata != 1) {
                                health -= 2;
                            }
                            break;
                        case 3:
                            if (thingdata != 1) {
                                health -= 30;
                            }
                            break;
                        case 4:
                            switch (e.thingdata) {
                                case 1:
                                    vel = new Vector2(-2, 0);
                                    break;
                                case 2:
                                    vel = new Vector2(0, 2);
                                    break;
                                case 3:
                                    vel = new Vector2(2, 0);
                                    break;
                                case 4:
                                    vel = new Vector2(0, -2);
                                    break;
                            }
                    }

                    game.toDestroy.add(e);
                }
            }
        }
    }
}
