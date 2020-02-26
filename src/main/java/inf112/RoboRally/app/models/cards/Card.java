package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.board.Robot;
/*
Card super class that extends to all cards that program robots.
Holds the priority of each card.
 */
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
