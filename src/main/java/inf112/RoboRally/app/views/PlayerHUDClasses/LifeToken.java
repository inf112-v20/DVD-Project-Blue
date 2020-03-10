package inf112.RoboRally.app.views.PlayerHUDClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LifeToken {

    private Table lifeToken;
    private Texture lifeTexture;
    private Image lifeTokenImg;
    private Image lifeTokenImg2;
    private Image lifeTokenImg3;

    public Table init () {
        lifeToken = new Table();
        lifeToken.bottom().padLeft(719);
        lifeToken.setFillParent(true);

        lifeTexture = new Texture("PlayerHud/LifeToken.png");
        lifeTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        lifeTokenImg = new Image(lifeTexture);
        lifeTokenImg2 = new Image(lifeTexture);
        lifeTokenImg3 = new Image(lifeTexture);

        lifeToken.add(lifeTokenImg);
        lifeToken.row();
        lifeToken.add(lifeTokenImg2);
        lifeToken.row();
        lifeToken.add(lifeTokenImg3);

        return lifeToken;
    }

}
