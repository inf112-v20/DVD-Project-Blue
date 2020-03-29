package inf112.RoboRally.app.views.card;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.RoboRally.app.models.cards.ForwardCard;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.cards.ReverseCard;
import inf112.RoboRally.app.models.cards.RotateCard;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

/*
Card view that represents received cards (cards to put in slots) on the game screen.
 */
public class DragCard implements ICardDragAndDrop {

    private final String EMPTY_CARD_PATH = "EmptyCard.png";
    private final Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    private ICard card;           // model card

    public Group cardGroup;       // actor for use in libgdx tables
    public Image cardImage;

    public DragCard(ICard card) {
        this.card = card;
        createCardGroup(card);
    }

    @Override
    public Group createCardGroup(ICard newCard) {
        this.card = newCard;
        String texturePath = "Cards/";

        if      (card instanceof ForwardCard) texturePath += card.getFileName();
        else if (card instanceof ReverseCard) texturePath += card.getFileName();
        else if (card instanceof RotateCard)  texturePath += card.getFileName();
        else                                  texturePath += EMPTY_CARD_PATH;


        Texture cardTexture = new Texture(texturePath);
        cardTexture.setFilter(Linear, Linear);
        cardImage = new Image(cardTexture);
        cardImage.setOrigin(cardTexture.getWidth()/2,cardTexture.getHeight()/2);
        cardGroup = new Group();
        cardGroup.addActor(cardImage);

        if (card != null) {
            Label priorityCardLabel = new Label(String.format("%04d", card.priority()), SKIN);
            priorityCardLabel.setFontScale(1/2.5f);
            priorityCardLabel.setPosition(98, 189);
            cardGroup.addActor(priorityCardLabel);
        }
        return cardGroup;
    }

    @Override
    public Group getCardGroup() {
        return cardGroup;
    }

    @Override
    public ICard getModelCard() {
        return card;
    }
}
