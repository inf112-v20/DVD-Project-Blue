package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PowerDown {

    // positioning
    private final int PAD_RIGHT = 1380;
    private final int PAD_BOTTOM = 10;

    // image file path
    private final String POWER_DOWN_IMG_PATH = "assets/PlayerHud/PowerDown.png";
    private final String POWER_ON_IMG_PATH = "assets/PlayerHUD/PowerDownNotActive.png";

    // image texture
    private final Texture POWER_DOWN_TEXTURE = new Texture(POWER_DOWN_IMG_PATH);
    private final Texture POWER_ON_TEXTURE = new Texture(POWER_ON_IMG_PATH);

    private Table powerDownTable;
    private boolean robotIsPoweredDown;

    protected PowerDown(boolean robotIsPoweredDown) {
        this.robotIsPoweredDown = robotIsPoweredDown;
        POWER_DOWN_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        POWER_ON_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        powerDownTable = new Table();
    }

    protected Table powerDownTable() {
        powerDownTable.bottom().padBottom(PAD_BOTTOM);
        powerDownTable.setFillParent(true);
        if (robotIsPoweredDown) {
            powerDownTable.add(new Image(POWER_DOWN_TEXTURE)).padRight(PAD_RIGHT);
        } else {
            powerDownTable.add(new Image(POWER_ON_TEXTURE)).padRight(PAD_RIGHT);
        }

        return powerDownTable;
    }


}
