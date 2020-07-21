package marsrover;


public class MarsRoverPosition {
    private int coordinatesX;
    private int coordinatesY;
    private Direction direction;

    public MarsRoverPosition(int coordinatesX, int coordinatesY, String direction) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.direction = Direction.fromShortName(direction);
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public String getDirectionShortName() {
        return direction.getShortName();
    }

    public void move() {
        String directionShortName = direction.getShortName();
        if (directionShortName.equals(Direction.NORTH.getShortName())) {
            coordinatesY++;
        } else if (directionShortName.equals(Direction.EAST.getShortName())) {
            coordinatesX++;
        } else if (directionShortName.equals(Direction.WEST.getShortName())) {
            coordinatesX--;
        } else if (directionShortName.equals(Direction.SOUTH.getShortName())) {
            coordinatesY--;
        }
    }

    public void turnLeft() {
        direction = direction.leftDirection();
    }

    public void turnRight() {
        direction = direction.rightDirection();
    }

}
