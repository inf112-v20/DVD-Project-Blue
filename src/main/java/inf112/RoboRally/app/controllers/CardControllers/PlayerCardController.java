package inf112.RoboRally.app.controllers.CardControllers;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.Player;

public class PlayerCardController {

    private Player player; // our human single player

    public PlayerCardController(Player player) {
        this.player = player;
    }

    public int numberOfReceivedCards() {
        return player.robot().getHP();
    }

    public int numberOfCardSlots() {
        return player.numberOfCardSlots();
    }

    public ICard[] getReceivedPlayerCards() {
        return player.getReceivedCards();
    }

    public Player getPlayer() {
        return player;
    }
}
