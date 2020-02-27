package inf112.RoboRally.app.views.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Button {

    private Skin skin = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    public TextButton createTextButton (String buttonName) {
        TextButton textButton = new TextButton(buttonName, skin);
        textButton.setTransform(true);
        textButton.getLabelCell().pad(10,60,10, 60).center();
        return textButton;
    }

}
