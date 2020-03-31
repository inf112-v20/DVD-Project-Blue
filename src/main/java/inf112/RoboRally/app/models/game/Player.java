package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.robot.OldRobot;
import inf112.RoboRally.app.models.cards.ICard;

/*
Class that holds information about each player. Initialized with
starting position and direction for the players' robot, as passed by the being
played on.
 */
public class Player {

    private String name;
    private int playerNumber;
    private OldRobot robot;
    private ICard[] receivedCards = new ICard[9];
    private ICard[] cardSlots = new ICard[5];
    private int flagsCollected = 0;
    private boolean cardChoicesReady;

    public Player(Game game, int playerNumber) {
        this.playerNumber = playerNumber;
        robot = new OldRobot(game, playerNumber);
    }

    // Bare bones constructor used for automatic testing
    public Player() {
        robot = new OldRobot();
    }

    public OldRobot robot() {
        return robot;
    }

    public void receiveCard(int i, ICard card) {
        receivedCards[i] = card;
    }

    public ICard getNextChosenCard() {
        for (int i = 0; i < cardSlots.length; i++) {
            ICard card = cardSlots[i];
            if (cardSlots[i] != null) {
                cardSlots[i] = null;
                return card;
            }
        }
        return null;
    }

    public ICard[] getReceivedCards() {
        return receivedCards;
    }

    public ICard[] getCardSlots() {
        return cardSlots;
    }

    public int amountOfReceivedCards() {
        return robot.getHP();
    }

    public int numberOfCardSlots() {
        return cardSlots.length;
    }

    public void setReadyForRound() {
        this.cardChoicesReady = true;
    }

    public boolean readyForRound() {
        return cardChoicesReady;
    }
}
