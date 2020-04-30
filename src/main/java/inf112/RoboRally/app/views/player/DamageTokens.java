package inf112.RoboRally.app.views.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class DamageTokens {

    // positioning
    private final int BOTTOM_PAD_BOTTOM = 183;
    private final int BOTTOM_PAD_LEFT = 128;
    private final int IMAGE_PAD = 12;
    private final int SMALL_IMAGE_PAD = 6;

    // image file paths
    private final String NO_DAMAGE_TOKEN_IMG_PATH = "assets/PlayerHud/emptyDamageToken.png"; // an empty placeholder image
    private final String RED_DAMAGE_TOKEN_IMG_PATH = "assets/PlayerHud/DamageTokenRed.png";
    private final String REGULAR_DAMAGE_TOKEN_IMG_PATH = "assets/PlayerHud/DamageTokenSlightDmg.png";
    private final String LOCK_DAMAGE_TOKEN_IMG_PATH = "assets/PlayerHud/DamageTokenSlightDmgLockCard.png";

    // image textures
    private final Texture[] DAMAGE_TAKEN_TEXTURES = {
            new Texture(RED_DAMAGE_TOKEN_IMG_PATH),
            new Texture(LOCK_DAMAGE_TOKEN_IMG_PATH),
            new Texture(REGULAR_DAMAGE_TOKEN_IMG_PATH),
            new Texture(NO_DAMAGE_TOKEN_IMG_PATH)
    };

    private Table damageTokensTable;
    private int maxHp;
    private int hp;

    protected DamageTokens(int hp, int maxHp) {
        this.maxHp = maxHp;
        this.hp = hp;
        this.hp = 5;
        damageTokensTable = new Table();
        for (Texture texture: DAMAGE_TAKEN_TEXTURES)
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    protected Table damageTokensTable() {
        damageTokensTable.bottom().padBottom(BOTTOM_PAD_BOTTOM).padLeft(BOTTOM_PAD_LEFT);
        damageTokensTable.setFillParent(true);

        for (int damageTokenIndex = 0; damageTokenIndex < maxHp; damageTokenIndex++)
            addImageToTable(damageTokenIndex, damageTokenIndex >= hp);

        return damageTokensTable;
    }

    private void addImageToTable(int damageTokenIndex, boolean damageTaken) {
        Texture texture;
        if (damageTaken && damageTokenIndex == 0)      texture = DAMAGE_TAKEN_TEXTURES[0];
        else if (damageTaken && damageTokenIndex <= 5) texture = DAMAGE_TAKEN_TEXTURES[1];
        else if (damageTaken)                          texture = DAMAGE_TAKEN_TEXTURES[2];
        else                                           texture = DAMAGE_TAKEN_TEXTURES[3];

        if      (damageTokenIndex == 0)                          damageTokensTable.add(new Image(texture)).padRight(IMAGE_PAD);
        else if (damageTokenIndex >= 1 && damageTokenIndex <= 3) damageTokensTable.add(new Image(texture)).padRight(IMAGE_PAD);
        else if (damageTokenIndex == 4)                          damageTokensTable.add(new Image(texture)).padRight(SMALL_IMAGE_PAD);
        else if (damageTokenIndex == 5)                          damageTokensTable.add(new Image(texture)).padLeft(SMALL_IMAGE_PAD);
        else                                                     damageTokensTable.add(new Image(texture)).padLeft(IMAGE_PAD);
    }

}
