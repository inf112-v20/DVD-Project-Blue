package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LifeTokens {

    // positioning
    private final int LEFT_PADDING = 719;

    // image file path
    private final String LIFE_TOKEN_IMG_PATH = "PlayerHud/LifeToken.png";

    // image texture
    private final Texture LIFE_TOKEN_TEXTURE = new Texture(LIFE_TOKEN_IMG_PATH);

    private Table lifeTokensTable;
    private int lifeLeft;

    protected LifeTokens(int lifeLeft) {
        this.lifeLeft = lifeLeft;
        lifeTokensTable = new Table();
        LIFE_TOKEN_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    protected Table lifeTokensTable() {
        lifeTokensTable.bottom().padLeft(LEFT_PADDING);
        lifeTokensTable.setFillParent(true);
        for (int i = 0; i < lifeLeft; i++) {
            lifeTokensTable.add(new Image(LIFE_TOKEN_TEXTURE));
            lifeTokensTable.row();
        }
        return lifeTokensTable;
    }


}
