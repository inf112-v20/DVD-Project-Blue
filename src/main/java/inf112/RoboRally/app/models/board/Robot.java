package inf112.RoboRally.app.models.board;

public class Robot {

    Position pos;
    Direction direction;

    // Få robot koden av Gytis

    int damage;
    int HP;
    int lives;

    public void init() {
        HP = 9;
        lives = 3;
        damage = 1;


        //if (bot1) {
        //  set pos.x
        //  set pos.y
        //  set direction "north"
        //
        //}


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

    public Direction getDirection() {
        return direction;
    }
}
