package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.robot.Robot;
import inf112.RoboRally.app.views.card.ICardDragAndDrop;
import inf112.RoboRally.app.views.player.PlayerUI;

public class Player {

    private final int NUMBER_OF_CARDS_TO_RECEIVE = 9;
    private final int NUMBER_OF_CARD_SLOTS = 5;

    private String name;
    private int playerNumber;
    private boolean isHuman;
    private Robot robot;
    private ICard[] receivedCards = new ICard[NUMBER_OF_CARDS_TO_RECEIVE];
    private ICard[] cardSlots = new ICard[NUMBER_OF_CARD_SLOTS];

    private Game game;
    private PlayerUI playerUI;
    private int numberOfPlayersInGame;

    public Player(Game game, int playerNumber) {
        this.playerNumber = playerNumber;
        name = "PLAYER" + (playerNumber+1);
        this.game = game;
        this.numberOfPlayersInGame = game.players().length;
        robot = new Robot(this, game);
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

    public int numberOfReceivedCards() {
        return Math.min(robot.getHP(), NUMBER_OF_CARDS_TO_RECEIVE);
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

    public void setCardSlotsFromUserInput(ICardDragAndDrop[] cardsFromView) {
        for (ICardDragAndDrop viewCard : cardsFromView) {
            if (viewCard.getModelCard() != null)
                fillPlayerCardSlot(viewCard.getModelCard());
        }
    }

    private void fillPlayerCardSlot(ICard card) {

        for (int slotNumber = 0; slotNumber < numberOfCardSlots(); slotNumber++) {
            if (cardSlots[slotNumber] == null) {
//                System.out.println("FROM GameCardController: found a card in the slot. I am giving it to the Player model");
                cardSlots[slotNumber] = card;
                break;
            }

        }

    }

    public void setupUI() {
        playerUI = new PlayerUI(this, false);
    }

    public PlayerUI getPlayerUI() {
        return playerUI;
    }

    public void updateOpponentCardSlots(boolean cardsFacingUp) {
        playerUI.updateOpponentCardSlots(cardsFacingUp);
    }

    public int getNumberOfPlayersInGame() {
        return numberOfPlayersInGame;
    }

    public Game getGame() {
        return game;
    }

    public Player[] getAllPlayersInGame() {
        return game.players();
    }

    public String getName() {
        return name;
    }

    public void clearAllCards() {
        clearCardSlots();
        clearReceivedCards();
        playerUI.clearAllCardsOnScreen();
    }

    public void updateOpponentHUDForNewRound() {
        playerUI.updateOpponentHUDForNewRound();
    }

    private void clearReceivedCards() {
        for (int receivedCardNumber = 0; receivedCardNumber < numberOfReceivedCards(); receivedCardNumber++) {
            receivedCards[receivedCardNumber] = null;
        }
    }

    public void clearCardSlots() {
        for (int slotNumber = 0; slotNumber < numberOfCardSlots(); slotNumber++) {
            cardSlots[slotNumber] = null;
        }
    }

    public void setupCardsForRoundExecution() {
        clearReceivedCards();
        playerUI.setupCardsForRoundExecution();
    }

    public void clearCardSlotsOnScreen() {
        playerUI.clearCardSlotCardsOnScreen();
    }
}
