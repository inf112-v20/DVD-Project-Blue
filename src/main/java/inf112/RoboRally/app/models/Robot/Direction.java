package inf112.RoboRally.app.models.Robot;
/*
Enum class direction defines the directions in the game.
 */
public enum Direction {
    DOWN {
        public Direction rotateLeft() {
            return RIGHT;
        }
        public Direction rotateRight() {
            return LEFT;
        }
        // the corresponding direction of a cell holding the player in the view
        public int CellDirectionNumber() {
            return 2;
        }
    },
    LEFT {
        public Direction rotateLeft() {
            return DOWN;
        }
        public Direction rotateRight() {
            return UP;
        }
        // the corresponding direction of a cell holding the player in the view
        public int CellDirectionNumber() {
            return 1;
        }
    },
    UP {
        public Direction rotateLeft() {
            return LEFT;
        }
        public Direction rotateRight() {
            return RIGHT;
        }
        // the corresponding direction of a cell holding the player in the view
        public int CellDirectionNumber() {
            return 4;
        }

    },
    RIGHT {
        public Direction rotateLeft() {
            return UP;
        }
        public Direction rotateRight() {
            return DOWN;
        }
        // the corresponding direction of a cell holding the player in the view
        public int CellDirectionNumber() {
            return 3;
        }
    };

    public abstract Direction rotateLeft();
    public abstract Direction rotateRight();
    public abstract int CellDirectionNumber();
}

