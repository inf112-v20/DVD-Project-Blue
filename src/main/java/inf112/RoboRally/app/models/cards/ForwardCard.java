package inf112.RoboRally.app.models.cards;

import inf112.RoboRally.app.models.game.Player;

/*
Card to move robot forward.
 */
public class ForwardCard implements ICard {

    private final int PRIORITY;
    private final int STEPS_TO_MOVE;
    private final String FILENAME;

    private Player player; // determining card ownership

    public ForwardCard(int stepsToMove, int priority) {
        this.STEPS_TO_MOVE = stepsToMove;
        this.PRIORITY = priority;
        FILENAME = "Move"+stepsToMove+".png";
    }

    @Override
    public int priority() {
        return PRIORITY;
    }

    @Override
    public String getFileName() {
        return FILENAME;
    }

    @Override
    public void moveRobot() {
        player.robot().move(STEPS_TO_MOVE);
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
