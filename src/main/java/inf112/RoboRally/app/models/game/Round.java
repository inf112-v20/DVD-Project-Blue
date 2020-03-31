package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.cards.SortCardByPriority;

import java.util.ArrayList;
import java.util.Collections;

/*
Next delivery
 */
public class Round {

    private CardFactory cardFactory = new CardFactory();
    private NewPlayer[] players;
    private NewPlayer humanPlayer;

    public Round(NewGame game) {
        this.players = game.players();
        this.humanPlayer = game.getHumanPlayer();
    }

    public void dealCards () {
//        System.out.println("FROM Round: Sure thing. Lets do it one more time.");
        removeDealtCards(); // does not do anything the first round
        for (NewPlayer player : players) {
            for (int i = 0; i < player.amountOfReceivedCards(); i++) {
                ICard card = cardFactory.randomCard();
                player.receiveCard(i, card);
            }
        }

    }

    // only executes our human players card choices for now
    public void executeHumanCardChoices() {
        ICard[] cardChoices = humanPlayer.getCardSlots();
        for (int slotNumber = 0; slotNumber < cardChoices.length; slotNumber++) {
            ICard card = cardChoices[slotNumber];
            if (card == null) break;    // means no cards are left to execute
            System.out.println("FROM Round: I am moving the robot with a slotted card");
            card.moveRobot(humanPlayer.robot());
            cardChoices[slotNumber] = null;   // card is executed, remove it from the slot
        }
        removeDealtCards();
    }

    private void removeDealtCards () {
        for (NewPlayer player: players) {
            ICard[] dealtCards = player.getReceivedCards();
            for (int i = 0; i < dealtCards.length; i++) {
                dealtCards[i] = null;
            }

        }

    }

    private ArrayList<ICard> collectAllCardsFromSlots() {
        ArrayList<ICard> allCards = new ArrayList<>();
        for (NewPlayer player: players) {
            ICard[] cardSlots = player.getCardSlots();
            for (int slotNumber = 0; slotNumber < player.numberOfCardSlots(); slotNumber++) {
                if (cardSlots[slotNumber] != null)
                    allCards.add(cardSlots[slotNumber]);
            }

        }

        return allCards;
    }

    private ArrayList<ICard> sortCardsByPriority(ArrayList<ICard> allCardsFromSlots) {
        Collections.sort(allCardsFromSlots, new SortCardByPriority());
        return allCardsFromSlots;
    }

    public void executeCardChoices() {
        ArrayList<ICard> cardsByPriority = sortCardsByPriority(collectAllCardsFromSlots());
        for (ICard card: cardsByPriority) {
            if (card != null)
                card.moveRobot(card.getPlayer().robot());
        }
    }


}



