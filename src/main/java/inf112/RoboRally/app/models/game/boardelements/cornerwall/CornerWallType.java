package inf112.RoboRally.app.models.game.boardelements.cornerwall;

public enum CornerWallType {
    TOP_RIGHT {
        public int getTileId() {
            return 98;
        }
    },
    TOP_LEFT {
        public int getTileId() {
            return 97;
        }
    },
    BOTTOM_RIGHT {
        public int getTileId() {
            return 106;
        }
    },
    BOTTOM_LEFT {
        public int getTileId() {
            return 105;
        }
    };
    public abstract int getTileId();
}
