package project;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunningGameController {

    private static ArrayList<Rectangle> Platforms;

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private static List<Rectangle> pillars = new ArrayList<>();



    private static int lastPillarX = 100; // Initial X position of the first pillar
    private static final int pillarHeight = 200; // Width of pillars
    private static int gapBetweenPillars = 0; // Gap between pillars


    @FXML
    private static Rectangle rod;

    private static Group group1  ;

    private static double initialHeight = 50.0;  // Initial height of the rod
    private static double maxHeight = 1000;     // Maximum height the rod can be extended to

    private static Timeline extendTimeline;
    private static Timeline dropTimeline;



    private static ScaleTransition trans;

    private static Player new_player ;

    public static ArrayList<Rectangle> getPlatforms() {
        return Platforms;
    }

    public static double getInitialHeight() {
        return initialHeight;
    }

    public static double getMaxHeight() {
        return maxHeight;
    }

    public static Group getGroup1() {
        return group1;
    }

    public static int getGapBetweenPillars() {
        return gapBetweenPillars;
    }

    public static int getLastPillarX() {
        return lastPillarX;
    }

    public static int getPillarHeight() {
        return pillarHeight;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static List<Rectangle> getPillars() {
        return pillars;
    }

    public static Player getNew_player() {
        return new_player;
    }

    public static Rectangle getRod() {
        return rod;
    }

    public static ScaleTransition getTrans() {
        return trans;
    }

    public static Timeline getDropTimeline() {
        return dropTimeline;
    }

    public static Timeline getExtendTimeline() {
        return extendTimeline;
    }


    public static void setDropTimeline(Timeline dropTimeline) {
        RunningGameController.dropTimeline = dropTimeline;
    }

    public static void setExtendTimeline(Timeline extendTimeline) {
        RunningGameController.extendTimeline = extendTimeline;
    }

    public static void setGapBetweenPillars(int gapBetweenPillars) {
        RunningGameController.gapBetweenPillars = gapBetweenPillars;
    }

    public static void setGroup1(Group group1) {
        RunningGameController.group1 = group1;
    }

    public static void setInitialHeight(double initialHeight) {
        RunningGameController.initialHeight = initialHeight;
    }

    public static void setLastPillarX(int lastPillarX) {
        RunningGameController.lastPillarX = lastPillarX;
    }

    public static void setMaxHeight(double maxHeight) {
        RunningGameController.maxHeight = maxHeight;
    }

    public static void setNew_player(Player new_player) {
        RunningGameController.new_player = new_player;
    }

    public static void setPillars(List<Rectangle> pillars) {
        RunningGameController.pillars = pillars;
    }

    public static void setPlatforms(ArrayList<Rectangle> platforms) {
        Platforms = platforms;
    }

    public static void setRod(Rectangle rod) {
        RunningGameController.rod = rod;
    }

    public static void setTrans(ScaleTransition trans) {
        RunningGameController.trans = trans;
    }


    public void pillarGenerator(int initial_flag){
        if(initial_flag == 1){
            Random random = new Random();
            Rectangle r1 = new Rectangle(100 , 200 , Color.DODGERBLUE);
            r1.setY(459);
            Platforms.add(r1);
            initial_flag = 0;
        }

        else{
            Random random = new Random();
            Rectangle r1 = new Rectangle(50 + random.nextInt(50) , 200 , Color.DODGERBLUE);
            r1.setY(459);
            Platforms.add(r1);

        }


    }


    @FXML
    private void handleMousePressed(MouseEvent event) {
        // Start extending the rod when the mouse is pressed
        extendTimeline.play();
    }

    @FXML
    private void handleMouseReleased(MouseEvent event) {
        // Stop extending the rod when the mouse is released
        extendTimeline.stop();

        // Start the drop animation
        dropTimeline.play();
    }

    private void extendRod() {
        // Extend the rod vertically from the top
        double currentHeight = rod.getHeight();
        double newY = rod.getY() - 2; // Increase Y coordinate to simulate extension from the top
        if (currentHeight < maxHeight) {
            rod.setHeight(currentHeight + 2);
            rod.setY(newY);
        }
    }

    public void dropRod(){

        double pivotX = rod.getX(); // X coordinate of the lower end
        double pivotY = rod.getY() + rod.getHeight(); // Y coordinate of the lower end
        Rotate rotate = new Rotate(0, pivotX, pivotY); // Initial rotation angle is 0
        rod.getTransforms().clear(); // Clear existing transforms
        rod.getTransforms().add(rotate); // Apply the new rotation transform
        rotate.setAngle(90); // Rotate the rod to be horizontal

    }
}





