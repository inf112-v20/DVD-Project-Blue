package inf112.RoboRally.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {

    private static LwjglApplicationConfiguration config;
    public static final int SCREEN_WIDTH = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
    public static final int SCREEN_HEIGHT = LwjglApplicationConfiguration.getDesktopDisplayMode().height;

    public static void main(String[] args) {
        System.setProperty("org.lwjgl.opengl.Display.enableHighDPI", "true");
        config = new LwjglApplicationConfiguration();
        config.title = "Robo Rally";
        config.width = SCREEN_WIDTH-267;
        config.height = SCREEN_HEIGHT-150;
        config.useHDPI = true;
        config.fullscreen = false;
        config.resizable = false;
        config.backgroundFPS = 60;
        config.foregroundFPS = 60;
        new LwjglApplication(new GameScreen(), config);
    }
}
