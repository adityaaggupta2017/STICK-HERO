package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;




public class StartApplication extends Application {

    private static MediaPlayer mediaPlayer ;

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    @Override
    public void start(Stage stage) throws IOException {

        String path = "AP Project\\src\\main\\java\\project\\Main Menu.mp3";
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);


        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("Home-Page.fxml"));
        Scene scene = new Scene(fxmlLoader.load() );
        stage.setTitle("  STICK HERO ");
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        Image icon = new Image("stickhero_charcater-removebg-preview.png") ;
        stage.getIcons().add(icon);
        stage.setScene(scene);
//        System.out.println("hello");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}