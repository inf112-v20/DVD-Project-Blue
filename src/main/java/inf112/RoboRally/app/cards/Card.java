package inf112.RoboRally.app.cards;

import inf112.RoboRally.app.models.board.Robot;

public class Card {

    private int priority;

    public Card(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    // Made to use moveRobot in subclass cards
    public void moveRobot(Robot r) {}
}
