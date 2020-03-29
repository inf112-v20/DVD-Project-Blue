package inf112.RoboRally.app.models.cards;

import java.util.Random;
/*
Class that randomly creates cards. The probability is equal for all types of cards in the game.
The following cards are created: three steps forward, two steps forward, one step forward,
reverse, rotate right, rotate left, uturn.
Each cards priority is generated randomly.
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
