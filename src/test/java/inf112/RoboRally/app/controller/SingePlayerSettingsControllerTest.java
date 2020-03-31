package inf112.RoboRally.app.controller;

import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
import inf112.RoboRally.app.models.board.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*
Tests class that controls choice of amount of players and map.
Note: not all maps are implemented. Implemented maps can be seen in maplist controller class.
 */
public class SingePlayerSettingsControllerTest {

    private SinglePlayerSettingsController settings;

    @Before
    public void setUp() {
        settings = new SinglePlayerSettingsController();
    }

    @Test
    public void defaultSettingsTest() {
        Board board = settings.getMap();
        assertEquals(true, board instanceof VaultAssault);
        assertEquals(2, settings.getPlayerCount());
    }


    @Test
    public void changingAmountOfPlayers() {
        //increments amount of players one player at a time
        for (int i = 0; i < 3; i++)
            settings.choosePlayerCount();
        assertEquals(5, settings.getPlayerCount());
    }

    @Test
    public void amountOfPlayerMaxBound() {
        // eight is max amount of players
        // incrementing amount of players more than eight times will wrap back around to default player count
        for (int i = 0; i < 10; i++)
            settings.choosePlayerCount();
        assertEquals(5, settings.getPlayerCount());
    }

    @Test
    public void changingMapChoice() {
        for (int i = 0; i < 3; i++)
            settings.chooseMap();
        Board board = settings.getMap();
        assertEquals(true, board instanceof DizzyDash);
        for (int i = 0; i < 3; i++)
            settings.chooseMap();
        Board secondBoard = settings.getMap();
        assertEquals(true, secondBoard instanceof RobotStew);
        for (int i = 0; i < 2; i++)
            settings.chooseMap();
        Board thirdBoard = settings.getMap();
        assertEquals(true, thirdBoard instanceof WhirlwindTour);

    }

    @Test
    public void changingMapChoiceMaxBound() {
        for (int i = 0; i < 9; i++)
            settings.chooseMap();
        Board board = settings.getMap();
        // wraps around to default choice when user iterates to next board choice from the last board choice
        assertEquals(true, board instanceof VaultAssault);
    }


}
