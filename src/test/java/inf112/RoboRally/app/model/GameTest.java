package inf112.RoboRally.app.model;

import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.board.VaultAssault;
import inf112.RoboRally.app.models.game.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private SinglePlayerSettingsController settings;

    @Before
    public void setUp() {
        // constructor without maploader, only for testing purposes, 4 players on the board
        settings = new SinglePlayerSettingsController();
        game = new Game(settings);
    }

    @Test
    public void constructorTest() {
        assertEquals(true, game.getBoard() instanceof VaultAssault);
    }


}
