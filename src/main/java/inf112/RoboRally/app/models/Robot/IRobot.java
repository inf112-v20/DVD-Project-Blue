package inf112.RoboRally.app.models.Robot;

import inf112.RoboRally.app.models.cards.Rotation;

public interface IRobot {

    void move(int steps);

    void rotate(Rotation rotation);

    void looseHP();

    void getHP();

}
