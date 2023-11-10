package project;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;

import java.io.IOException;

public class HomePageController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label ButtonText;

    @FXML
    protected void onHelloButtonClick() {
        ButtonText.setText("Welcome to JavaFX Application!");
    }



    private void addRelease(Event event) throws IOException {
        Popup popup = new Popup();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/project/Exit-Screen.fxml"));
        Parent parent = (Parent)loader.load(); // I am not sure you need a cast here
//        newReleasePopupController controller = loader.getController();
        popup.getContent().add(parent);
    }
}