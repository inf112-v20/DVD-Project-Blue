package inf112.RoboRally.app.models.game.boardelements.onethreefivepusher;

public enum OneThreeFivePusherType {

    PUSH_DOWN {
        @Override
        public int getTileId() {
            return 113;
        }
    },
    PUSH_UP {
        @Override
        public int getTileId() {
            return 114;
        }
    },
    PUSH_LEFT {
        @Override
        public int getTileId() {
            return 122;
        }
    },
    PUSH_RIGHT {
        @Override
        public int getTileId() {
            return 121;
        }
    };
    public abstract int getTileId();
}
