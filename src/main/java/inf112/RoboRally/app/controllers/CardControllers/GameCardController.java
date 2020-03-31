package inf112.RoboRally.app.controllers.CardControllers;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Game;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.views.card.ICardDragAndDrop;

/*
Class that communicates relevant game stats in terms of cards to view, and slot choices
from the view to the model player class
 */
public class GameCardController {

    private Player humanPlayer; // our human player
    private Game game;

    public GameCardController(Game game) {
        this.game = game;
        this.humanPlayer = game.getHumanPlayer();
    }

    public int amountOfReceivedCards() {
        return humanPlayer.amountOfReceivedCards();
    }

    public int numberOfCardSlots() {
        return humanPlayer.numberOfCardSlots();
    }

    public ICard[] getReceivedPlayerCards() {
        return humanPlayer.getReceivedCards();
    }

    public void setCardSlotsFromUserInput(ICardDragAndDrop[] cardsFromView) {
        for (ICardDragAndDrop viewCard: cardsFromView) {
            if (viewCard.getModelCard() != null)
                fillPlayerCardSlot(viewCard.getModelCard());
        }

        game.round().executeHumanCardChoices();
    }

    private void fillPlayerCardSlot(ICard card) {
        ICard[] playerModelCardSlots = humanPlayer.getCardSlots();
        for (int i = 0; i < playerModelCardSlots.length; i++) {
            if (playerModelCardSlots[i] == null) {
                System.out.println("FROM GameCardController: found a card in the slot. I am giving it to the Player model");
                playerModelCardSlots[i] = card;
                break;
            }

        }

    }

    public void newRound() {
        System.out.println("FROM GameCardController: Roger that. Telling mr. Round to start a new round");
        game.round().dealCards();
    }


    public Player humanPlayer() {
        return humanPlayer;
    }



}
