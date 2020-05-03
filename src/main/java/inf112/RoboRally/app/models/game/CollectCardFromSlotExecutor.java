package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.ICard;
import inf112.RoboRally.app.models.cards.SortCardByPriority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectCardFromSlotExecutor {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Player[] players;
    private AtomicInteger slotNumber = new AtomicInteger(0);
    private final AtomicInteger NUMBER_OF_SLOTS;

    public CollectCardFromSlotExecutor(Player[] players) {
        this.players = players;
        NUMBER_OF_SLOTS = new AtomicInteger(players[0].numberOfCardSlots());
    }


    public void CardChoiceRoundExecutor() {
        Runnable collectCards = () -> {

            CountDownLatch countDownLatch = new CountDownLatch(1);

            ArrayList<ICard> cards = collectCardsFromSlotNumber(slotNumber.get());

            if (cards == null)
                scheduler.shutdown(); // no more cards in slots

            sortCardsByPriority(cards);
            CardMoveExecutor cardExecutor = new CardMoveExecutor(cards, countDownLatch);
            cardExecutor.executeCards();
            System.out.println("--------------- " + (slotNumber.get() + 1) + " slot performing ------------------");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (slotNumber.incrementAndGet() == NUMBER_OF_SLOTS.get())
                scheduler.shutdown();
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

//                player.updateOpponentCardSlots(slotNumber); // not working

                cards.add(slottedCards[slotNumber]);
                slottedCards[slotNumber] = null;

            }
        }
        if (cards.isEmpty()) return null; // no more card choices left to execute
        return cards;
    }



}
