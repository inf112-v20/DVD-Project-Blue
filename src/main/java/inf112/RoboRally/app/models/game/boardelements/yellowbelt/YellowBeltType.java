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
    // belts that come from two sides and become one
    LEFT_AND_RIGHT_TO_DOWN {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    LEFT_AND_RIGHT_TO_UP {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    UP_AND_DOWN_TO_RIGHT {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    UP_AND_DOWN_TO_LEFT {
        @Override
        public int getTileId() {
            return 54;
        }
    },
    // belts that go in one direction and has a left turn into them
    DOWN_FROM_LEFT {
        @Override
        public int getTileId() {
            return 59;
        }
    },
    RIGHT_FROM_ABOVE {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    UP_FROM_RIGHT {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    LEFT_FROM_UP {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    // belts that go in one direction and has a right turn into them
    RIGHT_FROM_UP {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    DOWN_FROM_RIGHT {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    LEFT_FROM_DOWN {
        @Override
        public int getTileId() {
            return 0;
        }
    },
    UP_FROM_LEFT {
        @Override
        public int getTileId() {
            return 0;
        }
    };
    public abstract int getTileId();
}
