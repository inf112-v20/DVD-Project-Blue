package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.robot.Robot;

public class NewPlayer {

    private String name;
    private int playerNumber;
    private Robot robot;
    private ICard[] receivedCards = new ICard[9];
    private ICard[] cardSlots = new ICard[5];

    public NewPlayer(NewGame game, int playerNumber) {
        this.playerNumber = playerNumber;
        robot = new Robot(game, playerNumber);
    }

    public void receiveCard(int i, ICard card) {
        card.setPlayer(this);
        receivedCards[i] = card;
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

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Robot robot() {
        return robot;
    }

}
