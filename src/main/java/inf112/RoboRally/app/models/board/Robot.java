package inf112.RoboRally.app.models.board;
/*
Model of a robot. Initialized with position and direction. This information is passed on by
the board it is initialized on.
 */
public class Robot {

    Position pos;
    Direction direction;

    int damage;
    int HP;
    int lives;

    public Robot(Position pos, Direction direction) {
        HP = 9;
        lives = 3;
        damage = 1;
        this.pos = pos;
        this.direction = direction;
    }


    public void move(int stepsToTake) {
        if (direction == Direction.UP) {
            pos.moveVertical(stepsToTake);
        } else if (direction == Direction.DOWN) {
            pos.moveVertical(-stepsToTake);
        } else if (direction == Direction.RIGHT) {
            pos.moveHorizontal(stepsToTake);
        } else {
            pos.moveHorizontal(-stepsToTake);
        }
    }

    public void rotateDirectionLeft() {
        direction = direction.rotateLeft();
    }

    public void rotateDirectionRight() {
        direction = direction.rotateRight();
    }

    public void uTurn() {
        direction = direction.rotateRight();
        direction = direction.rotateRight();
    }

    public int getX() {
        return pos.getX();
    }

    public int getY() {
        return pos.getY();
    }

    public Direction getDirection() {
        return direction;
    }

    // models for these functions are not yet implemented
    public void shoot() {
        // Do the shooting thing
        // For loop to check for potentioal targets
        // Return an index of targets hit
    }

    public int looseHP(int HP) {
        return HP--;
    }

    public int gainHP(int HP) {
        return HP++;
    }

    public int getHP() {
        return HP;
    }

    public int getDamage() {
        return damage;
    }
}
