package marsrover;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommandFactoryTest {
    CommandFactory commandFactory = new CommandFactory();

    @Test
    public void should_return_command_M_when_getCommands_give_short_name_M() {
        assertThat(commandFactory.getCommands("M"), is(Arrays.asList(Command.MOVE)));
    }

    @Test
    public void should_return_command_L_when_getCommands_give_short_name_L() {
        assertThat(commandFactory.getCommands("L"), is(Arrays.asList(Command.TURN_LEFT)));
    }

    @Test
    public void should_return_command_R_when_getCommands_give_short_name_R() {
        assertThat(commandFactory.getCommands("R"), is(Arrays.asList(Command.TURN_RIGHT)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_when_getCommands_give_short_name_A() {
        commandFactory.getCommands("A");
    }

    @Test
    public void should_return_command_MLR_when_getCommands_give_short_name_MLR() {
        assertThat(commandFactory.getCommands("MLR"), is(Arrays.asList(Command.MOVE, Command.TURN_LEFT, Command.TURN_RIGHT)));
    }

    @Test
    public void should_return_command_B_when_getCommands_give_short_name_B() {
        assertThat(commandFactory.getCommands("B"), is(Arrays.asList(Command.BACK)));
    }

    @Test
    public void should_return_command_F_when_getCommands_give_short_name_F() {
        assertThat(commandFactory.getCommands("F"), is(Arrays.asList(Command.FAST)));
    }

    @Test
    public void should_return_command_K_when_getCommands_give_short_name_BB() {
        assertThat(commandFactory.getCommands("BB"), is(Arrays.asList(Command.KEEP)));
    }

    @Test
    public void should_return_command_KB_when_getCommands_give_short_name_BBB() {
        assertThat(commandFactory.getCommands("BBB"), is(Arrays.asList(Command.KEEP, Command.BACK)));
    }
}
