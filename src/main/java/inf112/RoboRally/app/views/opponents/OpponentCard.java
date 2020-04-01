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

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

public class OpponentCard {
    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    private Group cardGroup;
    private Image cardImage;

    public Group createCardGroup(int index, int priority) {

        String texturePath = "Cards/Opponent/";

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
                cardGroup.setScale(2f);
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                cardGroup.setScale(1f);
            }
        });


        return cardGroup;
    }

}

