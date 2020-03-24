package inf112.RoboRally.app.controllers.CardControllers;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;

public class CardController {

    private Player player; // our human single player

    public CardController(Player player) {
        this.player = player;
    }

    public int getAmountOfCardsToChooseFrom() {
        return player.robot().getHP();
    }

    public ICard[] getPlayerCardChoices() {
        return player.getCardsToChoose();
    }

    public Player getPlayer() {
        return player;
    }
}
