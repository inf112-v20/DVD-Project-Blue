package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LifeTokens {

    private final String EMPTY_LIFE_TOKEN_IMG_PATH = "PlayerHud/emptyLifeToken.png";
    private final String LIFE_TOKEN_IMG_PATH = "PlayerHud/LifeToken.png";
    private final int LEFT_PADDING = 719;

    private Table lifeTokensTable;
    private int lifeLeft;

    protected LifeTokens(int lifeLeft) {
        this.lifeLeft = lifeLeft;
        lifeTokensTable = new Table();
    }

    protected Table lifeTokensTable() {
        lifeTokensTable.bottom().padLeft(LEFT_PADDING);
        lifeTokensTable.setFillParent(true);
        for (int i = 0; i < lifeLeft; i++) {
            lifeTokensTable.add(new Image(new Texture(LIFE_TOKEN_IMG_PATH)));
            lifeTokensTable.row();
        }
        return lifeTokensTable;
    }


}
