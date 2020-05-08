package inf112.RoboRally.app.views.opponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import inf112.RoboRally.app.models.cards.ICard;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

public class OpponentHUDCard {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));
    final private String EMPTY_CARD_PATH = "EmptyCard.png";
    final private String FACING_DOWN_CARD_PATH = "FacingDownCard.png";
    final private String TEXTURE_PATH = "assets/Cards/SMALL/";
    private String texturePathToCardFacingUp = TEXTURE_PATH;

    private ICard modelCard;
    private Group cardGroup;
    private Image cardImage;

    public OpponentHUDCard(ICard card, boolean cardFacingUp) {
        this.modelCard = card;
        createGroup(card, cardFacingUp);
    }

    public void createGroup(ICard newCard, boolean cardFacingUp) {
        modelCard = newCard;
        String cardTexturePath = TEXTURE_PATH;
        if (modelCard != null) {
            texturePathToCardFacingUp += modelCard.getFileName();
            if (cardFacingUp) cardTexturePath = texturePathToCardFacingUp;
            else  cardTexturePath += FACING_DOWN_CARD_PATH;
        } else {
            cardTexturePath += EMPTY_CARD_PATH;
        }

        Texture cardTexture = new Texture(cardTexturePath);
        cardTexture.setFilter(Linear, Linear);
        cardImage = new Image(cardTexture);
        cardImage.setSize(54, 76);
        cardImage.setOrigin(cardTexture.getWidth()/2,cardTexture.getHeight()/2);
        cardGroup = new Group();
        cardGroup.addActor(cardImage);

        if (newCard != null && cardFacingUp) {
            Label priorityCardLabel = new Label(String.format("%04d", newCard.priority()), SKIN);
            priorityCardLabel.setFontScale(1/7.5f);
            priorityCardLabel.setPosition(27, 31);
            cardGroup.addActor(priorityCardLabel);
        }

        setupListener();
    }

    private void setupListener() {
        cardGroup.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                cardGroup.setOriginX(cardImage.getWidth()/2);
                cardGroup.setScale(3.2f);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                cardGroup.setScale(1f);
            }
        });
    }

    public Group getCardGroup() {
        return cardGroup;
    }

}
