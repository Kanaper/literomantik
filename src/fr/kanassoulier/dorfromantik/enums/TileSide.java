package fr.kanassoulier.dorfromantik.enums;

public enum TileSide {
  NORTH, NORTH_EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, NORTH_WEST;

  public TileSide opposite() {
    switch (this) {
      case NORTH:
        return SOUTH;
      case NORTH_EAST:
        return SOUTH_WEST;
      case SOUTH_EAST:
        return NORTH_WEST;
      case SOUTH:
        return NORTH;
      case SOUTH_WEST:
        return NORTH_EAST;
      case NORTH_WEST:
        return SOUTH_EAST;
      default:
        throw new IllegalArgumentException("Unknown TileSide: " + this);
    }
  }
}
