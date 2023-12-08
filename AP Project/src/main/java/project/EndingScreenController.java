package project;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndingScreenController extends HomePageController  {

    private static Media new_media;
    private static MediaPlayer new_media_player;

    @FXML
    private Label CurrentScore = new Label("0");
    @FXML
    private Label HighestScore = new Label("0");

    private static Stage ReviveSceneStage;

    public Stage getReviveSceneStage() {
        return ReviveSceneStage;
    }

    public void setReviveSceneStage(Stage reviveSceneStage) {
        ReviveSceneStage = reviveSceneStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            CurrentScore.setText(String.valueOf(Player.getPlayerState().get(0)));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            HighestScore.setText(String.valueOf(Player.getPlayerState().get(1)));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static MediaPlayer getNewMediaPlayer(){
        return new_media_player;
    }

    @FXML
    public void returnToHomePage() throws IOException {
        setCurrent_Platform(0);
        String path = "AP Project\\src\\main\\java\\project\\Main Menu.mp3";
        new_media = new Media(new File(path).toURI().toString());
        new_media_player = new MediaPlayer(new_media);
        new_media_player.setCycleCount(MediaPlayer.INDEFINITE);
        new_media_player.setAutoPlay(true);
        getMediaPlayer().stop();
        setMediaPlayer(new_media_player);
        Stage new_stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("Home-Page.fxml"));
        Scene new_scene = new Scene(fxmlLoader.load());
        new_scene.setFill(Color.TRANSPARENT);
        new_stage.initStyle(StageStyle.TRANSPARENT);
        setScene(new_scene);
        new_stage.setScene(new_scene);
        new_stage.show();
        getStage().close();
        getEndingSceneStage().close();
    }
    @FXML
    public void restartTheGame(ActionEvent event2) throws IOException, ClassNotFoundException {

        clearAll(event2);



    }

    @FXML

    public void revivePlayer() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Revive.fxml"));
        EndingScreenController ed = new EndingScreenController();
        Parent ReviveSceneRoot = loader.load();
        ReviveSceneStage = new Stage();
        ReviveSceneStage.initModality(Modality.APPLICATION_MODAL);
//        endingSceneStage.initOwner(stage);
        Scene ReviveScene = new Scene(ReviveSceneRoot);
        Image icon = new Image("stickhero_charcater-removebg-preview.png") ;
        ReviveSceneStage.getIcons().add(icon);
        ReviveScene.setFill(Color.TRANSPARENT);
        ReviveSceneStage.initStyle(StageStyle.TRANSPARENT);


//        endingSceneStage.setWidth(500);
//        endingSceneStage.setHeight(800);
        ReviveSceneStage.setResizable(false);
        BoxBlur blur = new BoxBlur(10, 10, 5);
        getScene().getRoot().setEffect(blur);


        FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000), ReviveSceneRoot);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);

        // Play the fade in transition
        fadeInTransition.play();




        // Show the pop-up

        ReviveSceneStage.setOnCloseRequest(Event::consume);
        ReviveSceneStage.initStyle(StageStyle.UNDECORATED); // this removes the close window button


        ReviveSceneStage.setScene(ReviveScene);
        ReviveSceneStage.show();

    }

}
