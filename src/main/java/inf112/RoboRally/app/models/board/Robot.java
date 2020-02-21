package inf112.RoboRally.app.models.board;

public class Robot {
    // TODO Check out gdb.math before duplicating too much code.
    public Position position;
    public Direction facing_direction;

    // Få robot koden av Gytis

    int damage;
    int HP;
    int lives;
    String direction;

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

    // TODO - Tord her

    //private

    public int moveRight(int x) {
        return x++;
    }
    public int moveLeft(int x) {
        return x--;
    }
    public int moveUp(int y) {
        return y++;
    }
    public int moveDown(int y) {
        return y--;
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
    public int getHP(){
        return HP;
    }
    public int getDamage() {
        return damage;
    }
    public String getDirection(){
        return direction;
    }



}
