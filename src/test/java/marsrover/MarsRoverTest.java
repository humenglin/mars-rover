package marsrover;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {
    @Test
    public void should_return_x_0_y_2_and_N_when_receive_MM_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.MOVE, Command.MOVE);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(2));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
    }

    @Test
    public void should_return_x_0_y_0_and_W_when_receive_MLLMR_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.MOVE, Command.TURN_LEFT, Command.TURN_LEFT, Command.MOVE, Command.TURN_RIGHT);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0) );
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
    }

    @Test
    public void should_return_x_3_y_1_and_W_when_receive_MLLMR_command_give_mars_rover_with_init_place_x_2_y_1_E() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(2,1, "E"));

        List<Command> commands = Arrays.asList(Command.MOVE, Command.TURN_LEFT, Command.TURN_LEFT, Command.TURN_RIGHT);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(3));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1) );
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
    }

    @Test
    public void should_return_x_1_y_1_and_W_when_receive_LLM_command_give_mars_rover_with_init_place_x_2_y_1_E() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(2,1, "E"));

        List<Command> commands = Arrays.asList(Command.TURN_LEFT, Command.TURN_LEFT, Command.MOVE);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1) );
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
    }

    @Test
    public void should_return_x_0_y_1_and_N_when_receive_M_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.MOVE);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
    }

    @Test
    public void should_return_x_0_y_0_and_W_when_receive_L_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.TURN_LEFT);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
    }

    @Test
    public void should_return_x_0_y_0_and_E_when_receive_R_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.TURN_RIGHT);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("E"));
    }

    @Test
    public void should_return_x_0_y_0_and_N_and_back_is_true_when_receive_B_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.BACK);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isBackFlag(), is(true));
    }

    @Test
    public void should_return_x_1_y_0_and_N_and_back_is_true_when_receive_BM_command_give_mars_rover_with_init_place_x_1_y_1_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "N"));

        List<Command> commands = Arrays.asList(Command.BACK, Command.MOVE);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isBackFlag(), is(true));
    }

    @Test
    public void should_return_x_0_y_0_and_N_and_back_is_false_when_receive_BB_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.BACK, Command.BACK);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isBackFlag(), is(false));
    }

    @Test
    public void should_return_x_1_y_0_and_N_and_back_is_false_when_receive_BMB_command_give_mars_rover_with_init_place_x_1_y_1_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "N"));

        List<Command> commands = Arrays.asList(Command.BACK, Command.MOVE, Command.BACK);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isBackFlag(), is(false));
    }

    @Test
    public void should_return_x_0_y_0_and_N_and_fast_is_true_when_receive_F_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.FAST);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isFastFlag(), is(true));
    }

    @Test
    public void should_return_x_0_y_2_and_N_and_fast_is_true_when_receive_FM_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.FAST, Command.MOVE);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(2));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isFastFlag(), is(true));
    }

    @Test
    public void should_return_x_0_y_1_and_W_and_fast_is_true_when_receive_FL_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.FAST, Command.TURN_LEFT);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
        assertThat(marsRover.isFastFlag(), is(true));
    }

    @Test
    public void should_return_x_0_y_1_and_E_and_fast_is_true_when_receive_FR_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.FAST, Command.TURN_RIGHT);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("E"));
        assertThat(marsRover.isFastFlag(), is(true));
    }

    @Test
    public void should_return_x_0_y_0_and_N_and_fast_is_false_when_receive_FF_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.FAST, Command.FAST);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isFastFlag(), is(false));
    }

    @Test
    public void should_return_x_0_y_2_and_N_and_fast_is_false_when_receive_FMF_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.FAST, Command.MOVE, Command.FAST);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(2));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isFastFlag(), is(false));
    }

    @Test
    public void should_return_x_0_y_1_and_W_and_fast_is_false_when_receive_FLF_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.FAST, Command.TURN_LEFT, Command.FAST);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
        assertThat(marsRover.isFastFlag(), is(false));
    }

    @Test
    public void should_return_x_0_y_1_and_E_and_fast_is_false_when_receive_FRF_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        List<Command> commands = Arrays.asList(Command.FAST, Command.TURN_RIGHT, Command.FAST);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("E"));
        assertThat(marsRover.isFastFlag(), is(false));
    }

    @Test
    public void should_return_x_2_y_0_and_N_and_back_is_true_and_fast_is_true_when_receive_BFM_command_give_mars_rover_with_init_place_x_2_y_2_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(2 ,2 , "N"));

        List<Command> commands = Arrays.asList(Command.BACK, Command.FAST, Command.MOVE);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(2));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
        assertThat(marsRover.isBackFlag(), is(true));
        assertThat(marsRover.isFastFlag(), is(true));
    }

    @Test
    public void should_return_x_1_y_0_and_W_and_back_is_true_and_fast_is_true_when_receive_BFL_command_give_mars_rover_with_init_place_x_1_y_1_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "N"));

        List<Command> commands = Arrays.asList(Command.BACK, Command.FAST, Command.TURN_LEFT);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
        assertThat(marsRover.isBackFlag(), is(true));
        assertThat(marsRover.isFastFlag(), is(true));
    }

    @Test
    public void should_return_x_0_y_1_and_E_and_back_is_true_and_fast_is_true_when_receive_BFR_command_give_mars_rover_with_init_place_x_1_y_1_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "N"));

        List<Command> commands = Arrays.asList(Command.BACK, Command.FAST, Command.TURN_RIGHT);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("E"));
        assertThat(marsRover.isBackFlag(), is(true));
        assertThat(marsRover.isFastFlag(), is(true));
    }

    @Test
    public void should_return_x_0_y_1_and_E_and_back_is_false_and_fast_is_false_when_receive_BFRBF_command_give_mars_rover_with_init_place_x_1_y_1_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "N"));

        List<Command> commands = Arrays.asList(Command.BACK, Command.FAST, Command.TURN_RIGHT, Command.BACK, Command.FAST);
        MarsRoverPosition marsRoverPosition = marsRover.receive(commands);

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("E"));
        assertThat(marsRover.isBackFlag(), is(false));
        assertThat(marsRover.isFastFlag(), is(false));
    }
}
