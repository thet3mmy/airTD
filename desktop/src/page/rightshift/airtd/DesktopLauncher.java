package page.rightshift.airtd;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import page.rightshift.airtd.TDGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowSizeLimits(640,480,640,480);
		config.setForegroundFPS(60);
		config.setTitle("AirTD");
		new Lwjgl3Application(new TDGame(), config);
	}
}
