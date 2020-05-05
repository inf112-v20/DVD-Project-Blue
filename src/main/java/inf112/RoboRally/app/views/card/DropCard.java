package inf112.RoboRally.app.views.card;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import inf112.RoboRally.app.models.cards.ForwardCard;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.cards.ReverseCard;
import inf112.RoboRally.app.models.cards.RotateCard;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

/*
Card view that represents cards that are dropped in a slot.
 */
public class DropCard implements ICardDragAndDrop {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    private ICard card;         // model card

    private Group cardGroup;    // actor for use in libgdx tables
    private Image cardImage;

    public DropCard(ICard card) {
        this.card = card;
        createCardGroup(card);
    }

    @Override
    public Group createCardGroup(ICard newCard) {
        this.card = newCard;

        String texturePath = "Cards/SMALL/";

        if      (card instanceof ForwardCard) texturePath += card.getFileName();
        else if (card instanceof ReverseCard) texturePath += card.getFileName();
        else if (card instanceof RotateCard)  texturePath += card.getFileName();
        else                                  texturePath += "EmptyCard.png";


        Texture cardTexture = new Texture(texturePath);
        cardTexture.setFilter(Linear, Linear);
        cardImage = new Image(cardTexture);
        cardImage.setSize(98, 137);
        cardImage.setOrigin(cardTexture.getWidth()/2,cardTexture.getHeight()/2);

        cardGroup = new Group();
        cardGroup.addActor(cardImage);
        if (card != null) {
            Label priorityCardLabel = new Label(String.format("%04d", card.priority()), SKIN);
            priorityCardLabel.setFontScale(1/5f);
            priorityCardLabel.setPosition(52, 83);
            cardGroup.addActor(priorityCardLabel);
        }


        // listener for making the card bigger when the card is in a card slot
        cardGroup.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                cardGroup.setOriginX(cardImage.getWidth()/2);
                cardGroup.setScale(2f);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                cardGroup.setScale(1f);
            }
        });

        return cardGroup;
    }

    @Override
    public ICard getModelCard() {
        return card;
    }

    @Override
    public Group getCardGroup() {
        return cardGroup;
    }
}

