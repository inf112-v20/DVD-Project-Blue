package inf112.RoboRally.app.views.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Button {

    final private Skin SKIN = new Skin(Gdx.files.internal("ButtonSkin/button-ui.json"));
    final private Sound sound = Gdx.audio.newSound(Gdx.files.internal("Sound/MenuSelect.wav"));;

    public TextButton createTextButton (String buttonName) {
        TextButton textButton = new TextButton(buttonName, SKIN);
        textButton.setTransform(true);
        textButton.getLabel().setText("  " + buttonName + "  ");
        textButton.getLabelCell().pad(10,0,10, 0).center();

        textButton.getLabel().addListener(new InputListener() {
            boolean played = false;
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!played) {
                    sound.play();
                    played = true;
                }
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                played = false;
            }
        });

        return textButton;
    }

}
