package inf112.RoboRally.app.models.game.boardelements.cog;

public enum CogType {
    ROTATE_RIGHT {
        @Override
        public int getTileId() {
            return 5;
        }
    },
    ROTATE_LEFT {
        @Override
        public int getTileId() {
            return 6;
        }
    };
    public abstract int getTileId();
}
