package inf112.RoboRally.app.views.PlayerHUDClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class DamageToken {

    private Table damageToken;
    private Texture damageTokenTexture;
    private Texture damageTokenTexture2;
    private Texture damageTokenTexture3;
    private Image damageTokenImg;
    private Image damageTokenImg2;
    private Image damageTokenImg3;
    private Image damageTokenImg4;
    private Image damageTokenImg5;
    private Image damageTokenImg6;
    private Image damageTokenImg7;
    private Image damageTokenImg8;
    private Image damageTokenImg9;
    private Image damageTokenImg10;

    public Table init () {
        damageToken = new Table();
        damageToken.bottom().padBottom(183).padLeft(128);
        damageToken.setFillParent(true);

        damageTokenTexture = new Texture("PlayerHud/DamageTokenRed.png");
        damageTokenTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        damageTokenImg = new Image(damageTokenTexture);

        damageTokenTexture2 = new Texture("PlayerHud/DamageTokenSlightDmgLockCard.png");
        damageTokenTexture2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        damageTokenImg2 = new Image(damageTokenTexture2);
        damageTokenImg3 = new Image(damageTokenTexture2);
        damageTokenImg4 = new Image(damageTokenTexture2);
        damageTokenImg5 = new Image(damageTokenTexture2);
        damageTokenImg6 = new Image(damageTokenTexture2);

        damageTokenTexture3 = new Texture("PlayerHud/DamageTokenSlightDmg.png");
        damageTokenTexture3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        damageTokenImg7 = new Image(damageTokenTexture3);
        damageTokenImg8 = new Image(damageTokenTexture3);
        damageTokenImg9 = new Image(damageTokenTexture3);
        damageTokenImg10 = new Image(damageTokenTexture3);

        damageToken.add(damageTokenImg).padRight(12);
        damageToken.add(damageTokenImg2).padRight(12);
        damageToken.add(damageTokenImg3).padRight(12);
        damageToken.add(damageTokenImg4).padRight(12);
        damageToken.add(damageTokenImg5).padRight(6);
        damageToken.add(damageTokenImg6).padLeft(6);
        damageToken.add(damageTokenImg7).padLeft(12);
        damageToken.add(damageTokenImg8).padLeft(12);
        damageToken.add(damageTokenImg9).padLeft(12);
        damageToken.add(damageTokenImg10).padLeft(12);

        return damageToken;
    }
}
