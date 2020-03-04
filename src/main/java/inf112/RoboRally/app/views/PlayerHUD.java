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
    private Image lifeTokenImg;
    private Image lifeTokenImg2;
    private Image lifeTokenImg3;


    public Table create () {
        playerHud = new Table();
        playerHud.bottom().padBottom(183).padLeft(128);
        playerHud.setFillParent(true);

        Texture img = new Texture("PlayerHud/PlayerHUD.png");
        img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        playerHud.setBackground(new TextureRegionDrawable(img));

        Texture damageTokenTexture = new Texture("PlayerHud/DamageTokenRed.png");
        damageTokenTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        damageTokenImg = new Image(damageTokenTexture);

        Texture damageTokenTexture2 = new Texture("PlayerHud/DamageTokenSlightDmgLockCard.png");
        damageTokenTexture2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        damageTokenImg2 = new Image(damageTokenTexture2);
        damageTokenImg3 = new Image(damageTokenTexture2);
        damageTokenImg4 = new Image(damageTokenTexture2);
        damageTokenImg5 = new Image(damageTokenTexture2);
        damageTokenImg6 = new Image(damageTokenTexture2);

        Texture damageTokenTexture3 = new Texture("PlayerHud/DamageTokenSlightDmg.png");
        damageTokenTexture3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        damageTokenImg7 = new Image(damageTokenTexture3);
        damageTokenImg8 = new Image(damageTokenTexture3);
        damageTokenImg9 = new Image(damageTokenTexture3);
        damageTokenImg10 = new Image(damageTokenTexture3);
//
//        lifeTokenImg = new Image(new Texture("PlayerHud/LifeToken.png"));
//        lifeTokenImg2 = new Image(new Texture("PlayerHud/LifeToken.png"));
//        lifeTokenImg3 = new Image(new Texture("PlayerHud/LifeToken.png"));

        //playerHud.add(powerDownImg).padRight(875).padBottom(33);
        //playerHud.add(powerDownImg).padRight(875).padBottom(33);
        //playerHud.add(damageTokenImg).padRight(915).padBottom(186);
        playerHud.add(damageTokenImg).padRight(12);
        playerHud.add(damageTokenImg2).padRight(12);
        playerHud.add(damageTokenImg3).padRight(12);
        playerHud.add(damageTokenImg4).padRight(12);
        playerHud.add(damageTokenImg5).padRight(6);
        playerHud.add(damageTokenImg6).padLeft(6);
        playerHud.add(damageTokenImg7).padLeft(12);
        playerHud.add(damageTokenImg8).padLeft(12);
        playerHud.add(damageTokenImg9).padLeft(12);
        playerHud.add(damageTokenImg10).padLeft(12);
//        playerTable.add(lifeTokenImg);
//        playerTable.add(lifeTokenImg2);
//        playerTable.add(lifeTokenImg3);

        return playerHud;
    }
}
