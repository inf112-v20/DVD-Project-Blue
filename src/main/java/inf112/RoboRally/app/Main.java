package inf112.RoboRally.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {

    private static LwjglApplicationConfiguration config;
    public static final int SCREEN_WIDTH = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
    public static final int SCREEN_HEIGHT = LwjglApplicationConfiguration.getDesktopDisplayMode().height;

    public static void main(String[] args) {
        config = new LwjglApplicationConfiguration();
        config.title = "Robo Rally";
        config.width = SCREEN_WIDTH;
        config.height = SCREEN_HEIGHT;
        config.fullscreen = true;
        config.resizable = false;
        config.backgroundFPS = 60;
        config.foregroundFPS = 60;
        new LwjglApplication(new gameScreen(), config);
    }
}
