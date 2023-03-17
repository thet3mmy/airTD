package page.rightshift.airtd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class InputController {
    public static void handleControls() {
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            Vector2 clickPos = new Vector2(Gdx.input.getX() - 32, (Gdx.graphics.getHeight() - Gdx.input.getY()) - 32);

            switch(TDGame.selectedtower) {
                case 0: // machine gunner
                    if (TDGame.money >= TDGame.towerprices[TDGame.selectedtower]) {
                        TDGame.toDraw.add(new MachinegunTower(clickPos));
                        TDGame.money -= TDGame.towerprices[TDGame.selectedtower];
                    }
                    break;
                case 1: // rocket launcher
                    if (TDGame.money >= TDGame.towerprices[TDGame.selectedtower]) {
                        TDGame.toDraw.add(new RocketTower(clickPos));
                        TDGame.money -= TDGame.towerprices[TDGame.selectedtower];
                    }
                    break;
                case 2: // flak cannon
                    if (TDGame.money >= TDGame.towerprices[TDGame.selectedtower]) {
                        TDGame.toDraw.add(new FlakTower(clickPos, TDGame.toDestroy));
                        TDGame.money -= TDGame.towerprices[TDGame.selectedtower];
                    }
                    break;
                case 3: // sniper tower
                    if (TDGame.money >= TDGame.towerprices[TDGame.selectedtower]) {
                        TDGame.toDraw.add(new SniperTower(clickPos));
                        TDGame.money -= TDGame.towerprices[TDGame.selectedtower];
                    }
                    break;
                default:
            }
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            TDGame.spawnEnabled = !TDGame.spawnEnabled;
        }

        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            TDGame.selectedtower += 1;
            if (TDGame.selectedtower > 3) {TDGame.selectedtower = 0;}
            if (TDGame.selectedtower < 0) {TDGame.selectedtower = 1;}
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.BACKSLASH)) {
            TDGame.autostart = !TDGame.autostart;
        }
    }
}
