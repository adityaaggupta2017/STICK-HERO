package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StartApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        String path = "src\\main\\java\\project\\Main Menu.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);

        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("Home-Page.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 635, 800);
        stage.setTitle("  STICK HERO ");
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