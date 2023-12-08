package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReviveController extends EndingScreenController{

    private HomePageController previousStageController;
    @FXML
    private Label cherry_count = new Label("0");

    @FXML
    private Button myButton = new Button();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cherry_count.setText(String.valueOf(Player.getPlayerState().get(2)));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            if (Player.getPlayerState().get(2) < 10){
                myButton.setStyle("-fx-background-color: red;");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void yes(ActionEvent event4) throws Exception {

        if (Player.getPlayerState().get(2) >= 10) {

            getReviveSceneStage().close();
            revivingPlayer(event4);

            openPreviousStage();
            updateLabelTextInPreviousStage();

        }





    }

    public void no() throws Exception {

        getReviveSceneStage().close();


    }


    public void openPreviousStage() throws Exception {
        previousStageController = getLoader().getController();


    }

    public void updateLabelTextInPreviousStage() throws FileNotFoundException, ClassNotFoundException {

        if (previousStageController != null) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("this is my precious controller: "+ Player.getPlayerState().get(2));
            previousStageController.setDynamicText(Integer.parseInt(String.valueOf(Player.getPlayerState().get(0))));
            previousStageController.setDynamicCherryText(Integer.parseInt(String.valueOf(Player.getPlayerState().get(2))));
        }
    }




}
