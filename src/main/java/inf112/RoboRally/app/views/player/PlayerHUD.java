package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.models.robot.Robot;

public class PlayerHUD {

    // HUD base image path
    private String PLAYER_BASE_HUD_IMAGE_PATH = "PlayerHud/PlayerHUD.png";

    // HUD base image texture
    private Texture PLAYER_BASE_IMAGE_TEXTURE = new Texture(PLAYER_BASE_HUD_IMAGE_PATH);

    private Table playerHudTable; // the players' base HUD

    // Elements on playerHUD stemming from robot stats
    private LifeTokens lifeTokens;
    private DamageTokens damageTokens;
    private PowerDown powerDown;


    public PlayerHUD(GameCardController gameCardController) {
        PLAYER_BASE_IMAGE_TEXTURE.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        playerHudTable = new Table();
        Robot robot = gameCardController.humanPlayer().robot();
        lifeTokens = new LifeTokens(robot.livesLeft());
        powerDown = new PowerDown(robot.isPoweredDown());
        damageTokens = new DamageTokens(robot.getHP(), robot.getMAX_HP());
    }

    protected Table getPlayerHudDashBoardTable() {
        playerHudTable.setFillParent(true);
        playerHudTable.setBackground(new TextureRegionDrawable(PLAYER_BASE_IMAGE_TEXTURE));
        return playerHudTable;
    }

    protected Table getLifeTokensTable() {
        return lifeTokens.lifeTokensTable();
    }

    protected Table getDamageTokensTable() {
        return damageTokens.damageTokensTable();
    }

    protected Table getPowerDownTable() {
        return powerDown.powerDownTable();
    }



}
