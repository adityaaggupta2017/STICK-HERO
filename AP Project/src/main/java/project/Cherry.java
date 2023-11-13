package project;

import javafx.scene.image.ImageView;

public class Cherry extends ImageView {
    private int CherryCount ;

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
