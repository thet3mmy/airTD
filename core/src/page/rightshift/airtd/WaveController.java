package page.rightshift.airtd;

public class WaveController {
    static int spawnedCount;

    private static void trySpawn(int time, int type) {
        if(TDGame.ticks % time == 0) {TDGame.toDraw.add(new PlaneEnemy(type)); spawnedCount += 1;}
    }

    public static void spawnPlanes() {
        TDGame.ticks += 1;

        if(spawnedCount > 40) {
            spawnedCount = 0;
            TDGame.wavenumber += 1;
            if(!TDGame.autostart) {
                TDGame.spawnEnabled = false;
            } else {
                TDGame.spawnEnabled = true;
            }
        }

        switch(TDGame.wavenumber) { // this will allow us to program each individual wave.
            case 1: case 2:
                trySpawn(45, 1);
                break;
            case 3: case 4:
                trySpawn(35, 1);
                break;
            case 5: case 6:
                trySpawn(35, 1);
                trySpawn(135, 2);
                break;
            case 7: case 8:
                trySpawn(30, 1);
                trySpawn(60, 2);
                break;
            case 9: case 10:
                trySpawn(22, 1);
                trySpawn(60, 2);
                break;
            case 11: case 12:
                trySpawn(22, 1);
                trySpawn(55, 2);
                break;
            case 13: case 14:
                trySpawn(30, 2);
                trySpawn(45, 2);
                break;
            case 15: case 16:
                trySpawn(30, 2);
                trySpawn(35, 2);
                break;
            case 17: case 18:
                trySpawn(20, 2);
                trySpawn(60, 3);
                break;
            case 19: case 20:
                trySpawn(30, 2);
                trySpawn(60, 3);
                trySpawn(120, 4);
                break;
        }
    }
}
