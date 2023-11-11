package project;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunningGameController {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private List<Rectangle> pillars = new ArrayList<>();
    private Pane root;


    private int lastPillarX = 100; // Initial X position of the first pillar
    private final int pillarHeight = 200; // Width of pillars
    private int gapBetweenPillars = 0; // Gap between pillars


    @FXML
    private Rectangle rod;

    private Group group1  ;

    private double initialHeight = 50.0;  // Initial height of the rod
    private double maxHeight = 150.0;     // Maximum height the rod can be extended to

    private Timeline extendTimeline;
    private Timeline dropTimeline;
    public void start_generating(Stage primaryStage) {
        root = new Pane();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

        generatePillar(); // Initial pillar generation

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                movePillars();

                generatePillar();

            }
        };
        timer.start();
    }

    private void generatePillar() {
        Random random = new Random();
        int pillarWidth = random.nextInt(50) + 50; // Random height for the pillar
        gapBetweenPillars = random.nextInt(100) + 20;
        Rectangle pillar = new Rectangle(lastPillarX, WINDOW_HEIGHT - pillarHeight, pillarWidth, pillarHeight);
        pillar.setFill(Paint.valueOf("DODGERBLUE"));
        root.getChildren().add(pillar);
        pillars.add(pillar);

        lastPillarX += gapBetweenPillars + pillarWidth;
        group1.getChildren().add(pillar);
    }

    private void movePillars() {
        for (Rectangle pillar : pillars) {
            pillar.setTranslateX(pillar.getTranslateX() - 1); // Adjust the movement speed of pillars
        }
    }

    public void growRod() {


    }


    @FXML
    private void initialize() {
        group1 = new Group();
        rod = new Rectangle(100, 5, Color.BLACK) ;
        rod.setX(20);
        rod.setY(375);
        group1.getChildren().add(rod);
        HomePageController.getScene().getRoot().getChildrenUnmodifiable().add(group1) ;

        extendTimeline = new Timeline(
                new KeyFrame(Duration.millis(16), event -> extendRod())
        );
        extendTimeline.setCycleCount(Timeline.INDEFINITE);

        dropTimeline = new Timeline(
                new KeyFrame(Duration.millis(16), event -> dropRod())
        );
        dropTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    @FXML
    private void handleMousePressed(MouseEvent event) {
        // Start extending the rod when the mouse is pressed
        extendTimeline.play();
    }

    @FXML
    private void handleMouseReleased(MouseEvent event) {
        // Stop extending and drop the rod when the mouse is released
        extendTimeline.stop();
        dropTimeline.play();
    }

    private void extendRod() {
        // Extend the rod vertically
        double currentHeight = rod.getHeight();
        if (currentHeight < maxHeight) {
            rod.setHeight(currentHeight + 2);
        }
    }

    private void dropRod() {
        // Drop the rod flat on the floor
        double currentHeight = rod.getHeight();
        if (currentHeight > initialHeight) {
            rod.setHeight(currentHeight - 2);
        } else {
            // Stop the drop animation when the rod reaches its initial height
            dropTimeline.stop();
        }
    }

}





