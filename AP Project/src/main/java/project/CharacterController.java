package project;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import java.net.URL;

import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ResourceBundle;

public class CharacterController implements Initializable {
    @FXML
    private ImageView img1;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        TranslateTransition t1 = new TranslateTransition();
        t1.setNode(img1);
        t1.setDuration(Duration.millis(2000));
        t1.setByX(250);
        t1.play();

    }

}
