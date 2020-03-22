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

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

public class SmallCard implements ICard {

    private int index;
    private int priority;
    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));
    private Group cardGroup;

    @Override
    public Group init (int index, int priority) {
        this.index = index;
        this.priority = priority;
        String texturePath = new String("Cards/SMALL/");

        if (index == 0){
            texturePath += "Move1SmallCard.png";
        } else if (index == 1) {
            texturePath += "Move2SmallCard.png";
        } else if (index == 2) {
            texturePath += "Move3SmallCard.png";
        } else if (index == 3) {
            texturePath += "MoveBackSmallCard.png";
        } else if (index == 4) {
            texturePath += "RotateLeftSmallCard.png";
        } else if (index == 5) {
            texturePath += "RotateRightSmallCard.png";
        } else if (index == 6) {
            texturePath += "U-TurnSmallCard.png";
        } else if (index == 7) {
            texturePath += "lockedSmallCard.png";
        } else {
            texturePath += "emptySmallCard.png";
        }

        Texture cardTexture = new Texture(texturePath);
        cardTexture.setFilter(Linear, Linear);
        Image card = new Image(cardTexture);

        Label priorityNumber = new Label(String.format("%04d", priority), skin);
        priorityNumber.setFontScale(1/5f);
        priorityNumber.setPosition(52, 83);

        cardGroup = new Group();

        cardGroup.addActor(card);
        if (index < 7) {
            cardGroup.addActor(priorityNumber);
        }

        cardGroup.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                cardGroup.setOriginX(card.getWidth()/2);
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
    public int getIndex () {
        return index;
    }

    @Override
    public int getPriority () {
        return priority;
    }
}

