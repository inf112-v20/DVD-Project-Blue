package inf112.RoboRally.app.views.opponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.models.game.Player;

public class OpponentHUD {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    final private int ROW_PADDING = 12;

    private int opponent;
    private int life;
    private int damage;
    private boolean powerDownActive;

    private Group opponentDashboard;

    private Group nameBackground;

    private Table lifeTokens;

    private Table damageTokens;

    private Table powerDown;

    private Group card1;

    private Table opponentHudTable;

    public OpponentHUD(GameCardController gameCardController, int opponent, int life, int damage, boolean powerDownActive) {
        this.opponent = opponent;
        this.life = life;
        this.damage = damage;
        this.powerDownActive = powerDownActive;

        opponentDashboard = new Group();
        nameBackground = new Group();
        lifeTokens = new Table();
        damageTokens = new Table();
        powerDown = new Table();
        opponentHudTable = new Table();
        card1 = new OpponentCard().createCardGroup(0, 9999);
        card1.setPosition(18, 11);
    }

    public Group opponentHudGroup() {
        opponentDashboard.setSize(448, 188);
        opponentDashboard.addActor(nameBackground());
        opponentDashboard.addActor(lifeTokens());
        opponentDashboard.addActor(damageTokens());
        opponentDashboard.addActor(powerDown());
        opponentDashboard.addActor(card1);
        opponentHudTable.add(opponentDashboard);
        return opponentDashboard;
    }

    public void setupOpponentHudTable(GameCardController gameCardController) {
        for (Player player: gameCardController.players()) {
            if (!player.equals(gameCardController.humanPlayer())) {
                opponentHudTable.add(opponentHudGroup());
                opponentHudTable.row().padTop(ROW_PADDING);
            }
        }
    }

    public Table getOpponentHudTable() {
        return opponentHudTable;
    }


    public Group nameBackground() {
        nameBackground = new Group();
        Texture txt = new Texture("assets/OpponentHud/OpponentHUD.png");
        txt.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Label names = new Label("PLAYER " + opponent, SKIN);
        names.setFontScale(1/2.3f);
        names.setPosition(165, 128);

        nameBackground.addActor(new Image(txt));
        nameBackground.addActor(names);

        return nameBackground;
    }

    public Table lifeTokens() {
        lifeTokens.padLeft(364).padBottom(83);
        lifeTokens.setFillParent(true);

        Texture emptyLifeTokenTexture = new Texture("assets/OpponentHud/emptyLifeToken.png");
        Texture lifeTokenTexture = new Texture("assets/OpponentHud/LifeToken.png");
        lifeTokenTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        lifeTokens.add(new Image(emptyLifeTokenTexture));
        lifeTokens.row();
        lifeTokens.add(new Image(emptyLifeTokenTexture));
        lifeTokens.row();
        lifeTokens.add(new Image(emptyLifeTokenTexture));
        if (life > 2) {
            lifeTokens.getCells().get(0).clearActor().setActor(new Image(lifeTokenTexture));
        }
        if (life > 1) {
            lifeTokens.getCells().get(1).clearActor().setActor(new Image(lifeTokenTexture));
        }
        if (life > 0) {
            lifeTokens.getCells().get(2).clearActor().setActor(new Image(lifeTokenTexture));
        }

        return lifeTokens;
    }

    public Table damageTokens() {
        damageTokens.padBottom(76).padRight(70);
        damageTokens.setFillParent(true);

        Texture emptyDamageTokenTexture = new Texture("assets/OpponentHud/emptyDamageToken.png");

        Texture damageTokenRedTexture = new Texture("assets/OpponentHud/DamageTokenRed.png");
        damageTokenRedTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Texture slightDamageTokenLockCardTexture = new Texture("assets/OpponentHud/DamageTokenSlightDmgLockCard.png");
        slightDamageTokenLockCardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Texture slightDamageTokenTexture = new Texture("assets/OpponentHud/DamageTokenSlightDmg.png");
        slightDamageTokenTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(8);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(8);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(8);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(8);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(4);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(4);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(8);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(8);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(8);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(8);

        if (damage > 0) {
            damageTokens.getCells().get(9).clearActor().setActor(new Image(slightDamageTokenTexture));
        }
        if (damage > 1) {
            damageTokens.getCells().get(8).clearActor().setActor(new Image(slightDamageTokenTexture));
        }
        if (damage > 2) {
            damageTokens.getCells().get(7).clearActor().setActor(new Image(slightDamageTokenTexture));
        }
        if (damage > 3) {
            damageTokens.getCells().get(6).clearActor().setActor(new Image(slightDamageTokenTexture));
        }
        if (damage > 4) {
            damageTokens.getCells().get(5).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (damage > 5) {
            damageTokens.getCells().get(4).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (damage > 6) {
            damageTokens.getCells().get(3).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (damage > 7) {
            damageTokens.getCells().get(2).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (damage > 8) {
            damageTokens.getCells().get(1).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (damage > 9) {
            damageTokens.getCells().get(0).clearActor().setActor(new Image(damageTokenRedTexture));
        }

        return damageTokens;
    }

    public Table powerDown() {
        powerDown.padLeft(346).padTop(86);
        powerDown.setFillParent(true);

        if (powerDownActive == true) {
            Texture powerDownTexture = new Texture("assets/OpponentHud/PowerDown.png");
            powerDownTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            powerDown.add(new Image(powerDownTexture));
        }
        return powerDown;
    }

}
