package inf112.RoboRally.app.models.game.boardelements.flag;

public enum FlagType {
    FIRST_FLAG {
        @Override
        public int getTileId() {
            return 73;
        }
    },
    SECOND_FLAG {
        @Override
        public int getTileId() {
            return 74;
        }
    },
    THIRD_FLAG {
        @Override
        public int getTileId() {
            return 75;
        }
    };
    public abstract int getTileId();
}
