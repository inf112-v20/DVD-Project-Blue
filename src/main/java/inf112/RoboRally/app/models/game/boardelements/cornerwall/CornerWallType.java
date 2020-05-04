package inf112.RoboRally.app.models.game.boardelements.cornerwall;

public enum CornerWallType {
    TOPRIGHT {
        public int getTileId() {
            return 98;
        }
    },
    TOPLEFT {
        public int getTileId() {
            return 97;
        }
    },
    BOTTOMRIGHT {
        public int getTileId() {
            return 106;
        }
    },
    BOTTOMLEFT {
        public int getTileId() {
            return 105;
        }
    };
    public abstract int getTileId();
}
