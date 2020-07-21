package marsrover;

import java.util.Arrays;
import java.util.List;

public class MarsRover {

    private MarsRoverPosition marsRoverPosition;
    public MarsRover(MarsRoverPosition marsRoverPosition) {
        this.marsRoverPosition = marsRoverPosition;
    }

    public MarsRoverPosition getMarsRoverPosition() {
        return marsRoverPosition;
    }

    public MarsRoverPosition receive(List<Command> commands) {
        commands.forEach(this::receiveSingleCommand);
        return getMarsRoverPosition();
    }

    private void receiveSingleCommand(Command command) {
        if (Command.MOVE == command) {
            String directionShortName = marsRoverPosition.direction.getShortName();
            if (directionShortName.equals(Direction.NORTH.getShortName())) {
                marsRoverPosition.coordinatesY++;
            } else if (directionShortName.equals(Direction.EAST.getShortName())) {
                marsRoverPosition.coordinatesX++;
            } else if (directionShortName.equals(Direction.WEST.getShortName())) {
                marsRoverPosition.coordinatesX--;
            } else if (directionShortName.equals(Direction.SOUTH.getShortName())) {
                marsRoverPosition.coordinatesY--;
            }
        }

        if (Command.BACK == command) {
            String directionShortName = marsRoverPosition.direction.getShortName();
            if (directionShortName.equals(Direction.NORTH.getShortName())) {
                marsRoverPosition.coordinatesY--;
            } else if (directionShortName.equals(Direction.EAST.getShortName())) {
                marsRoverPosition.coordinatesX--;
            } else if (directionShortName.equals(Direction.WEST.getShortName())) {
                marsRoverPosition.coordinatesX++;
            } else if (directionShortName.equals(Direction.SOUTH.getShortName())) {
                marsRoverPosition.coordinatesY++;
            }
        }

        if (Command.TURN_LEFT == command) {
            marsRoverPosition.direction = marsRoverPosition.direction.leftDirection();
        }

        if (Command.TURN_RIGHT == command) {
            marsRoverPosition.direction = marsRoverPosition.direction.rightDirection();
        }

    }
}
