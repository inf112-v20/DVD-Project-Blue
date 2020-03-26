package inf112.RoboRally.app.models.cards;

import java.util.Random;
/*
Class that holds all the cards in the game, which will be used when dealing cards to players.
Not used at this moment.
 */
public class CardFactory {

    public ICard randomCard() {
        Random r = new Random();
        int priority = (r.nextInt(2001)/10) * 10;
        switch (r.nextInt(7)) {
            case 0:
                return new ForwardCard(3, priority);
            case 1:
                return new ForwardCard(2, priority);
            case 2:
                return new ForwardCard(1, priority);
            case 3:
                return new ReverseCard(priority);
            case 4:
                return new RotateCard(Rotation.LEFT, priority);
            case 5:
                return new RotateCard(Rotation.RIGHT, priority);
            case 6:
                return new RotateCard(Rotation.UTURN, priority);
            default:
                throw new IndexOutOfBoundsException("The card factory is not working: problem with switch statement or random number bound");
        }
    }

}
