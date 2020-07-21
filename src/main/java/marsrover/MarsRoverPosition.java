package marsrover;


public class MarsRoverPosition {
    private Coordinates coordinates;
    private Direction direction;

    public MarsRoverPosition(int coordinatesX, int coordinatesY, String direction) {
        this.coordinates = new Coordinates(coordinatesX, coordinatesY);
        this.direction = Direction.fromShortName(direction);
    }

    public int getCoordinatesX() {
        return coordinates.getCoordinatesX();
    }

    public int getCoordinatesY() {
        return coordinates.getCoordinatesY();
    }

    public String getDirectionShortName() {
        return direction.getShortName();
    }

    public void move() {
        String directionShortName = direction.getShortName();
        if (directionShortName.equals(Direction.NORTH.getShortName())) {
            coordinates.coordinatesY++;
        } else if (directionShortName.equals(Direction.EAST.getShortName())) {
            coordinates.coordinatesX++;
        } else if (directionShortName.equals(Direction.WEST.getShortName())) {
            coordinates.coordinatesX--;
        } else if (directionShortName.equals(Direction.SOUTH.getShortName())) {
            coordinates.coordinatesY--;
        }
    }

    public void turnLeft() {
        direction = direction.leftDirection();
    }

    public void turnRight() {
        direction = direction.rightDirection();
    }

}
