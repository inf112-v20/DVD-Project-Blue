package inf112.RoboRally.app.models.game.boardelements.yellowbelt;

public enum YellowBeltType {
    PUSH_UP {
        @Override
        public int getTileId() {
            return 57;
        }
    },
    PUSH_DOWN {
        @Override
        public int getTileId() {
            return 66;
        }
    },
    PUSH_RIGHT {
        @Override
        public int getTileId() {
            return 58;
        }
    },
    PUSH_LEFT {
        @Override
        public int getTileId() {
            return 65;
        }
    },
    // rotating left belts
    ROTATE_LEFT_TO_UP {
        @Override
        public int getTileId() {
            return 50;
        }
    },
    ROTATE_LEFT_TO_LEFT {
        @Override
        public int getTileId() {
            return 42;
        }
    },
    ROTATE_LEFT_TO_DOWN {
        @Override
        public int getTileId() {
            return 41;
        }
    },
    ROTATE_LEFT_TO_RIGHT {
        @Override
        public int getTileId() {
            return 49;
        }
    },
    // rotating right belts
    ROTATE_RIGHT_TO_UP {
        @Override
        public int getTileId() {
            return 51;
        }
    },
    ROTATE_RIGHT_TO_RIGHT {
        @Override
        public int getTileId() {
            return 43;
        }
    },
    ROTATE_RIGHT_TO_DOWN {
        @Override
        public int getTileId() {
            return 44;
        }
    },
    ROTATE_RIGHT_TO_LEFT {
        @Override
        public int getTileId() {
            return 52;
        }
    },
    LEFT_TURN_INTO_DOWN {
        @Override
        public int getTileId() {
            return 59;
        }
    },
    LEFT_TURN_INTO_LEFT {
        @Override
        public int getTileId() {
            return 60;
        }
    },
    LEFT_TURN_INTO_RIGHT {
        @Override
        public int getTileId() {
            return 67;
        }
    },
    YELLOW_4 {
        @Override
        public int getTileId() {
            return 68;
        }
    },
    RIGHT_TURN_INTO_RIGHT {
        @Override
        public int getTileId() { return 61; }
    },
    YELLOW_6 {
        @Override
        public int getTileId() { return 62; }
    },
    YELLOW_7 {
        @Override
        public int getTileId() { return 69; }
    },
    RIGHT_TURN_INTO_LEFT {
        @Override
        public int getTileId() { return 70; }
    },
    YELLOW_9 {
        @Override
        public int getTileId() {
            return 45;
        }
    },
    YELLOW_10 {
        @Override
        public int getTileId() {
            return 46;
        }
    },
    YELLOW_11 {
        @Override
        public int getTileId() {
            return 53;
        }
    },
    YELLOW_12 {
        @Override
        public int getTileId() {
            return 54;
        }
    };
    public abstract int getTileId();
}
