package inf112.RoboRally.app.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.RoboRally.app.views.PlayerHUDClasses.PowerDown;

/*
Card buttons made for manual testing of connection between view and model in showBoard
 */
public class PlayerHUD {

    public Table playerHud;

    private Texture lifeTexture;
    private Image lifeTokenImg;
    private Image lifeTokenImg2;
    private Image lifeTokenImg3;


    public Table create () {
        playerHud = new Table();
        playerHud.setFillParent(true);

        Texture img = new Texture("PlayerHud/PlayerHUD.png");
        img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        playerHud.setBackground(new TextureRegionDrawable(img));

        return playerHud;
    }
}
