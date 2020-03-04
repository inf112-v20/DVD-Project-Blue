package inf112.RoboRally.app.views.PlayerHUDClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PowerDown {

    private Table powerDown;
    private Texture powerDownTexture;
    private Image powerDownImg;

    public Table init () {
        powerDown = new Table();
        powerDown.bottom().padLeft(150);
        powerDown.setFillParent(true);

        powerDownTexture = new Texture("PlayerHud/PowerDown.png");
        powerDownTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        powerDownImg = new Image(powerDownTexture);

        powerDown.add(powerDownImg).padRight(875).padBottom(33);

        return powerDown;
    }
}
