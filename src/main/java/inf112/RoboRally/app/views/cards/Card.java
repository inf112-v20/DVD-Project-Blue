package inf112.RoboRally.app.views.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.*;

public class Card {

    final private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    public Group move1 (int priorityNum) {
        Group move1Group = new Group();

        Label priority = new Label(String.format("%04d", priorityNum), skin);
        priority.setFontScale(1/2.5f);
        priority.setPosition(101, 191);
        Texture move1Texture = new Texture("Cards/Move1.png");
        move1Texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image move1 = new Image(move1Texture);
        move1.setScale(1/4f);

        move1Group.addActor(move1);
        move1Group.addActor(priority);

        return move1Group;
    }

}
