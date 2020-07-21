package marsrover;

import java.util.List;

public class MarsRover {
    private boolean backFlag;
    private boolean fastFlag;
    private MarsRoverPosition marsRoverPosition;

    public MarsRover(MarsRoverPosition marsRoverPosition) {
        this.marsRoverPosition = marsRoverPosition;
    }

    public boolean isBackFlag() {
        return backFlag;
    }

    public boolean isFastFlag() {
        return fastFlag;
    }

    public MarsRoverPosition getMarsRoverPosition() {
        return marsRoverPosition;
    }

    public MarsRoverPosition receive(List<Command> commands) {
        commands.forEach(this::receiveSingleCommand);
        return getMarsRoverPosition();
    }

    private void receiveSingleCommand(Command command) {
        if (Command.BACK == command) {
            backFlag = backFlag ? false : true;
        }

        if (Command.FAST == command) {
            fastFlag = fastFlag ? false : true;
        }

        if (Command.MOVE == command) {
            if (backFlag && !fastFlag) {
                controllerMoveCommandWIthBackFlag();
            } else if (!backFlag && fastFlag) {
                controllerMoveCommandWIthFastFlag();
            } else if (backFlag && fastFlag) {
                controllerMoveCommandWIthBackAndFastFlag();
            } else {
                controllerMoveCommand();
            }
        }

        if (Command.TURN_LEFT == command) {
            if (!backFlag && fastFlag) {
                controllerTurnLeftCommandWIthFastFlag();
            } else if (backFlag && fastFlag) {
                controllerTurnLeftCommandWIthBackAndFastFlag();
            } else {
                controllerTurnLeftCommand();
            }
        }

        if (Command.TURN_RIGHT == command) {
            if (!backFlag && fastFlag) {
                controllerTurnRightCommandWIthFastFlag();
            } else if (backFlag && fastFlag) {
                controllerTurnRightCommandWIthBackAndFastFlag();
            } else {
                controllerTurnRightCommand();
            }
        }

    }

    private void controllerMoveCommand() {
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

    private void controllerMoveCommandWIthBackFlag() {
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

    private void controllerMoveCommandWIthFastFlag() {
        controllerMoveCommand();
        controllerMoveCommand();
    }

    private void controllerMoveCommandWIthBackAndFastFlag() {
        controllerMoveCommandWIthBackFlag();
        controllerMoveCommandWIthBackFlag();
    }

    private void controllerTurnLeftCommand() {
        marsRoverPosition.direction = marsRoverPosition.direction.leftDirection();
    }

    private void controllerTurnLeftCommandWIthFastFlag() {
        controllerMoveCommand();
        controllerTurnLeftCommand();
    }

    private void controllerTurnLeftCommandWIthBackAndFastFlag() {
        controllerMoveCommandWIthBackFlag();
        controllerTurnLeftCommand();
    }

    private void controllerTurnRightCommand() {
        marsRoverPosition.direction = marsRoverPosition.direction.rightDirection();
    }

    private void controllerTurnRightCommandWIthFastFlag() {
        controllerMoveCommand();
        controllerTurnRightCommand();
    }

    private void controllerTurnRightCommandWIthBackAndFastFlag() {
        controllerMoveCommandWIthBackFlag();
        controllerTurnRightCommand();
    }
}
