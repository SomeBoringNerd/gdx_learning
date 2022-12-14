package xyz.someboringnerd.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.OrthographicCamera;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher
{

	public static WalkingSimulator GameInstance;

	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setForegroundFPS(60);
		config.setIdleFPS(10);

		config.setWindowSizeLimits(1280, 720, 1280, 720);
		config.setTitle("ChillWalkingAroundGame");

		GameInstance = new WalkingSimulator();

		new Lwjgl3Application(GameInstance, config);
	}
}
