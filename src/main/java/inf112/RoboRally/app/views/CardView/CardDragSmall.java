package inf112.RoboRally.app.views.CardView;

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

public class CardDragSmall implements ICardDragAndDrop {

    private ICard card;

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    private Group cardGroup;
    private Image cardImage;

    public CardDragSmall(ICard card) {
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
        cardImage.setOrigin(cardTexture.getWidth()/2,cardTexture.getHeight()/2);

        cardGroup = new Group();
        cardGroup.addActor(cardImage);
        if (card != null) {
            Label priorityCardLabel = new Label(String.format("%04d", card.priority()), skin);
            priorityCardLabel.setFontScale(1/5f);
            priorityCardLabel.setPosition(52, 83);
            cardGroup.addActor(priorityCardLabel);
        }


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
    public ICard getCard() {
        return card;
    }

    @Override
    public Group getCardGroup() {
        return cardGroup;
    }
}

