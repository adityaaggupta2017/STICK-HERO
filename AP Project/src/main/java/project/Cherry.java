package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Cherry extends ImageView {
    private int CherryCount ;


    public Cherry(){
        Image defaultImage = new Image("cherry_icon-removebg-preview.png");
        setImage(defaultImage);

        double newWidth = 40;
        double newHeight = 40;

        setFitWidth(newWidth);
        setFitHeight(newHeight);
    }

    public void getSound(){
        String path_cherry = "src\\main\\java\\project\\InGameSounds\\cherry_sound.mp3";
        Media media_cherry = new Media(new File(path_cherry).toURI().toString());
        MediaPlayer mediaPlayer_dead = new MediaPlayer(media_cherry);

        mediaPlayer_dead.play();
    }

    public void getAnimation(){

    }

    public int getCherryCount() {
        return CherryCount;
    }

    public void setCherryCount(int cherryCount) {
        CherryCount = cherryCount;
    }
    public void increaseCherryCount(int incrValue){
        this.CherryCount += incrValue;
    }
    public void decreaseCherryCount(int decrValue){
        this.CherryCount -= decrValue;
    }


}