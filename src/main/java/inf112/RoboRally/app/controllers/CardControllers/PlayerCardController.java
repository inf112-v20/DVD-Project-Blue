package inf112.RoboRally.app.controllers.CardControllers;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.views.card.ICardDragAndDrop;

/*
Class that communicates relevant game stats in terms of cards to view, and slot choices
from the view to the model player class
 */
public class PlayerCardController {

    private Player player; // our human single player

    public PlayerCardController(Player player) {
        this.player = player;
    }

    public int amountOfReceivedCards() {
        return player.amountOfReceivedCards();
    }

    public int numberOfCardSlots() {
        return player.numberOfCardSlots();
    }

    public ICard[] getReceivedPlayerCards() {
        return player.getReceivedCards();
    }

    public void setCardSlotsFromUserInput(ICardDragAndDrop[] cardsFromView) {
        System.out.println("READY");
        for (ICardDragAndDrop viewCard: cardsFromView) {
            if (viewCard.getModelCard() != null)
                fillPlayerCardSlot(viewCard.getModelCard());
        }
    }

    private void fillPlayerCardSlot(ICard card) {
        ICard[] playerModelCardSlots = player.getCardSlots();
        for (int i = 0; i < playerModelCardSlots.length; i++) {
            if (playerModelCardSlots[i] != null) {
                playerModelCardSlots[i] = card;
                break;
            }
        }
        player.setReadyForRound();
    }



}
