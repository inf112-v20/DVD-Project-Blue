package inf112.RoboRally.app.views.cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class CardSlotUI {

    public Table cardslot;

    public Image img,img2;

    public Table init() {
        cardslot = new Table();
        cardslot.setFillParent(true);
        cardslot.bottom();

        Texture txt = new Texture("Images/cardslot.png");
        txt.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        img = new Image(txt);
        img2 = new Image(txt);

        cardslot.add(img);
        cardslot.add(img2);

        return cardslot;
    }

//    public void addimg (Actor newimg) {
//        cardslot.add(newimg);
//    }
//
//    public void changeImg (Actor actor) {
//        cardslot.getCell(actor).clearActor();
//    }

}
