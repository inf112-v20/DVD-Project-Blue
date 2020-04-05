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
    private Player[] players;
    private Player humanPlayer;

    public Round(Game game) {
        this.players = game.players();
        this.humanPlayer = game.getHumanPlayer();
    }

    public void startNewRound() {
        dealCards();
        botPlayersChooseCards();
    }

    private void botPlayersChooseCards() {
        for (Player player: players) {
            if (player.isBotPlayer())
                player.chooseCards();
        }
    }

    public void dealCards () {
//        System.out.println("FROM Round: Sure thing. Lets do it one more time.");
        removeDealtCards(); // does not do anything the first round
        for (Player player : players) {
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
        for (Player player: players) {
            ICard[] dealtCards = player.getReceivedCards();
            for (int i = 0; i < dealtCards.length; i++) {
                dealtCards[i] = null;
            }

        }

    }

    private ArrayList<ICard> collectAllCardsFromSlots() {
        ArrayList<ICard> allCards = new ArrayList<>();
        for (Player player: players) {
            ICard[] cardSlots = player.getCardSlots();
            for (int slotNumber = 0; slotNumber < player.numberOfCardSlots(); slotNumber++) {
                if (cardSlots[slotNumber] != null)
                    allCards.add(cardSlots[slotNumber]);
            }

        }

        return allCards;
    }

    private ArrayList<ICard> collectCardsFromSlotNumber(int slotNumber) {
        ArrayList<ICard> cards = new ArrayList<>();
        for (Player player: players) {
            ICard[] slottedCards = player.getCardSlots();
            if (slottedCards[slotNumber] != null) {
                cards.add(slottedCards[slotNumber]);
                slottedCards[slotNumber] = null;
            }
        }
        return cards;
    }

    private ArrayList<ICard> sortCardsByPriority(ArrayList<ICard> allCardsFromSlots) {
        Collections.sort(allCardsFromSlots, new SortCardByPriority());
        return allCardsFromSlots;
    }

    public void executeCardChoices() {
        for (int slotNumber = 0; slotNumber < humanPlayer.getCardSlots().length; slotNumber++) {
            ArrayList<ICard> cards = sortCardsByPriority(collectCardsFromSlotNumber(slotNumber));
            CardExecutor cardExecutor = new CardExecutor(cards);
            cardExecutor.executeCards();
        }

    }


}



