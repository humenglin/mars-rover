package marsrover;

public enum Command {
    MOVE("M"),
    TURN_LEFT("L"),
    TURN_RIGHT("R"),
    BACK("B"),
    FAST("F");

    private String shortName;

    Command(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static Command form(String shortName) {
        for (Command command : Command.values()) {
            if (command.getShortName().equals(shortName)) {
                return command;
            }
        }

        throw new IllegalArgumentException("未知的命令：" + shortName);
    }
}
