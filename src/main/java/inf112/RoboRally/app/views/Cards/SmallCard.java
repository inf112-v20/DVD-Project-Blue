package inf112.RoboRally.app.views.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SmallCard extends Group {

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    public Group init (int index, int priority) {
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
        } else {
            texturePath += "U-TurnSmallCard.png";
        }

        Texture cardTexture = new Texture(texturePath);
        cardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image card = new Image(cardTexture);

        Label priorityNumber = new Label(String.format("%04d", priority), skin);
        priorityNumber.setFontScale(1/5f);
        priorityNumber.setPosition(52, 83);

        Group cardGroup = new Group();

        cardGroup.addActor(card);
        cardGroup.addActor(priorityNumber);

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
}
