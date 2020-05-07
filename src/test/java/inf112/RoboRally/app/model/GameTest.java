//package inf112.RoboRally.app.model;
//
//import inf112.RoboRally.app.controllers.MapChoiceControllers.SinglePlayerSettingsController;
//import inf112.RoboRally.app.models.board.ChopShopChallenge;
//import inf112.RoboRally.app.models.board.Tricksy;
//import inf112.RoboRally.app.models.board.VaultAssault;
//import inf112.RoboRally.app.models.game.Game;
//import inf112.RoboRally.app.models.game.Player;
//import inf112.RoboRally.app.models.robot.Pos;
//import inf112.RoboRally.app.models.robot.Robot;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class GameTest {
//
//    private Game game;
//    private SinglePlayerSettingsController settingsController;
//
//    @Before
//    public void setUp() {
//        settingsController = new SinglePlayerSettingsController();
//        for (int i = 0; i < 6; i++)
//            settingsController.choosePlayerCount();
//        game = new Game(settingsController);
//    }
//
//    @Test
//    public void choosingDifferentMaps() {
//        SinglePlayerSettingsController settingsController = new SinglePlayerSettingsController();
//        for (int i = 0; i < 2; i++)
//            settingsController.chooseMap();
//        Game gameTest1 = new Game(settingsController);
//        assertEquals(true, gameTest1.getBoard() instanceof ChopShopChallenge);
//        for (int i = 0; i < 5; i++)
//            settingsController.chooseMap();
//        Game gameTest2 = new Game(settingsController);
//        assertEquals(true, gameTest2.getBoard() instanceof Tricksy);
//    }
//
//    @Test
//    public void choosingPlayerCount() {
//        // player count is chosen in the @Before
//        assertEquals(8, game.players().length);
//    }
//
//    @Test
//    public void defaultMapChoice() {
//        assertEquals(true, game.getBoard() instanceof VaultAssault);
//    }
//
//    @Test
//    public void playerInitialization() {
//        Player[] players = game.players();
//        for (int nPlayer = 0; nPlayer < players.length; nPlayer++) {
//            assertEquals(nPlayer, players[nPlayer].getPlayerNumber());
//        }
//    }
//
//    @Test
//    public void playerGettingDealtCardsWhenGameIsInitialized() {
//
//    }
//
//    @Test
//    public void robotInitializationTest() {
//        Player[] players = game.players();
//        for (int nPlayer = 0; nPlayer < players.length; nPlayer++) {
//            Player player = players[nPlayer];
//            Robot robot = player.robot();
//            assertEquals(10, robot.getHP());
//        }
//    }
//
//    @Test
//    public void robotStartPositionInGame() {
//        Player[] players = game.players();
//        for (int nPlayer = 0; nPlayer < players.length; nPlayer++) {
//            Player player = players[nPlayer];
//            Robot robot = player.robot();
//            Pos pos = settingsController.getMap().getRobotStartingPos(nPlayer);
//            assertEquals(pos, robot.position());
//        }
//    }
//
//
//
//}
