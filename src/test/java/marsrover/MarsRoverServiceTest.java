package marsrover;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarsRoverServiceTest {
    private MarsRoverService marsRoverService;

    @Test
    public void should_return_x_0_y_2_and_N_when_receive_MM_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("MM");

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(2));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
    }

    @Test
    public void should_return_x_0_y_0_and_W_when_receive_MLLMR_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("MLLMR");

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0) );
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
    }

    @Test
    public void should_return_x_3_y_1_and_W_when_receive_MLLMR_command_give_mars_rover_with_init_place_x_2_y_1_E() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(2,1, "E"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("MLLR");

        assertThat(marsRoverPosition.getCoordinatesX(), is(3));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1) );
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
    }

    @Test
    public void should_return_x_1_y_1_and_W_when_receive_LLM_command_give_mars_rover_with_init_place_x_2_y_1_E() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(2,1, "E"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("LLM");

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1) );
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
    }

    @Test
    public void should_return_x_0_y_1_and_N_when_receive_M_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("M");

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
    }

    @Test
    public void should_return_x_0_y_0_and_W_when_receive_L_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("L");

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
    }

    @Test
    public void should_return_x_0_y_0_and_E_when_receive_R_command_give_mars_rover_with_init_place_x_0_y_0_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(0 ,0 , "N"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("R");

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("E"));
    }

    @Test
    public void should_return_x_1_y_0_and_N_when_receive_B_command_give_mars_rover_with_init_place_x_1_y_1_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "N"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("B");

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(0));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
    }

    @Test
    public void should_return_x_2_y_1_and_W_when_receive_B_command_give_mars_rover_with_init_place_x_1_y_1_W() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "W"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("B");

        assertThat(marsRoverPosition.getCoordinatesX(), is(2));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
    }

    @Test
    public void should_return_x_1_y_2_and_S_when_receive_B_command_give_mars_rover_with_init_place_x_1_y_1_S() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "S"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("B");

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(2));
        assertThat(marsRoverPosition.getDirectionShortName(), is("S"));
    }

    @Test
    public void should_return_x_0_y_1_and_E_when_receive_B_command_give_mars_rover_with_init_place_x_1_y_1_E() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "E"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("B");

        assertThat(marsRoverPosition.getCoordinatesX(), is(0));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("E"));
    }

    @Test
    public void should_return_x_1_y_1_and_N_when_receive_BB_command_give_mars_rover_with_init_place_x_1_y_1_N() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "N"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("BB");

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("N"));
    }

    @Test
    public void should_return_x_1_y_1_and_W_when_receive_BB_command_give_mars_rover_with_init_place_x_1_y_1_W() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "W"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("BB");

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("W"));
    }

    @Test
    public void should_return_x_1_y_1_and_S_when_receive_BB_command_give_mars_rover_with_init_place_x_1_y_1_S() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "S"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("BB");

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("S"));
    }

    @Test
    public void should_return_x_1_y_1_and_E_when_receive_BB_command_give_mars_rover_with_init_place_x_1_y_1_E() {
        MarsRover marsRover = new MarsRover(new MarsRoverPosition(1 ,1 , "E"));

        marsRoverService = new MarsRoverService(marsRover);
        MarsRoverPosition marsRoverPosition = marsRoverService.receive("BB");

        assertThat(marsRoverPosition.getCoordinatesX(), is(1));
        assertThat(marsRoverPosition.getCoordinatesY(), is(1));
        assertThat(marsRoverPosition.getDirectionShortName(), is("E"));
    }

}
