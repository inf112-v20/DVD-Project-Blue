package inf112.RoboRally.app.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/*
Button styling class. Used to style buttons in the menus. Changes made here, will affect all of the buttons.
 */

public class buttonStyle {

    private BitmapFont arialFont;
    private Skin buttonSkin;
    private TextButton.TextButtonStyle textButtonStyle;
    private static final float textScale = 1/3f;

    public buttonStyle () {
        arialFont = new BitmapFont(Gdx.files.internal("ButtonStyle/Arial.fnt"));
        arialFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        arialFont.getData().setScale(textScale);

        buttonSkin = new Skin();
        buttonSkin.add("style", new Texture("ButtonStyle/ButtonStyle.png"));
        buttonSkin.add("default", new BitmapFont());

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = buttonSkin.newDrawable("style");
        textButtonStyle.down = buttonSkin.newDrawable("style", Color.RED);
        textButtonStyle.checked = buttonSkin.newDrawable("style", Color.YELLOW);
        textButtonStyle.over = buttonSkin.newDrawable("style", Color.BLUE);
        textButtonStyle.font = arialFont;
        buttonSkin.add("default", textButtonStyle);
    }

    public Skin getButtonSkin () {
        return buttonSkin;
    }

}
