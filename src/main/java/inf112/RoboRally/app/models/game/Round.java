package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;

import java.util.ArrayList;

/*
Next delivery
 */
public class Round {

    private CardFactory cardFactory = new CardFactory();
    private Game game;

    public Round(Game game) {
        this.game = game;
    }

    public void dealCards() {
        Player[] players = game.players();
        for (Player player: players) {
            for (int i = 0; i < player.amountOfReceivedCards(); i++) {
                ICard card = cardFactory.randomCard();
                player.receiveCard(i, card);
            }
        }

    }


    // only executes our human players card choices for now
    public void executeCardChoices() {
        Player player = game.getHumanPlayer();
        for (ICard card: player.getCardSlots()) {
            if (card == null) break; // means no cards are left to execute
            System.out.println("got to moving the robot");
            card.moveRobot(player.robot());
        }
    }

    // TODO - implement
    public void executeNextCardChoices(Player[] players, ArrayList<ICard> nextPlayerChoices) {

    }

    // TODO - implement
    private ArrayList<ICard> getNextCardChoices(Player[] players) {
        return null;
    }

}
