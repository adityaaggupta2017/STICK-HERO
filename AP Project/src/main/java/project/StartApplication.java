package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
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