package inf112.RoboRally.app.models.game.boardelements.bluebelt;

public enum BlueBeltType {
    // moving in a direction
    PUSH_UP {
        @Override
        public int getTileId() {
            return 25;
        }
    },
    PUSH_DOWN {
        @Override
        public int getTileId() {
            return 34;
        }
    },
    PUSH_RIGHT {
        @Override
        public int getTileId() {
            return 26;
        }
    },
    PUSH_LEFT {
        @Override
        public int getTileId() {
            return 33;
        }
    },
    // rotating left belts
    TURN_UP_TO_LEFT {
        @Override
        public int getTileId() {
            return 10;
        }
    },
    TURN_LEFT_TO_DOWN {
        @Override
        public int getTileId() {
            return 9;
        }
    },
    TURN_DOWN_TO_RIGHT {
        @Override
        public int getTileId() {
            return 17;
        }
    },
    TURN_RIGHT_TO_UP {
        @Override
        public int getTileId() {
            return 18;
        }
    },
    // rotating right belts
    TURN_LEFT_TO_UP {
        @Override
        public int getTileId() {
            return 19;
        }
    },
    TURN_UP_TO_RIGHT {
        @Override
        public int getTileId() {
            return 11;
        }
    },
    TURN_RIGHT_TO_DOWN {
        @Override
        public int getTileId() {
            return 12;
        }
    },
    TURN_DOWN_TO_LEFT {
        @Override
        public int getTileId() {
            return 20;
        }
    },
    // belts that come from two sides and become one
    LEFT_AND_RIGHT_TO_DOWN {
        @Override
        public int getTileId() {
            return 21;
        }
    },
    LEFT_AND_RIGHT_TO_UP {
        @Override
        public int getTileId() {
            return 22;
        }
    },
    UP_AND_DOWN_TO_RIGHT {
        @Override
        public int getTileId() {
            return 13;
        }
    },
    UP_AND_DOWN_TO_LEFT {
        @Override
        public int getTileId() {
            return 14;
        }
    },
    // belts that go in one direction and has a left turn into them
    DOWN_FROM_LEFT {
        @Override
        public int getTileId() {
            return 27;
        }
    },
    RIGHT_FROM_DOWN {
        @Override
        public int getTileId() {
            return 35;
        }
    },
    UP_FROM_RIGHT {
        @Override
        public int getTileId() {
            return 36;
        }
    },
    LEFT_FROM_UP {
        @Override
        public int getTileId() {
            return 28;
        }
    },
    // belts that go in one direction and has a right turn into them
    RIGHT_FROM_UP {
        @Override
        public int getTileId() {
            return 29;
        }
    },
    DOWN_FROM_RIGHT {
        @Override
        public int getTileId() {
            return 30;
        }
    },
    LEFT_FROM_DOWN {
        @Override
        public int getTileId() {
            return 38;
        }
    },
    UP_FROM_LEFT {
        @Override
        public int getTileId() {
            return 37;
        }
    };
    public abstract int getTileId();
}
