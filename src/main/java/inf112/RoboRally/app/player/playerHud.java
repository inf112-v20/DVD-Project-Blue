package inf112.RoboRally.app.player;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class playerHud {

    public Stage stage;
    private Viewport viewport;

    //power down img
    private Image powerDownImg;

    //dmg token imgs
    private Image damageTokenImg;
    private Image damageTokenImg2;
    private Image damageTokenImg3;
    private Image damageTokenImg4;
    private Image damageTokenImg5;
    private Image damageTokenImg6;
    private Image damageTokenImg7;
    private Image damageTokenImg8;
    private Image damageTokenImg9;

    //life token imgs
    private Image lifeTokenImg;
    private Image lifeTokenImg2;
    private Image lifeTokenImg3;

    //img scale
    private static final float imgScaleX = 1/3f;
    private static final float imgScaleY = 1/7f;

    public playerHud (SpriteBatch sb) {
        viewport = new FitViewport(1366, 768, new OrthographicCamera());
        stage = new Stage();

        Table table = new Table();
        table.bottom().padLeft(50);
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

        table.add(powerDownImg).expandX();
        table.add(damageTokenImg).expandX();
        table.add(damageTokenImg2).expandX();
        table.add(damageTokenImg3).expandX();
        table.add(damageTokenImg4).expandX();
        table.add(damageTokenImg5).expandX();
        table.add(damageTokenImg6).expandX();
        table.add(damageTokenImg7).expandX();
        table.add(damageTokenImg8).expandX();
        table.add(damageTokenImg9).expandX();
        table.add(lifeTokenImg).expandX();
        table.add(lifeTokenImg2).expandX();
        table.add(lifeTokenImg3).expandX();

        stage.addActor(table);
    }
}
