package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import inf112.RoboRally.app.controllers.CardControllers.GameCardController;

public class PlayerHUD {

    private Table background;

    private int life;
    private Table lifeTokensTable;
    LifeTokens lifeTokens; // new version

    private int damage;
    private Table damageTokens;

    private boolean powerDownActive;
    private Table powerDown;

    public PlayerHUD(int life, int damage, boolean powerDownActive, GameCardController gameCardController) {
        this.life = life;
        this.damage = damage;
        this.powerDownActive = powerDownActive;
        background = new Table();
        lifeTokensTable = new Table();
        damageTokens = new Table();
        powerDown = new Table();

        // new lifetokens
        lifeTokens = new LifeTokens(gameCardController.humanPlayer().robot().livesLeft());
    }

    public Table create () {
        background.setFillParent(true);

        Texture img = new Texture("PlayerHud/PlayerHUD.png");
        img.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        background.setBackground(new TextureRegionDrawable(img));

        return background;
    }

    protected Table getLifeTokensTable() {
        return lifeTokens.lifeTokensTable();
    }

    public Table damageTokens () {
        damageTokens.bottom().padBottom(183).padLeft(128);
        damageTokens.setFillParent(true);

        Texture emptyDamageTokenTexture = new Texture("PlayerHud/emptyDamageToken.png");

        Texture damageTokenRedTexture = new Texture("PlayerHud/DamageTokenRed.png");
        damageTokenRedTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Texture slightDamageTokenLockCardTexture = new Texture("PlayerHud/DamageTokenSlightDmgLockCard.png");
        slightDamageTokenLockCardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Texture slightDamageTokenTexture = new Texture("PlayerHud/DamageTokenSlightDmg.png");
        slightDamageTokenTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(12);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(12);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(12);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(12);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padRight(6);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(6);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(12);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(12);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(12);
        damageTokens.add(new Image(emptyDamageTokenTexture)).padLeft(12);

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

    public Table powerDown () {
        powerDown.bottom().padLeft(150);
        powerDown.setFillParent(true);

        if (powerDownActive == true) {
            Texture powerDownTexture = new Texture("PlayerHud/PowerDown.png");
            powerDownTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            powerDown.add(new Image(powerDownTexture)).padRight(875).padBottom(33);
        }

        return powerDown;
    }




}
