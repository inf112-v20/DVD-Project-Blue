package inf112.RoboRally.app.views;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
/*
Class that views a players' life tokens, damage tokens, and power down button.
 */
public class PlayerHud {

    public Stage stage;
    private Viewport viewport;
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

    public PlayerHud(SpriteBatch sb) {
        viewport = new ScreenViewport(new OrthographicCamera());
        stage = new Stage();

        Table table = new Table();
        table.bottom().padLeft(150);
        table.setFillParent(true);

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

        table.add(powerDownImg);
        table.add(damageTokenImg);
        table.add(damageTokenImg2);
        table.add(damageTokenImg3);
        table.add(damageTokenImg4);
        table.add(damageTokenImg5);
        table.add(damageTokenImg6);
        table.add(damageTokenImg7);
        table.add(damageTokenImg8);
        table.add(damageTokenImg9);
        table.add(lifeTokenImg);
        table.add(lifeTokenImg2);
        table.add(lifeTokenImg3);

        stage.addActor(table);
    }
}
