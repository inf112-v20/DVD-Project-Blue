package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.ICard;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CardMoveExecutor {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ArrayList<ICard> cards;
    private AtomicInteger iterator = new AtomicInteger(0);
    private CountDownLatch countDownLatch;

    public CardMoveExecutor(ArrayList<ICard> cards, CountDownLatch countDownLatch) {
        this.cards = cards;
        this.countDownLatch = countDownLatch;
    }

    public void executeCards() {
        final Runnable cardExec = () -> {
            ICard card = cards.get(iterator.get());
            System.out.println("player" + card.getPlayer().getPlayerNumber() + " is moving with priority : " + card.priority()+" , "+card.getFileName());
            card.moveRobot(card.getPlayer().robot());
            if (iterator.incrementAndGet() == cards.size()) {
                countDownLatch.countDown();
                scheduler.shutdown();
            }
        };
        scheduler.scheduleAtFixedRate(cardExec, 0, 3, TimeUnit.SECONDS);
    }


}
