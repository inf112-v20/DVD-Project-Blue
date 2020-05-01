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

public class OpponentCard {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));
    final private String EMPTY_CARD_PATH = "EmptyCard.png";
    final private String FACING_DOWN_CARD_PATH = "FacingDownCard.png";
    final private String TEXTURE_PATH = "assets/Cards/Opponent/";
    private String texturePathToCardFacingUp = TEXTURE_PATH;

    private ICard card;

    private Group cardGroup;
    private Image cardImage;

    public OpponentCard(ICard card) {
        this.card = card;
        createGroup(card);
    }

    public Group createCardGroup(ICard card, int index, int priority) {
//        this.card = card;
//        createGroup(card);

        String texturePath = "assets/Cards/Opponent/";

        if (index == 0) {
            texturePath += "Move1.png";
        } else if (index == 1) {
            texturePath += "Move2.png";
        }


        Texture cardTexture = new Texture(texturePath);
        cardTexture.setFilter(Linear, Linear);
        cardImage = new Image(cardTexture);
        cardImage.setOrigin(cardTexture.getWidth()/2,cardTexture.getHeight()/2);

        Label priorityCardLabel = new Label(String.format("%04d", priority), SKIN);
        priorityCardLabel.setFontScale(1/7.5f);
        priorityCardLabel.setPosition(27, 31);

        cardGroup = new Group();
        cardGroup.addActor(cardImage);
        cardGroup.addActor(priorityCardLabel);

        // listener for making the card bigger when the card is in a card slot
        cardGroup.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                cardGroup.setOriginX(cardImage.getWidth()/2);
                cardGroup.setScale(2.2f);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                cardGroup.setScale(1f);
            }
        });


        return cardGroup;
    }

    public void createGroup(ICard newCard) {
        card = newCard;
        String texturePathToCardFacingDown = TEXTURE_PATH;
        if (card != null) {
            texturePathToCardFacingUp += card.getFileName();
            texturePathToCardFacingDown += FACING_DOWN_CARD_PATH;
        } else {
            texturePathToCardFacingDown += EMPTY_CARD_PATH;
        }

        Texture cardTexture = new Texture(texturePathToCardFacingDown);
        cardTexture.setFilter(Linear, Linear);
        cardImage = new Image(cardTexture);
        cardImage.setOrigin(cardTexture.getWidth()/2,cardTexture.getHeight()/2);
        cardGroup = new Group();
        cardGroup.addActor(cardImage);

//        if (card != null) {
//            Label priorityCardLabel = new Label(String.format("%04d", card.priority()), SKIN);
//            priorityCardLabel.setFontScale(1/7.5f);
//            priorityCardLabel.setPosition(27, 31);
//        }

    }

    public Group getCardGroup() {
        return cardGroup;
    }
    

}
