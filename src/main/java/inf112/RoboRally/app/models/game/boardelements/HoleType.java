package inf112.RoboRally.app.models.game.boardelements;

public enum HoleType {
    HOLE {
        @Override
        public int getTileId() {
            return 4;
        }
    };
    public abstract int getTileId();
}
