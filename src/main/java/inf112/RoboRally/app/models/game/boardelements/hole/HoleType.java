package inf112.RoboRally.app.models.game.boardelements.hole;

public enum HoleType {
    SINGLE_HOLE {
        @Override
        public int getTileId() {
            return 4;
        }
    };
    public abstract int getTileId();
}
