//package inf112.RoboRally.app;
//
//import inf112.RoboRally.app.models.board.Board;
//import inf112.RoboRally.app.models.board.Direction;
//import inf112.RoboRally.app.models.board.Position;
//import io.cucumber.java8.En;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class StepDefinitions implements En {
//    private ArrayList<String> robots;
//    private Board board;
//
//    public StepDefinitions() {
//        Given("an empty {int}x{int} board", (Integer width, Integer height) -> {
//            // TODO This line belongs in a test-setup function (it's not tied to any specific step).
//            this.robots = new ArrayList<>();
//            this.board = new Board(width, height, 4);
//        });
//
//        Given("a {int}x{int} board with the following objects:",
//                (Integer width, Integer height, io.cucumber.datatable.DataTable dataTable) -> {
//                    throw new io.cucumber.java8.PendingException();
//                });
//
//        Given("a robot {string} placed at \\({int}, {int})", (String name, Integer x, Integer y) -> {
//            int robotId = addRobot(name);
//            board.placeRobot(robotId, new Position(x, y), Direction.RIGHT);
//        });
//
//        // TODO Use the `Direction` type for the facing direction (requires writing some cucumber-glue code, for
//        // automatic conversion from String)
//        Given("a robot {string} placed at \\({int}, {int}), facing {word}",
//                (String name, Integer x, Integer y, String facing) -> {
//                    int robotId = addRobot(name);
//                    board.placeRobot(robotId, new Position(x, y), Direction.RIGHT);
//                });
//
//        Then("robot {string} moves forward", (String name) -> {
//            int robotId = getRobot(name);
//            board.moveRobot(robotId, false);
//        });
//
//        Then("robot {string} has position \\({int}, {int})", (String name, Integer x, Integer y) -> {
//            int robotId = getRobot(name);
//            assertEquals(board.getRobot(robotId).position, new Position(x, y));
//        });
//
//        Then("robot {string} does not exist", (String name) -> {
//            int robotId = getRobot(name);
//            assertNull(board.getRobot(robotId));
//        });
//
//
//
//    }
//
//    // Helper functions for tests
//
//    private int addRobot(String name) {
//        int nextIndex = this.robots.size();
//        robots.add(name);
//        return nextIndex;
//    }
//
//    private int getRobot(String name) {
//        return robots.indexOf(name);
//    }
//}
