package inf112.RoboRally.app.models.game.boardelements.twofourpusher;

public enum TwoFourPusherType {
    TWO_FOUR_PUSH_UP {
        public int getTileId() {
            return 116;
        }
    },
    TWO_FOUR_PUSH_DOWN {
        public int getTileId() {
            return 115;
        }
    },
    TWO_FOUR_PUSH_RIGHT {
        public int getTileId() {
            return 123;
        }
    },
    TWO_FOUR_PUSH_LEFT {
        public int getTileId() {
            return 124;
        }
    };
    public abstract int getTileId();
}
