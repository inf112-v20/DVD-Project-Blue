package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.controllers.CardControllers.GameCardController;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.robot.Robot;
import inf112.RoboRally.app.views.player.PlayerUI;

public class Player {

    private String name;
    private int playerNumber;
    private boolean isHuman;
    private Robot robot;
    private ICard[] receivedCards = new ICard[10];
    private ICard[] cardSlots = new ICard[5];

    private volatile PlayerUI playerUI;

    public Player(Game game, int playerNumber) {
        this.playerNumber = playerNumber;
        robot = new Robot(game, playerNumber);
        isHuman = false;
    }

    public void receiveCard(int i, ICard card) {
        card.setPlayer(this);
        receivedCards[i] = card;
    }

    public ICard getCardFromSlotNumber(int slotNumber) {
        return cardSlots[slotNumber];
    }

    public ICard[] getReceivedCards() {
        return receivedCards;
    }

    public ICard[] getCardSlots() {
        return cardSlots;
    }

    public int amountOfReceivedCards() {
        return robot.getHP();
    }

    public int numberOfCardSlots() {
        return cardSlots.length;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Robot robot() {
        return robot;
    }

    public void setAsHumanPlayer() {
        isHuman = true;
    }

    public boolean isBotPlayer() {
        return !isHuman;
    }

    // only chooses one card for now
    public void chooseCards() {
        for (ICard card: receivedCards) {
            if (card != null) {
                putReceivedCardInCardSlot(card);
            }
        }
    }

    // puts card in the first empty slot
    private void putReceivedCardInCardSlot(ICard card) {
        for (int slotNumber = 0; slotNumber < cardSlots.length; slotNumber++) {
            if (cardSlots[slotNumber] == null) {
                cardSlots[slotNumber] = card;
                System.out.println(card.getFileName()+", "+card.priority());
                return;
            }
        }
    }

    public void setupUI(GameCardController controller) {
        playerUI = new PlayerUI(this, controller);
    }

    public PlayerUI getPlayerUI() {
        return playerUI;
    }

    public void updateOpponentCardSlots(int slotNumberFacingUp) {
        playerUI.updateOpponentCardSlots(slotNumberFacingUp);
    }
}
