package project;

import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class Junit_TestCases  {
    private Player p1 ;


    @Test
    public void Test1(){

        int total_rod_falls = HomePageController.getTotal_right_falls();

        int current_score = 0 ;

        current_score = HomePageController.getCurrent_score();

        assertEquals(total_rod_falls, current_score);

    }
    @Test
    public void Test2(){

        int expected_down_state = 0 ;
        int actual_down_state = Player.getPlayer_down_state();

        assertEquals(expected_down_state , actual_down_state );
    }


    @Test
    public void Test3() throws IOException, ClassNotFoundException {
        Cherry actual_cherry = Player.getPlayerCherryProperties();
        Rectangle actual_rectangle = Player.getCurrent_pillar();

        assertNull(actual_cherry);
        assertNull(actual_rectangle);


    }

    @Test
    public void Test4(){
        Rectangle length_rectangle = HomePageController.getRod() ;
        length_rectangle = new Rectangle();
        assertNotNull(length_rectangle);
        assertEquals(0 , length_rectangle.getHeight());


    }


}
