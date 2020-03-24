package inf112.RoboRally.app.views.CardView;

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

public class CardDragBig implements ICardDragAndDrop {

    private ICard card;

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

//    private int index;
//    private int priority;
    public Group cardGroup;
    public Image cardImage;

    public CardDragBig(ICard card) {
        this.card = card;
        createCardGroup(card);
    }

    @Override
    public Group createCardGroup(ICard card) {
        String texturePath = "Cards/";

        if      (card instanceof ForwardCard) texturePath += card.getFileName();
        else if (card instanceof ReverseCard) texturePath += card.getFileName();
        else if (card instanceof RotateCard)  texturePath += card.getFileName();


        Texture cardTexture = new Texture(texturePath);
        cardTexture.setFilter(Linear, Linear);
        cardImage = new Image(cardTexture);
        cardImage.setOrigin(cardTexture.getWidth()/2,cardTexture.getHeight()/2);

        Label priorityCardLabel = new Label(String.format("%04d", card.priority()), skin);
        priorityCardLabel.setFontScale(1/2.5f);
        priorityCardLabel.setPosition(98, 189);

        cardGroup = new Group();
        cardGroup.addActor(cardImage);

        if (card != null) {
            cardGroup.addActor(priorityCardLabel);
        }

        return cardGroup;
    }

    @Override
    public Group getCardGroup() {
        return cardGroup;
    }

    @Override
    public ICard getCard() {
        return card;
    }
}
