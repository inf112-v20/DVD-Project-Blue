package inf112.RoboRally.app.models.board;

public enum Direction {
    DOWN {
        public Direction rotateLeft() {
            return RIGHT;
        }
        public Direction rotateRight() {
            return LEFT;
        }
    },
    LEFT {
        public Direction rotateLeft() {
            return DOWN;
        }
        public Direction rotateRight() {
            return UP;
        }
    },
    UP {
        public Direction rotateLeft() {
            return LEFT;
        }
        public Direction rotateRight() {
            return RIGHT;
        }
    },
    RIGHT {
        public Direction rotateLeft() {
            return UP;
        }
        public Direction rotateRight() {
            return DOWN;
        }
    };

    public abstract Direction rotateLeft();
    public abstract Direction rotateRight();
}

