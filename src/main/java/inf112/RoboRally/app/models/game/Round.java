package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.boardelements.IElement;
import inf112.RoboRally.app.models.game.executors.CollectCardFromSlotExecutor;

/*
Next delivery
 */
public class Round {

    private CardFactory cardFactory = new CardFactory();
    private Player[] players;
    private Player humanPlayer;
    private final int CARD_SLOT_AMOUNT;
    private IElement[] boardElements;
    private int roundNumber = 0; // only used for system.out

    public Round(Game game) {
        this.players = game.players();
        this.humanPlayer = game.getHumanPlayer();
        this.boardElements = game.getBoardElements().boardEffects();
        CARD_SLOT_AMOUNT = humanPlayer.numberOfCardSlots();
    }

    public void dealCardsAndBotsChooseCards() {
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
//        removeDealtCards(); // does not do anything the first round
        for (Player player : players) {
            for (int i = 0; i < player.numberOfReceivedCards(); i++) {
                ICard card = cardFactory.randomCard();
                player.receiveCard(i, card);
            }
        }

    }


    private void removeDealtCards () {
        for (Player player: players) {
            ICard[] dealtCards = player.getReceivedCards();
            for (int i = 0; i < dealtCards.length; i++) {
                dealtCards[i] = null;
            }

        }

    }


    public void executeRound(Timer timer) {
        System.out.println("----------------------------------------- ROUND "+(++roundNumber)+" ------------------------------------------" );
        updateRobotsThatWerePoweredDownPreviousRound();
        updateRobotsThatDiedThePreviousRound(); // making all robots that died the previous round alive again
        powerDownRobots();                      // power down robots that have announces powerdown
        CollectCardFromSlotExecutor cardChoiceExecutor = new CollectCardFromSlotExecutor(players, boardElements, timer);
        cardChoiceExecutor.CardChoiceRoundExecutor();


    }

    private void updateRobotsThatWerePoweredDownPreviousRound() {
        for (Player player: players) {
            player.robot().changePowerDown(false, true);
        }
    }

    private void powerDownRobots() {
        for (Player player: players) {
            if (player.robot().isPoweredDown()) {
                player.clearCardSlots();
                player.robot().reset(false);
            }
        }
    }

    private void updateRobotsThatDiedThePreviousRound() {
        for (Player player: players) {
            player.robot().setAlive();
        }
    }


    private void updateOpponentHUDCardSlotsCardsFacingUp() {
        for (Player player: players)
            player.updateOpponentCardSlots(true);
    }


}



