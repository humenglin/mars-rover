package marsrover;

import java.util.List;

public class MarsRoverService {
    private MarsRover marsRover;
    private CommandFactory commandFactory;

    public MarsRoverService(MarsRover marsRover) {
        this.marsRover = marsRover;
        commandFactory = new CommandFactory();
    }

    public MarsRoverPosition receive(String commandsStr) {
        List<Command> commands = commandFactory.getCommands(commandsStr);
        return marsRover.receive(commands);
    }
}
