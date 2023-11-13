package project;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class HomePageController implements HomeInterface , Rod{
    @FXML
    private Label welcomeText;

    @FXML
    private Label ButtonText;

    private int initialFlag = 1;
    @FXML
    private static Stage stored_stage;

    @FXML
    private static Stage primary_stage;
    @FXML
    private static Stage stage ;
    private static Scene scene  ;
    private static Parent root ;


    private static ArrayList<Rectangle> Platforms;

    private static int Counter;
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

    private static Parent newRoot ;


    private static ScaleTransition trans;

    private static Player new_player ;

    private static PauseMenu new_PauseMenu ;

    @FXML
    protected void onHelloButtonClick() {
//        ButtonText.setText("Welcome to JavaFX Application!");
        System.out.println("helloworld");
    }

    public static Stage getStored_stage() {
        return stored_stage;
    }

    public static Stage getPrimary_stage() {
        return primary_stage;
    }

    public static void setPrimary_stage(Stage primary_stage) {
        HomePageController.primary_stage = primary_stage;
    }

    public static void setStored_stage(Stage stored_stage) {
        HomePageController.stored_stage = stored_stage;
    }

    public static Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


    @FXML
    public void switchToRunning(ActionEvent event1) throws IOException {
        // Load the new FXML file

        newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        System.out.println("hello2");
        // Set up the fade transition
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), newRoot);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
        // Get the current stage
        stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();

        // Set the scene with a transparent root first
        scene = new Scene(new Pane(), stage.getScene().getWidth(), stage.getScene().getHeight());
        stage.setScene(scene);
        System.out.println("hello1");

        // Set up the fade transition for the current scene
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1000), scene.getRoot());
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);

        // After fade out, set the new root and play the fade in transition
        fadeOutTransition.setOnFinished(e -> {

            scene.setRoot(newRoot);

            fadeTransition.play();
        });

        System.out.println("hello3");


        general_initializer();

        System.out.println("6");



        // Play the fade out transition
        fadeOutTransition.play();
        //        RunningGameController main_game  = new RunningGameController();
//        main_game.start_generating();

//        stage.close();
//
//        RunningGameController main_game  = new RunningGameController();
//        main_game.start_generating();
    }

    @FXML
    private void OnExit(ActionEvent event) throws IOException {
        // Load the FXML file for the pop-up
        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Exit-Screen.fxml")));

        // Create a new stage for the pop-up
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(stage); // Set the main window as the owner

        // Set up the scene with the loaded FXML content
        Scene popupScene = new Scene(newRoot);

        // Set the size of the pop-up window (you can adjust the values as needed)
        popupStage.setWidth(500);
        popupStage.setHeight(300);

        // Set up the fade transition for the pop-up
        FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000), newRoot);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);

        // Play the fade in transition
        fadeInTransition.play();

        // Show the pop-up
        popupStage.setScene(popupScene);
        stored_stage = popupStage;
        popupStage.show();
    }


//    public void start_generating(Stage primaryStage) {
//        root = new Pane();
//        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        generatePillar(); // Initial pillar generation
//
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                movePillars();
//
//                generatePillar();
//
//            }
//        };
//        timer.start();
//    }
//
//    private void generatePillar() {
//        Random random = new Random();
//        int pillarWidth = random.nextInt(50) + 50; // Random height for the pillar
//        gapBetweenPillars = random.nextInt(100) + 20;
//        Rectangle pillar = new Rectangle(lastPillarX, WINDOW_HEIGHT - pillarHeight, pillarWidth, pillarHeight);
//        pillar.setFill(Paint.valueOf("DODGERBLUE"));
//        root.getChildren().add(pillar);
//        pillars.add(pillar);
//
//        lastPillarX += gapBetweenPillars + pillarWidth;
//        group1.getChildren().add(pillar);
//    }
//
//    private void movePillars() {
//        for (Rectangle pillar : pillars) {
//            pillar.setTranslateX(pillar.getTranslateX() - 1); // Adjust the movement speed of pillars
//        }
//    }

    public void pillarGenerator(int initial_flag){
        System.out.println(initial_flag);

        Random random = new Random();
        Rectangle r1 = new Rectangle(100 , 200 , Color.BLACK);
        r1.setX(Counter);
        r1.setY(459);
        Platforms.add(r1);
        initial_flag = 0;
        Counter += 300 + random.nextInt(50);



    }

    @FXML
    public void general_initializer() {
        Counter = 0 ;
        group1 = new Group();

        trans = new ScaleTransition();

        rod = new Rectangle(5, 100, Color.BLACK) ;

        new_player = new Player();

        new_PauseMenu = new PauseMenu(new_player);
        new_player.setX(10);
        new_player.setY(385);

        Platforms = new ArrayList<Rectangle>();



        pillarGenerator(initialFlag);
        pillarGenerator(initialFlag);
        group1.getChildren().add(new_player.getPlayerCherryProperties());
        group1.getChildren().add(new_player);
        group1.getChildren().add(Platforms.get(0));
        group1.getChildren().add(Platforms.get(1));

        trans.setNode(rod);

        extendTimeline = new Timeline(
                new KeyFrame(Duration.millis(16), event -> extendRod())
        );
        System.out.println("7");
        System.out.println("hello4");
        extendTimeline.setCycleCount(Timeline.INDEFINITE);

        dropTimeline = new Timeline(
                new KeyFrame(Duration.millis(16), event -> dropRod())
        );
        dropTimeline.setCycleCount(Timeline.INDEFINITE);

        rod.setX(95);
        System.out.println("3");
        rod.setY(360);

        System.out.println("4");
        group1.getChildren().add(rod);
        System.out.println("5");
        ((Pane)newRoot).getChildren().add(group1) ;



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
    @Override
    public void extendRod() {
        // Extend the rod vertically from the top
        double currentHeight = rod.getHeight();
        double newY = rod.getY() - 2; // Increase Y coordinate to simulate extension from the top
        if (currentHeight < maxHeight) {
            rod.setHeight(currentHeight + 2);
            rod.setY(newY);
        }
    }
    @Override
    public void dropRod(){

        double pivotX = rod.getX(); // X coordinate of the lower end
        double pivotY = rod.getY() + rod.getHeight(); // Y coordinate of the lower end
        Rotate rotate = new Rotate(0, pivotX, pivotY); // Initial rotation angle is 0
        rod.getTransforms().clear(); // Clear existing transforms
        rod.getTransforms().add(rotate); // Apply the new rotation transform
        rotate.setAngle(90); // Rotate the rod to be horizontal

    }
}