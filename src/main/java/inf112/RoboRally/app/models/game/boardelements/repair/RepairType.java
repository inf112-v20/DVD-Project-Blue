package inf112.RoboRally.app.models.game.boardelements.repair;

public enum RepairType {
    WRENCH {
        @Override
        public int getTileId() {
            return 2;
        }
    },
    WRENCH_AND_HAMMER {
        @Override
        public int getTileId() {
            return 3;
        }
    };
    public abstract int getTileId();
}
