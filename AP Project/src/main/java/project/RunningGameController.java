package project;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
        root.getChildren().add(pillar);
        pillars.add(pillar);

        lastPillarX += gapBetweenPillars + pillarWidth;
    }

    private void movePillars() {
        for (Rectangle pillar : pillars) {
            pillar.setTranslateX(pillar.getTranslateX() - 1); // Adjust the movement speed of pillars
        }
    }



}
