package inf112.RoboRally.app.models.game.boardelements.laserbeam;

public enum LaserBeamType {
    SINGLE_LASER_VERTICAL {
        @Override
        public int getTileId() {
            return 137;
        }
    },
    SINGLE_LASER_HORIZONTAL {
        @Override
        public int getTileId() {
            return 138;
        }
    },
    SINGLE_LASER_CROSS {
        @Override
        public int getTileId() {
            return 139;
        }
    },
    DOUBLE_LASER_VERTICAL {
        @Override
        public int getTileId() {
            return 129;
        }
    },
    DOUBLE_LASER_HORIZONTAL {
        @Override
        public int getTileId() {
            return 130;
        }
    },
    DOUBLE_LASER_CROSS {
        @Override
        public int getTileId() {
            return 131;
        }
    };
    public abstract int getTileId();
}
