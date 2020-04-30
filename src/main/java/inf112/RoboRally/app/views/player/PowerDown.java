package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PowerDown {

    // positioning
    private final int BOTTOM_PAD_LEFT = 150;
    private final int PAD_RIGHT = 875;
    private final int PAD_BOTTOM = 33;

    // image file path
    private final String POWER_DOWN_IMG_PATH = "assets/PlayerHud/PowerDown.png";

    // image texture
    private final Texture POWER_DOWN_TEXTURE = new Texture(POWER_DOWN_IMG_PATH);

    private Table powerDownTable;
    private boolean robotIsPoweredDown;

    protected PowerDown(boolean robotIsPoweredDown) {
        this.robotIsPoweredDown = robotIsPoweredDown;
        POWER_DOWN_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        powerDownTable = new Table();
    }

    protected Table powerDownTable() {
        powerDownTable.bottom().padLeft(BOTTOM_PAD_LEFT);
        powerDownTable.setFillParent(true);
        robotIsPoweredDown = true;
        if (robotIsPoweredDown) {
            powerDownTable.add(new Image(POWER_DOWN_TEXTURE)).padRight(PAD_RIGHT).padBottom(PAD_BOTTOM);
        }

        return powerDownTable;
    }


}
