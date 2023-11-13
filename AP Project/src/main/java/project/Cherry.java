package project;

public class Cherry {
    private int CherryCount ;

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
