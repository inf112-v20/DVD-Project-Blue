package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.Robot.Robot;
import inf112.RoboRally.app.models.cards.ICard;

/*
Class that holds information about each player. Initialized with
starting position and direction for the players' robot, as passed by the being
played on.
 */
public class Player {

    private String name;
    private int playerNumber;
    private Robot robot;
    private ICard[] cardsToChoose = new ICard[9];
    private ICard[] cardsChosen = new ICard[5];
    private int flagsCollected = 0;

    public Player(Game game, int playerNumber) {
        this.playerNumber = playerNumber;
        robot = new Robot(game, playerNumber);
    }

    public Robot robot() {
        return robot;
    }

    public int playerNumber() {
        return playerNumber;
    }

    public void getCardToChoose(int i, ICard card) {
        cardsToChoose[i] = card;
    }

    public ICard getNextChosenCard() {
        for (int i = 0; i < cardsChosen.length; i++) {
            ICard card = cardsChosen[i];
            if (cardsChosen[i] != null) {
                cardsChosen[i] = null;
                return card;
            }
        }
        return null;
    }

    public ICard[] getCardsToChoose() {
        return cardsToChoose;
    }

    public ICard[] getCardsChosen() {
        return cardsChosen;
    }
}
