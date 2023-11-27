package project;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.*;

public class Player extends ImageView implements Serializable {

    @Serial
    private static final long serialVersionUID = 5L;

    private int player_down_state ;
    //    private transient CharacterController controls;
    private Cherry playerCherryProperties;
    private int player_points;

//    private static MediaPlayer mediaPlayer;

    private static Rectangle current_pillar ;
    private static Rectangle next_pillar ;

    private double x_coordinate = 0 ;

    public double getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getPlayer_down_state() {
        return player_down_state;
    }

    public void setPlayer_down_state(int player_down_state) {
        this.player_down_state = player_down_state;
    }

    public Cherry getPlayerCherryProperties() {
        return playerCherryProperties;
    }

    public Rectangle getCurrent_pillar() {
        return current_pillar;
    }

    public Rectangle getNext_pillar() {
        return next_pillar;
    }

    public void setCurrent_pillar(Rectangle current_pillar) {
        Player.current_pillar = current_pillar;
    }

    public void setNext_pillar(Rectangle next_pillar) {
        Player.next_pillar = next_pillar;
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
        this.player_down_state = 0;
        // Set the default image for the player
        Image defaultImage = new Image("hero.png");
        setImage(defaultImage);

        double newWidth = 130;
        double newHeight = 80;

        setFitWidth(newWidth);
        setFitHeight(newHeight);
        playerCherryProperties.setX(378);
        playerCherryProperties.setY(25);

    }

    public static void savePlayerState(Player s1) throws IOException {
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream("PlayerState.txt",false));
            out.writeObject(s1);
        }
        finally{
            if(out != null) out.close();
        }
    }

    //for serialization and get the saved state of the player
    public static Player getPlayerState() throws IOException, ClassNotFoundException{
        Player p1 = null;
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream("PlayerState.txt"));
            p1 = (Player) in.readObject();
        }
        finally{
            if(in != null) in.close();
        }
        return p1;
    }

    public void player_fall(){
        TranslateTransition playerFall = new TranslateTransition(Duration.millis(1000), this);
        playerFall.setToY(500);
        playerFall.setCycleCount(1);
        playerFall.setAutoReverse(false);

        String path_dead = "AP Project\\src\\main\\java\\project\\InGameSounds\\dead.wav";
        Media media_dead = new Media(new File(path_dead).toURI().toString());
        MediaPlayer mediaPlayer_dead = new MediaPlayer(media_dead);
        playerFall.setOnFinished(event -> {
            mediaPlayer_dead.play();
        });
        playerFall.play();






        // now for the exit screen



    }

    public void flip_player() {
        this.setY(456);
        this.setScaleY(-1); // Flip vertically
    }

    public void normal_state(){
        this.setY(385);
        this.setScaleY(1);
    }


}

