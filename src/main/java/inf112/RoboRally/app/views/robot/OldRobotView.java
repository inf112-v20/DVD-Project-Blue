package inf112.RoboRally.app.views.robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.RoboRally.app.models.cards.Rotation;
import inf112.RoboRally.app.models.robot.Direction;
import inf112.RoboRally.app.models.robot.Pos;
import inf112.RoboRally.app.views.game.GameScreen;

public class OldRobotView extends Sprite {

    private boolean hasOneFlag = false;

    private Texture texture;

    private final float TILE_HEIGHT_PX = 96.053575f; // 256 /  2.665179302
    private final float TILE_WIDTH_PX = 98.46153846153846f; // 256 / 2.6 (tile px size / scaling down property)
    private final int SPRITE_MOVEMENT_SPEED = 180;
    private float resetDegrees = 90.0f;

    private float targetX;
    private float targetY;

    private GameScreen screen;

    public OldRobotView(Sprite sprite, Texture texture, Pos startPos, Direction startDirection) {
        super(sprite);
        this.texture = texture;
        setStartDirection();
        setStartPosition(startPos);
        System.out.println("degrees after : "+getRotation());
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    private void update(float delta) {

        if (getX() < targetX) {
            setX(getX() + SPRITE_MOVEMENT_SPEED * delta);
        }
        if (getX() > targetX) {
            setX(getX() - SPRITE_MOVEMENT_SPEED * delta);
        }
        if (getY() < targetY) {
            setY(getY() + SPRITE_MOVEMENT_SPEED * delta);
        }
        if (getY() > targetY) {
            setY(getY() - SPRITE_MOVEMENT_SPEED * delta);
        }
    }

    public void updateX(int x) {
        targetX = ( x * TILE_WIDTH_PX);
    }

    public void updateY(int y) {
        targetY = ( y * TILE_HEIGHT_PX);
    }

    public void updateDirection(Rotation rotation) {
        switch (rotation) {
            case LEFT:
                rotate90(false);
                return;
            case RIGHT:
                rotate90(true);
                return;
            case UTURN:
                rotate90(true);
                rotate90(true);
                return;
            default:
                throw new IllegalArgumentException("RobotView is told to rotate '"+rotation+"', which is not supported");
        }

    }


    public void setStartDirection() {
        System.out.println("Degrees before : "+getRotation());
        setRotation(270.0f);
//        setRotation(270.0f);
//        System.out.println("rotation after reset:" +getRotation());
//        setRotation(resetDegrees);
//        System.out.println(getRotation());
//        switch (startDirection) {
//            case RIGHT:
//                rotate90(true);
//                return;
//            case LEFT:
//                rotate90(false);
//                return;
//            case DOWN:
//                rotate90(true);
//                rotate90(true);
//                return;
//            case UP:
//                return;
//            default:
//                throw new IllegalStateException("RobotView was given start direction '"+startDirection+"', which is not supported");
//        }
    }


    public void setStartPosition(Pos startPos) {
        setX( (startPos.getX() * TILE_WIDTH_PX) );
        setY( (startPos.getY() * TILE_HEIGHT_PX) );
        targetX = getX();
        targetY = getY();
    }

    public void setResetDegrees(float resetDegrees) {
        this.resetDegrees = resetDegrees;
    }


    private void changeTexture(int playerNumber, Texture texture) {
        screen.updateTexture(playerNumber, texture);
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.screen = gameScreen;
    }

    public void updateTexture(Texture texture) {
        this.texture = texture;
        setTexture(texture);
    }

    public void updateTexture() {
        setTexture(texture);
    }

    public void setHasOneFlag() {
        hasOneFlag = true;
    }

    public boolean hasOneFlag() {
        return hasOneFlag;
    }


}
