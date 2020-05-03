package inf112.RoboRally.app.models.game.boardelements;

public enum WallType {
    TOPSIDE {
        public int getTileId() {
            return 85;
        }
    },
    DOWNSIDE {
        public int getTileId() {
            return 86;
        }
    },
    RIGHTSIDE {
        public int getTileId() {
            return 94;
        }
    },
    LEFTSIDE {
        public int getTileId() {
            return 93;
        }
    };
    public abstract int getTileId();
}
