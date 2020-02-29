package inf112.RoboRally.app.views.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

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

        Group move1Group = new Group();

        Label priority = new Label(String.format("%04d", priorityNum), skin);
        priority.setFontScale(1/2.5f);
        priority.setPosition(101, 191);
        Texture move1Texture = new Texture(texturePath);
        move1Texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Image move1 = new Image(move1Texture);
        move1.setScale(1/4f);

        move1Group.addActor(move1);
        move1Group.addActor(priority);

        return move1Group;
    }

}
