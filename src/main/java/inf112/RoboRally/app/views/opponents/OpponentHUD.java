package inf112.RoboRally.app.views.opponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class OpponentHUD {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    private int opponent;
    private int life;
    private int damage;
    private boolean powerDownActive;

    private Group opponentDashboard;

    private Group nameBackground;

    private Table lifeTokens;

    private Table damageTokens;

    private Table powerDown;

    public OpponentHUD(int opponent, int life, int damage, boolean powerDownActive) {
        this.opponent = opponent;
        this.life = life;
        this.damage = damage;
        this.powerDownActive = powerDownActive;

        opponentDashboard = new Group();
        nameBackground = new Group();
        lifeTokens = new Table();
        damageTokens = new Table();
        powerDown = new Table();
    }

    public Group opponentDashboard() {
        opponentDashboard.setSize(448, 188);
        opponentDashboard.addActor(nameBackground());
        opponentDashboard.addActor(lifeTokens());
        opponentDashboard.addActor(damageTokens());
        opponentDashboard.addActor(powerDown());

        return opponentDashboard;
    }

    public Group nameBackground() {
        nameBackground = new Group();
        Texture txt = new Texture("OpponentHud/OpponentHUD.png");
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

        Texture emptyLifeTokenTexture = new Texture("OpponentHud/emptyLifeToken.png");
        Texture lifeTokenTexture = new Texture("OpponentHud/LifeToken.png");
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

        Texture emptyDamageTokenTexture = new Texture("OpponentHud/emptyDamageToken.png");

        Texture damageTokenRedTexture = new Texture("OpponentHud/DamageTokenRed.png");
        damageTokenRedTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Texture slightDamageTokenLockCardTexture = new Texture("OpponentHud/DamageTokenSlightDmgLockCard.png");
        slightDamageTokenLockCardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Texture slightDamageTokenTexture = new Texture("OpponentHud/DamageTokenSlightDmg.png");
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
            Texture powerDownTexture = new Texture("OpponentHud/PowerDown.png");
            powerDownTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            powerDown.add(new Image(powerDownTexture));
        }

        return powerDown;
    }

}
