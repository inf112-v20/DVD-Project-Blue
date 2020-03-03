package inf112.RoboRally.app.views.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Card extends Group {

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));
    public int index;
    public int priority;
    public Group cardGroup;
    public Label priorityNumber;
    public Image card;

    public Group init (int index, int priority) {
        this.index = index;
        this.priority = priority;

        String texturePath = new String("Cards/");

        if (index == 0){
            texturePath += "Move1.png";
        } else if (index == 1) {
            texturePath += "Move2.png";
        } else if (index == 2) {
            texturePath += "Move3.png";
        } else if (index == 3) {
            texturePath += "MoveBack.png";
        } else if (index == 4) {
            texturePath += "RotateLeft.png";
        } else if (index == 5) {
            texturePath += "RotateRight.png";
        } else {
            texturePath += "U-Turn.png";
        }

        Texture cardTexture = new Texture(texturePath);
        cardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        card = new Image(cardTexture);

        priorityNumber = new Label(String.format("%04d", priority), skin);
        priorityNumber.setFontScale(1/3f);
        priorityNumber.setPosition(78, 146);

        cardGroup = new Group();
        cardGroup.addActor(card);
        cardGroup.addActor(priorityNumber);
        return cardGroup;
    }

    public int getIndex () {
        return index;
    }

    public int getPriority () {
        return priority;
    }

    public Group getGroup () {
        return cardGroup;
    }

}
