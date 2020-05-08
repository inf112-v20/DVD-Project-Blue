package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.game.boardelements.IRegistrationPhaseElement;
import inf112.RoboRally.app.models.game.executors.RoundPhaseExecutor;


public class Round {

    private CardFactory cardFactory = new CardFactory();
    private Player[] players;
    private int roundNumber = 0; // only used as debug message for system.out

    public Round(Player[] players) {
        this.players = players;
    }

    public void dealCardsAndBotsChooseCards() {
        dealCards();
        botPlayersChooseCards();
    }

    private void botPlayersChooseCards() {
        for (Player player: players) {
            if (player.isBotPlayer())
                player.botPlayerChooseCardsForCardSlots();
        }
    }

    public void dealCards () {
        for (Player player : players) {
            for (int i = 0; i < player.numberOfReceivedCards(); i++) {
                ICard card = cardFactory.randomCard();
                player.receiveCard(i, card);
            }
        }

    }



    public void executeRound(Timer timer, IRegistrationPhaseElement[] registrationPhaseEffects) {

        System.out.println("----------------------------------------- ROUND "+(++roundNumber)+" ------------------------------------------" );

        activePowerDownIfPlayerAnnouncesPowerDown();                      // power down robots that have announced powerdown
        updateRobotsThatDiedThePreviousRound();                           // making all robots that died the previous round alive again
        if (checkForWinner()) return;
        RoundPhaseExecutor cardChoiceExecutor = new RoundPhaseExecutor(players, registrationPhaseEffects, timer);
        cardChoiceExecutor.roundPhaseExecutor();

    }

    public boolean checkForWinner() {
        int playersAlive = 0;
        for (Player player: players) {
            if (player.robot().livesLeft() > 0) playersAlive++;
            if (player.robot().isWinner()) return true; // robot is registered with three flags
        }
        if (playersAlive == 1) { // only one player alive, we have a winner
            for (Player player: players) {
                if (player.robot().livesLeft() > 0) {
                    player.robot().setToWinner();
                    return true;
                }
            }
        }
        return false;
    }


    public void activePowerDownIfPlayerAnnouncesPowerDown() {
        for (Player player: players) {
            if (player.robot().isPoweredDown()) {
                player.clearCardSlots();
                player.robot().reset(false);
            }
        }


    }

    public void updateRobotsThatDiedThePreviousRound() {
        for (Player player: players) {
            if (player.robot().isDead() && player.robot().livesLeft() > 0)
                player.robot().setAlive();
        }
    }



}



