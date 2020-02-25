package inf112.RoboRally.app.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class cardHud {

    public Texture moveButton, moveButton2, moveButton3, moveBackButton, rotateLeftButton, rotateRightButton, uTurnButton;
    public ImageButton move, move2, move3, moveBack, rotateLeft, rotateRight, uTurn;

    public Table create () {
        Skin skin = new Skin(Gdx.files.internal("neonSkin/neon-ui.json"));

        Table cardTable = new Table();
        cardTable.left();
        cardTable.setFillParent(true);

        moveButton = new Texture("Cards/SMALL/Move1.png");
        move = new ImageButton(new TextureRegionDrawable(new TextureRegion(moveButton)));
        move.setTransform(true);

        moveButton2 = new Texture("Cards/SMALL/Move2.png");
        move2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(moveButton2)));
        move2.setTransform(true);

        moveButton3 = new Texture("Cards/SMALL/Move3.png");
        move3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(moveButton3)));
        move3.setTransform(true);

        moveBackButton = new Texture("Cards/SMALL/BackUp.png");
        moveBack = new ImageButton(new TextureRegionDrawable(new TextureRegion(moveBackButton)));
        moveBack.setTransform(true);

        rotateLeftButton = new Texture("Cards/SMALL/RotateLeft.png");
        rotateLeft = new ImageButton(new TextureRegionDrawable(new TextureRegion(rotateLeftButton)));
        rotateLeft.setTransform(true);

        rotateRightButton = new Texture("Cards/SMALL/RotateRight.png");
        rotateRight = new ImageButton(new TextureRegionDrawable(new TextureRegion(rotateRightButton)));
        rotateRight.setTransform(true);

        uTurnButton = new Texture("Cards/SMALL/U-Turn.png");
        uTurn = new ImageButton(new TextureRegionDrawable(new TextureRegion(uTurnButton)));
        uTurn.setTransform(true);

        cardTable.add(move);
        cardTable.add(move2);
        cardTable.row();
        cardTable.add(move3);
        cardTable.add(moveBack);
        cardTable.row();
        cardTable.add(rotateRight);
        cardTable.add(rotateLeft);
        cardTable.row();
        cardTable.add(uTurn);

        return cardTable;

    }

}
