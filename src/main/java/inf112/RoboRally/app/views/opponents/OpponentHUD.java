package inf112.RoboRally.app.views.opponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;

public class OpponentHUD {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    private final float Y_CARD_POS = 11;
    private float xCardPos = 18;
    private final float X_CARD_POS_INTERVAL = 70f;

    // game stats
    private int opponentNumber;
    private int life;
    private int hp;
    private boolean isPoweredDown;

    private Group opponentDashboard;

    private Group nameBackground;

    private Table lifeTokens;

    private Table damageTokens;

    private Table powerDown;

    private Group card1;
    private Group card2;
    private Group[] cardGroups;

    private Table opponentHudTable;

    public OpponentHUD(Player player) {
        opponentNumber = player.getPlayerNumber();
        life = player.robot().livesLeft();
        hp = player.robot().getHP();
        isPoweredDown = player.robot().isPoweredDown();
        opponentDashboard = new Group();
        nameBackground = new Group();
        lifeTokens = new Table();
        damageTokens = new Table();
        powerDown = new Table();
        opponentHudTable = new Table();

        cardGroups = new Group[player.numberOfCardSlots()];
        for (int i = 0; i < cardGroups.length; i++) {
            ICard modelCard = player.getCardSlots()[i];
            OpponentCard card = new OpponentCard(modelCard);
            cardGroups[i] = card.getCardGroup();
            cardGroups[i].setPosition(xCardPos + ( i * X_CARD_POS_INTERVAL ) , Y_CARD_POS );
        }

//        card1 = new OpponentCard().createCardGroup(0, 9999);
//        card1.setPosition(18, 11);
//        card2 = new OpponentCard().createCardGroup(0, 9999);
//        card2.setPosition(88, 11);
    }

    public Group opponentHudGroup() {
        opponentDashboard.setSize(448, 188);
        opponentDashboard.addActor(nameBackground());
        opponentDashboard.addActor(lifeTokens());
        opponentDashboard.addActor(damageTokens());
        opponentDashboard.addActor(powerDown());
//        opponentDashboard.addActor(card1);
//        opponentDashboard.addActor(card2);
        for (Group cardGroup: cardGroups) {
            opponentDashboard.addActor(cardGroup);
        }
        opponentHudTable.add(opponentDashboard);
        return opponentDashboard;
    }


    public Group nameBackground() {
        nameBackground = new Group();
        Texture txt = new Texture("assets/OpponentHud/OpponentHUD.png");
        txt.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Label names = new Label("PLAYER " + (opponentNumber+1), SKIN);
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

        if (hp > 0) {
            damageTokens.getCells().get(9).clearActor().setActor(new Image(slightDamageTokenTexture));
        }
        if (hp > 1) {
            damageTokens.getCells().get(8).clearActor().setActor(new Image(slightDamageTokenTexture));
        }
        if (hp > 2) {
            damageTokens.getCells().get(7).clearActor().setActor(new Image(slightDamageTokenTexture));
        }
        if (hp > 3) {
            damageTokens.getCells().get(6).clearActor().setActor(new Image(slightDamageTokenTexture));
        }
        if (hp > 4) {
            damageTokens.getCells().get(5).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (hp > 5) {
            damageTokens.getCells().get(4).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (hp > 6) {
            damageTokens.getCells().get(3).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (hp > 7) {
            damageTokens.getCells().get(2).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (hp > 8) {
            damageTokens.getCells().get(1).clearActor().setActor(new Image(slightDamageTokenLockCardTexture));
        }
        if (hp > 9) {
            damageTokens.getCells().get(0).clearActor().setActor(new Image(damageTokenRedTexture));
        }

        return damageTokens;
    }

    public Table powerDown() {
        powerDown.padLeft(346).padTop(86);
        powerDown.setFillParent(true);

        if (isPoweredDown) {
            Texture powerDownTexture = new Texture("assets/OpponentHud/PowerDown.png");
            powerDownTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            powerDown.add(new Image(powerDownTexture));
        }
        return powerDown;
    }

}
