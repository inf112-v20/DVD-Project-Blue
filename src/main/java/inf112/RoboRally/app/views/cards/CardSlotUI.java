package inf112.RoboRally.app.views.cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class CardSlotUI extends Table {

    public Table cardSlot;
    public Image cardImage,cardImage2,cardImage3,cardImage4,cardImage5;

    public CardSlotUI() {
        cardSlot = new Table();
        cardSlot.setFillParent(true);
        cardSlot.bottom().padBottom(8);

        Texture emptyCardTexture = new Texture("Images/emptySmallCard.png");
        emptyCardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        Texture CardTexture = new Texture("Images/MoveBackSmallCard.png");
        CardTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        cardImage = new Image(emptyCardTexture);
        cardImage2 = new Image(CardTexture);
        cardImage3 = new Image(CardTexture);
        cardImage4 = new Image(CardTexture);
        cardImage5 = new Image(CardTexture);


        cardSlot.add(cardImage).padRight(23);
        cardSlot.add(cardImage2).padRight(23);
        cardSlot.add(cardImage3);
        cardSlot.add(cardImage4).padLeft(23);
        cardSlot.add(cardImage5).padLeft(23);
    }

    public void changeImage (Actor oldActor, Actor newActor) {
        cardSlot.getCell(oldActor).clearActor().setActor(newActor).fill().padRight(121);
    }

    public void resetImages () {
        cardSlot.getCell(cardImage).clearActor().setActor(cardImage);
        cardSlot.getCell(cardImage2).clearActor().setActor(cardImage2);
        cardSlot.getCell(cardImage3).clearActor().setActor(cardImage3);
        cardSlot.getCell(cardImage4).clearActor().setActor(cardImage4);
        cardSlot.getCell(cardImage5).clearActor().setActor(cardImage5);
    }

}
