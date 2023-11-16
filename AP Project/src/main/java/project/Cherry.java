package project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cherry extends ImageView {
    private int CherryCount ;


    public Cherry(){
        Image defaultImage = new Image("Cherry.png");
        setImage(defaultImage);

        double newWidth = 40;
        double newHeight = 40;

        setFitWidth(newWidth);
        setFitHeight(newHeight);
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
