package inf112.RoboRally.app.controllers.CardControllers;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.NewGame;
import inf112.RoboRally.app.models.game.NewPlayer;
import inf112.RoboRally.app.views.card.ICardDragAndDrop;

public class NewGameCardController {

    private NewPlayer player; // our human player
    private NewGame game;

    public NewGameCardController(NewGame game) {
        this.game = game;
        this.player = game.getHumanPlayer();
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
        for (ICardDragAndDrop viewCard: cardsFromView) {
            if (viewCard.getModelCard() != null)
                fillPlayerCardSlot(viewCard.getModelCard());
        }

        game.round().executeHumanCardChoices();
    }

    private void fillPlayerCardSlot(ICard card) {
        ICard[] playerModelCardSlots = player.getCardSlots();
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



}

