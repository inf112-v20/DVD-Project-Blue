package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.CardFactory;
import inf112.RoboRally.app.models.cards.ICard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardFactoryTest {

    private CardFactory cardFactory;

    @Before
    public void setUp() {
        cardFactory = new CardFactory();
    }

    @Test
    public void testCardGeneration() {
        int numberOfGenerations = 50;
        for (int i = 0; i < numberOfGenerations; i++) {
            assertEquals(true, cardFactory.randomCard() instanceof ICard);
            assertEquals(true, cardFactory.randomCard().priority() >= 0 && cardFactory.randomCard().priority() <= 2000);
            assertEquals(true, cardFactory.randomCard().getFileName() instanceof String);
        }

    }

}
