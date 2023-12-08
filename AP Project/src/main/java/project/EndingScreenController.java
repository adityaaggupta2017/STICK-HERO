package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class EndingScreenController extends HomePageController{

    private static Media new_media;
    private static MediaPlayer new_media_player;

    public static MediaPlayer getNewMediaPlayer(){
        return new_media_player;
    }

    @FXML
    public void returnToHomePage() throws IOException {
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
    public void restartTheGame(ActionEvent event2) throws IOException {
        clearAll(event2);



    }

    @FXML

    public void continueGame(){

    }

}
