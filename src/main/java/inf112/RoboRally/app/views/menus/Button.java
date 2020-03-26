package inf112.RoboRally.app.views.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Button {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));

    public TextButton createTextButton (String buttonName) {
        TextButton textButton = new TextButton(buttonName, SKIN);
        textButton.setTransform(true);
        textButton.getLabelCell().pad(10,60,10, 60).center();
        return textButton;
    }

}
