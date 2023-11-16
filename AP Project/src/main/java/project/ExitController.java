package project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ExitController extends HomePageController{

    @FXML
    private Label ExitLabel;

    public void exit(){
        HomePageController.fadeOut(volumeProperty1,0.5,0.0);
        System.exit(0);
    }

    public void dontExit(){
        HomePageController.fadeIn(volumeProperty1,0.5,1.0);
        getStored_stage().close();

    }
}
