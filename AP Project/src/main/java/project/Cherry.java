package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Cherry extends ImageView implements Serializable {
    private int CherryCount;
    private ImageView defaultImage;
    public Cherry(){
        Image img = new Image("cherry_icon-removebg-preview.png");
        defaultImage = new ImageView(img);
        defaultImage.setFitWidth(30); // Adjust the width of the cherry image
        defaultImage.setFitHeight(30); // Adjust the height of the cherry image

//        double newWidth = 40;
//        double newHeight = 40;
//
//        setFitWidth(newWidth);
//        setFitHeight(newHeight);
    }

    public ImageView getCherryImage(){
        return defaultImage;
    }

    public void getSound(){

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
