package inf112.RoboRally.app.models.game.boardelements;

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
    };
    public abstract int getTileId();
}
