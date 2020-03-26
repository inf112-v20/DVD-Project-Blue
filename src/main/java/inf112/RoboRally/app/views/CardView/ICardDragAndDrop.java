package inf112.RoboRally.app.views.CardView;

import com.badlogic.gdx.scenes.scene2d.Group;
import inf112.RoboRally.app.models.cards.ICard;

public interface ICardDragAndDrop {

    Group createCardGroup(ICard card);

    ICard getModelCard();

    Group getCardGroup();

}

