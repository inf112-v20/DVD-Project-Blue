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
            return 45;
        }
    },
    LEFT_AND_RIGHT_TO_UP {
        @Override
        public int getTileId() {
            return 46;
        }
    },
    UP_AND_DOWN_TO_RIGHT {
        @Override
        public int getTileId() {
            return 53;
        }
    },
    UP_AND_DOWN_TO_LEFT {
        @Override
        public int getTileId() {
            return 54;
        }
    },
    YELLOW_1 {
        @Override
        public int getTileId() {
            return 59;
        }
    },
    YELLOW_2 {
        @Override
        public int getTileId() {
            return 60;
        }
    },
    YELLOW_3 {
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
    YELLOW_5 {
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
    YELLOW_8 {
        @Override
        public int getTileId() { return 70; }
    };
    public abstract int getTileId();
}
