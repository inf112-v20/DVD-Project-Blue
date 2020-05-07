package inf112.RoboRally.app.models.game.executors;

import inf112.RoboRally.app.models.game.Player;
import inf112.RoboRally.app.models.game.boardelements.IElement;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BoardElementRegistrationExecutor {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private CountDownLatch countDownLatch;
    private Player[] players;
    private AtomicInteger slotNumber;
    private AtomicInteger iterator = new AtomicInteger(0);
    private IElement[] boardElements;


    public BoardElementRegistrationExecutor(Player[] players, int slotNumber, IElement[] boardElements, CountDownLatch countDownLatch) {
        this.players = players;
        this.slotNumber = new AtomicInteger(slotNumber);
        this.boardElements = boardElements;
        this.countDownLatch = countDownLatch;
    }

    public void executeBoardElements() {
        final Runnable boardExec = () -> {
            System.out.println("---------- " + (iterator.get()+1) + " element performing ----------");
            IElement effect = boardElements[iterator.get()];
            for (Player player: players) {
                if (effect.inEffectForSlotNumber(slotNumber.get()))
                    effect.effectRobotAfterCardExec(player.robot());
            }
            if (iterator.incrementAndGet() == boardElements.length){
                countDownLatch.countDown();
                scheduler.shutdown();
            }
        };
        scheduler.scheduleAtFixedRate(boardExec, 1000, 500, TimeUnit.MILLISECONDS);
    }

}
