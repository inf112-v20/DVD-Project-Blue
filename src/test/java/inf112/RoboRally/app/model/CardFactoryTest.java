package inf112.RoboRally.app.model;

import inf112.RoboRally.app.models.cards.CardFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
            assertNotNull(cardFactory.randomCard());
            assertTrue(cardFactory.randomCard().priority() >= 0 && cardFactory.randomCard().priority() <= 2000);
            assertNotNull(cardFactory.randomCard().getFileName());
        }

    }

}
