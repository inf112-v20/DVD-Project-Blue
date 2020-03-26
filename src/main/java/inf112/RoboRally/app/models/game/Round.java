package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;

import java.util.ArrayList;

/*
Next delivery
 */
public class Round {

    private CardFactory cardFactory = new CardFactory();

    public void dealCards(Player[] players) {

        for (Player player: players) {
            for (int i = 0; i < player.amountOfReceivedCards(); i++) {
                ICard card = cardFactory.randomCard();
                player.receiveCard(i, card);
            }
        }

    }


    // only executes our human players card choices for now
    public void executeCardChoices(Player player) {
        for (ICard card: player.getCardSlots()) {
            if (card == null) break; // means no cards are left
            card.moveRobot(player.robot());
        }
    }

    public void executeNextCardChoices(Player[] players, ArrayList<ICard> nextPlayerChoices) {

    }

    private ArrayList<ICard> getNextCardChoices(Player[] players) {
        ArrayList<ICard> nextPlayerChoices = new ArrayList<>(players.length);
        int amountOfPlayersNotHavingCard = 0;
        for (Player player: players) {
            nextPlayerChoices.add(player.getNextChosenCard());
            if (player.getNextChosenCard() == null) amountOfPlayersNotHavingCard++;
        }

        // if all players' next card is null, no cards are left to process
        if (amountOfPlayersNotHavingCard == players.length) return null;

        return nextPlayerChoices;
    }

}
