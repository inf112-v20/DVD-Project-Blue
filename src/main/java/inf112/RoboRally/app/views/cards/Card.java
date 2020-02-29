package inf112.RoboRally.app.views.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;

public class Card {

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    public Group init (int index, int priorityNum) {
        String texturePath = new String("Cards/");

        if (index == 0){
            texturePath += "Move1.png";
        } else if (index == 1) {
            texturePath += "Move2.png";
        } else if (index == 2) {
            texturePath += "Move3.png";
        } else if (index == 3) {
            texturePath += "BackUp.png";
        } else if (index == 4) {
            texturePath += "RotateLeft.png";
        } else if (index == 5) {
            texturePath += "RotateRight.png";
        } else {
            texturePath += "U-Turn.png";
        }

        Group cardGroup = new Group();

        Label priority = new Label(String.format("%04d", priorityNum), skin);
        priority.setFontScale(1/2.5f);
        priority.setPosition(101, 191);
        Texture cardTexture = new Texture(texturePath);
        cardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image card = new Image(cardTexture);
        card.setOrigin(cardTexture.getWidth()/2, card.getHeight()/2);
        card.setScale(1/4f);

        card.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                card.setScale(1/2f);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                card.setScale(1/4f);
            }
        });

        cardGroup.addActor(card);
        cardGroup.addActor(priority);

        return cardGroup;
    }

}
