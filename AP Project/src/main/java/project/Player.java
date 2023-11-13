package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends ImageView {
    private Cherry playerCherryProperties;
    private int player_points;

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
    }
}

