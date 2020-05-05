package inf112.RoboRally.app.models.game.boardelements.hole;

public enum HoleType {
    SINGLE_HOLE {
        @Override
        public int getTileId() {
            return 4;
        }
    },
    BIG_HOLE_LEFT_TOP {
        @Override
        public int getTileId() {
            return 7;
        }
    },
    BIG_HOLE_RIGHT_TOP {
        @Override
        public int getTileId() {
            return 8;
        }
    },
    BIG_HOLE_LEFT_BOTTOM {
        @Override
        public int getTileId() {
            return 15;
        }
    },
    BIG_HOLE_RIGHT_BOTTOM {
        @Override
        public int getTileId() {
            return 16;
        }
    },
    BIG_HOLE_EXTENSION {
        @Override
        public int getTileId() {
            return 71;
        }
    },
    HOLE_LEFT_TOP {
        @Override
        public int getTileId() {
            return 23;
        }
    },
    HOLE_LEFT_TOP_2 {
        @Override
        public int getTileId() {
            return 24;
        }
    },
    HOLE_LEFT_TOP_3 {
        @Override
        public int getTileId() {
            return 31;
        }
    },
    HOLE_RIGHT_TOP {
        @Override
        public int getTileId() {
            return 32;
        }
    },
    HOLE_RIGHT_TOP_2 {
        @Override
        public int getTileId() {
            return 39;
        }
    },
    HOLE_RIGHT_TOP_3 {
        @Override
        public int getTileId() {
            return 40;
        }
    },
    HOLE_RIGHT_BOTTOM {
        @Override
        public int getTileId() {
            return 47;
        }
    },
    HOLE_RIGHT_BOTTOM_2 {
        @Override
        public int getTileId() {
            return 48;
        }
    },
    HOLE_RIGHT_BOTTOM_3 {
        @Override
        public int getTileId() {
            return 56;
        }
    },
    HOLE_LEFT_BOTTOM {
        @Override
        public int getTileId() {
            return 55;
        }
    },
    HOLE_LEFT_BOTTOM_2 {
        @Override
        public int getTileId() {
            return 63;
        }
    },
    HOLE_LEFT_BOTTOM_3 {
        @Override
        public int getTileId() {
            return 64;
        }
    };
    public abstract int getTileId();
}