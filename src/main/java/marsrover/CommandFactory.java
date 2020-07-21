package marsrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandFactory {

    public List<Command> getCommands(String commandsStr) {
        List<String> shortNames = Arrays.asList(commandsStr.split(""));
        List<Command> commands = new ArrayList<>();
        for (String shortName : shortNames) {
            commands.add(Command.form(shortName));
        }
        return commands;
    }
}
