package project;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface HomeInterface {
    public void switchToRunning(ActionEvent event1) throws IOException;
    public void pillarGenerator(int initial_flag);
    public void general_initializer();
    public void dropRod();

}
