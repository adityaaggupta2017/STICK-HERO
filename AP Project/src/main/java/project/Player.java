package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends ImageView {

    private CharacterController controls;
    private Cherry playerCherryProperties;
    private int player_points;

    private static MediaPlayer mediaPlayer;
    public Cherry getPlayerCherryProperties() {
        return playerCherryProperties;
    }

    public void setPlayerCherryProperties(Cherry playerCherryProperties) {
        this.playerCherryProperties = playerCherryProperties;
    }

    public int getPlayer_points() {
        return player_points;
    }

    public void setPlayer_points(int player_points) {
        this.player_points = player_points;
    }

    public Player() {
        super();
        playerCherryProperties = new Cherry();

        // Set the default image for the player
        Image defaultImage = new Image("hero.png");
        setImage(defaultImage);

        double newWidth = 130;
        double newHeight = 80;

        setFitWidth(newWidth);
        setFitHeight(newHeight);
        playerCherryProperties.setX(590);
        playerCherryProperties.setY(1);

    }

    public static void savePlayerState(){

    }

    //for serialization and get the saved state of the player
    public static void getPlayerState(){

    }

}

