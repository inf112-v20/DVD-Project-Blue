package inf112.RoboRally.app.models.game.executors;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.cards.SortCardByPriority;
import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.Timer;
import inf112.RoboRally.app.models.game.boardelements.IElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectCardFromSlotExecutor {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private AtomicInteger slotNumber = new AtomicInteger(0);
    private final int NUMBER_OF_SLOTS = 5;
    private Player[] players;
    private IElement[] boardElements;
    private Timer timer; // access to timer in game for reset when round execution is complete

    public CollectCardFromSlotExecutor(Player[] players, IElement[] boardElements, Timer timer) {
        this.players = players;
        this.boardElements = boardElements;
        this.timer = timer;
    }


    public void CardChoiceRoundExecutor() {
        Runnable collectCards = () -> {

            CountDownLatch cardExecutionLatch = new CountDownLatch(1);

            ArrayList<ICard> cards = collectCardsFromSlotNumber(slotNumber.get());

            if (cards == null)
                scheduler.shutdown(); // no more cards in slots

            sortCardsByPriority(cards);

            CardMoveExecutor cardExecutor = new CardMoveExecutor(cards, cardExecutionLatch);
            cardExecutor.executeCards();
            System.out.println("--------------- " + (slotNumber.get() + 1) + " slot performing ------------------");
            try {
                cardExecutionLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            CountDownLatch boardElementLatch = new CountDownLatch(1);

            BoardElementExecutor boardElementExecutor = new BoardElementExecutor(players, slotNumber.get(), boardElements, boardElementLatch);
            boardElementExecutor.executeBoardElements();

            try {
                boardElementLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (slotNumber.incrementAndGet() == NUMBER_OF_SLOTS) {
                timer.reset();
                scheduler.shutdown();
            }
        };
        scheduler.scheduleAtFixedRate(collectCards, 500, 5000, TimeUnit.MILLISECONDS);
    }


    private void sortCardsByPriority(ArrayList<ICard> allCardsFromSlots) {
        Collections.sort(allCardsFromSlots, new SortCardByPriority());
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
        if (cards.isEmpty()) return null; // no more card choices left to execute
        return cards;
    }



}
