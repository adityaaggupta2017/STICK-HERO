package project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;



public class PauseMenuController extends HomePageController{
    private static Media new_media;
    private static MediaPlayer new_media_player;

    public static MediaPlayer getNewMediaPlayer(){
        return new_media_player;
    }
    public void HomePage() throws IOException {

//        String path = "AP Project\\src\\main\\java\\project\\Main Menu.mp3";
//        Media media = new Media(new File(path).toURI().toString());
//        mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//        mediaPlayer.setAutoPlay(true);
//
//
//        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("Home-Page.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 635, 800);
//        stage.setTitle("  STICK HERO ");
//        Image icon = new Image("stickhero_charcater-removebg-preview.png") ;
//        stage.getIcons().add(icon);
//        stage.setScene(scene);
////        System.out.println("hello");
//        stage.show();
        String path = "AP Project\\src\\main\\java\\project\\Main Menu.mp3";
        new_media = new Media(new File(path).toURI().toString());
        new_media_player = new MediaPlayer(new_media);
        new_media_player.setCycleCount(MediaPlayer.INDEFINITE);
        new_media_player.setAutoPlay(true);
        getMediaPlayer().stop();
        setMediaPlayer(new_media_player);


        Stage new_stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("Home-Page.fxml"));
        Scene new_scene = new Scene(fxmlLoader.load(), 635, 800);
        setScene(new_scene);
        new_stage.setScene(new_scene);
        new_stage.show();
        getStage().close();



    }

    public void resumeGame(){
        getScene().getRoot().setEffect(null);
        getMediaPlayer().setVolume(1.0);

        if (getPauseMenuStage() != null && getPauseMenuStage().isShowing()){
            getPauseMenuStage().close();
        }

    }



}
