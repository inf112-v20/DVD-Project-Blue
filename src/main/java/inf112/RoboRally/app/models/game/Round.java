package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.CardDeck;
import inf112.RoboRally.app.models.cards.ICard;

import java.util.ArrayList;

/*
Next delivery
 */
public class Round {

    private CardDeck cards;

    public void dealCards(Player[] players) {
        for (Player player: players) {
            for (int i = 0; i < player.getCardsToChoose().length; i++) {
                ICard card = cards.getRandomCardFromDeck();
                player.getCardToChoose(i, card);
            }
        }
    }

    public void executeAllCardChoices(Player[] players) {
        while (true) {
            ArrayList<ICard> nextPlayerChoices = getNextCardChoices(players);

            // means all cards are processed, no more cards to execute
            if (nextPlayerChoices == null) break;

            executeNextCardChoices(players, nextPlayerChoices);
        }
    }

    // TODO - denne funker ikke enda, må sammenligne alle kort, ikke ta første som ikke er null
    public void executeNextCardChoices(Player[] players, ArrayList<ICard> nextPlayerChoices) {
        for (int i = 0; i < nextPlayerChoices.size(); i++) {
            ICard card = nextPlayerChoices.get(0);
            if (card != null) {
                // the robot is moved here
                card.moveRobot(players[i].robot());
                nextPlayerChoices.set(i, null);
            }
        }
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
