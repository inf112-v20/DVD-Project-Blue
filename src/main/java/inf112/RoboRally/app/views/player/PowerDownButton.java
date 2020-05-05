package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PowerDownButton {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    // image file path
    private final String POWER_DOWN_ON_IMG_PATH = "assets/PlayerHud/PowerDown.png";
    private final String POWER_DOWN_OFF_IMG_PATH = "assets/PlayerHUD/PowerDownNotActive.png";

    // image texture
    private final Texture POWER_DOWN_OFF_TEXTURE = new Texture(POWER_DOWN_OFF_IMG_PATH);
    private final Texture POWER_DOWN_ON_TEXTURE = new Texture(POWER_DOWN_ON_IMG_PATH);

    public ImageButton createImageButton() {
        POWER_DOWN_OFF_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        POWER_DOWN_ON_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        ImageButton powerDownButton = new ImageButton(SKIN);
        powerDownButton.setTransform(true);
        powerDownButton.setSize(154, 154);
        powerDownButton.getStyle().imageUp = new TextureRegionDrawable(POWER_DOWN_OFF_TEXTURE);
        powerDownButton.getStyle().imageDown = new TextureRegionDrawable(POWER_DOWN_ON_TEXTURE);
        powerDownButton.getStyle().imageChecked = new TextureRegionDrawable(POWER_DOWN_ON_TEXTURE);
        powerDownButton.getStyle().imageOver = new TextureRegionDrawable(POWER_DOWN_ON_TEXTURE);
        return powerDownButton;
    }
}
