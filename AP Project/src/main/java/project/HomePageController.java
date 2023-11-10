package project;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class HomePageController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label ButtonText;

    @FXML
    private static Stage stored_stage;

    @FXML
    private static Stage primary_stage;
    @FXML
    private Stage stage ;
    private Scene scene ;
    private Parent root ;



    @FXML
    protected void onHelloButtonClick() {
//        ButtonText.setText("Welcome to JavaFX Application!");
        System.out.println("helloworld");
    }

    public static Stage getStored_stage() {
        return stored_stage;
    }

    public static Stage getPrimary_stage() {
        return primary_stage;
    }

    public static void setPrimary_stage(Stage primary_stage) {
        HomePageController.primary_stage = primary_stage;
    }

    public static void setStored_stage(Stage stored_stage) {
        HomePageController.stored_stage = stored_stage;
    }

    @FXML
    public void switchToRunning(ActionEvent event) throws IOException {
        // Load the new FXML file
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));

        // Set up the fade transition
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), newRoot);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
        // Get the current stage
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the scene with a transparent root first
        scene = new Scene(new Pane(), stage.getScene().getWidth(), stage.getScene().getHeight());
        stage.setScene(scene);

        // Set up the fade transition for the current scene
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1000), scene.getRoot());
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);

        // After fade out, set the new root and play the fade in transition
        fadeOutTransition.setOnFinished(e -> {
            scene.setRoot(newRoot);

            fadeTransition.play();
        });

        // Play the fade out transition
        fadeOutTransition.play();
    }

    @FXML
    private void addRelease(ActionEvent event) throws IOException {
        // Load the FXML file for the pop-up
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Exit-Screen.fxml")));

        // Create a new stage for the pop-up
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(stage); // Set the main window as the owner

        // Set up the scene with the loaded FXML content
        Scene popupScene = new Scene(newRoot);

        // Set the size of the pop-up window (you can adjust the values as needed)
        popupStage.setWidth(500);
        popupStage.setHeight(300);

        // Set up the fade transition for the pop-up
        FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000), newRoot);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);

        // Play the fade in transition
        fadeInTransition.play();

        // Show the pop-up
        popupStage.setScene(popupScene);
        stored_stage = popupStage;
        popupStage.show();
    }
}