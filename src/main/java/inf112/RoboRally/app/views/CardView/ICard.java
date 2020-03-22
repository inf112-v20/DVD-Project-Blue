package inf112.RoboRally.app.views.CardView;

import com.badlogic.gdx.scenes.scene2d.Group;

public interface ICard {

    Group init(int index, int priority);

    int getIndex();

    int getPriority();

}

