package inf112.RoboRally.app.models.game;

import inf112.RoboRally.app.models.cards.ICard;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CardExecutor {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ArrayList<ICard> cards;
    private AtomicInteger iterator = new AtomicInteger(0);

    public CardExecutor(ArrayList<ICard> cards) {
        this.cards = cards;
    }

    public void executeCards() {
        Runnable cardExec = () -> {
            ICard card = cards.get(iterator.get());
            card.moveRobot(card.getPlayer().robot());
            if (iterator.incrementAndGet() == cards.size())
                scheduler.shutdown();
        };
        final ScheduledFuture<?> execHandle = scheduler.scheduleAtFixedRate(cardExec, 1, 1, TimeUnit.SECONDS);
    }

}
