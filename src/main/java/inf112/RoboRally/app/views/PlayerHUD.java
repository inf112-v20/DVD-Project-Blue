package inf112.RoboRally.app.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;

/*
Card buttons made for manual testing of connection between view and model in showBoard
 */
public class PlayerHUD {

    private Image powerDownImg;
    private Image damageTokenImg;
    private Image damageTokenImg2;
    private Image damageTokenImg3;
    private Image damageTokenImg4;
    private Image damageTokenImg5;
    private Image damageTokenImg6;
    private Image damageTokenImg7;
    private Image damageTokenImg8;
    private Image damageTokenImg9;
    private Image lifeTokenImg;
    private Image lifeTokenImg2;
    private Image lifeTokenImg3;

    private static final float imgScaleX = 1/3f;
    private static final float imgScaleY = 1/6f;

    public Table create () {
        Table playerTable = new Table();
        playerTable.bottom().padLeft(150);
        playerTable.setFillParent(true);

        powerDownImg = new Image(new Texture("PlayerHud/PowerDown.png"));
        powerDownImg.setScale(imgScaleX, imgScaleY);

        damageTokenImg = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg.setScale(imgScaleX, imgScaleY);
        damageTokenImg2 = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg2.setScale(imgScaleX, imgScaleY);
        damageTokenImg3 = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg3.setScale(imgScaleX, imgScaleY);
        damageTokenImg4 = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg4.setScale(imgScaleX, imgScaleY);
        damageTokenImg5 = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg5.setScale(imgScaleX, imgScaleY);
        damageTokenImg6 = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg6.setScale(imgScaleX, imgScaleY);
        damageTokenImg7 = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg7.setScale(imgScaleX, imgScaleY);
        damageTokenImg8 = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg8.setScale(imgScaleX, imgScaleY);
        damageTokenImg9 = new Image(new Texture("PlayerHud/DamageTokenNoDmg.png"));
        damageTokenImg9.setScale(imgScaleX, imgScaleY);

        lifeTokenImg = new Image(new Texture("PlayerHud/LifeToken.png"));
        lifeTokenImg.setScale(imgScaleX, imgScaleY);
        lifeTokenImg2 = new Image(new Texture("PlayerHud/LifeToken.png"));
        lifeTokenImg2.setScale(imgScaleX, imgScaleY);
        lifeTokenImg3 = new Image(new Texture("PlayerHud/LifeToken.png"));
        lifeTokenImg3.setScale(imgScaleX, imgScaleY);

        playerTable.add(powerDownImg);
        playerTable.add(damageTokenImg);
        playerTable.add(damageTokenImg2);
        playerTable.add(damageTokenImg3);
        playerTable.add(damageTokenImg4);
        playerTable.add(damageTokenImg5);
        playerTable.add(damageTokenImg6);
        playerTable.add(damageTokenImg7);
        playerTable.add(damageTokenImg8);
        playerTable.add(damageTokenImg9);
        playerTable.add(lifeTokenImg);
        playerTable.add(lifeTokenImg2);
        playerTable.add(lifeTokenImg3);

        return playerTable;

    }

}
