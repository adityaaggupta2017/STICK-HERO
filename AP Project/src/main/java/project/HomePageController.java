package project;

import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
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
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


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

    private static Timeline moveTimeLine ;
    private static Parent newRoot ;


    private static ScaleTransition trans;

    private static Player new_player ;

    private static PauseMenu new_PauseMenu ;

    private int currentPlatformIndex = 0;

    private static ArrayList<TranslateTransition> TransitionArray;

    private static final Duration ROTATE_DURATION = Duration.seconds(2);


    private int current_Platform = 0;

    private double rod_length = 0;

    private static MediaPlayer mediaPlayer1;
    private static MediaPlayer mediaPlayer2;



    private static String mediaPath;

    static FadeTransition fadeOutSound1;
    static FadeTransition fadeOutSound2;
    static FadeTransition fadeInSound1;
    static FadeTransition fadeInSound2;
    static DoubleProperty volumeProperty1;
    static DoubleProperty volumeProperty2;


    private static Media media;

    private static MediaPlayer mediaPlayer;

    private static Stage pauseMenuStage;

    private static int rotation_counter ;

    @FXML
    private Text dynamicText ;

    private static Stage endingSceneStage ;

    private static ArrayList<Cherry> cherry_array;

    private static int CherryGetter = 0;

    @FXML
    private Text dynamicCherryText ;

    private int came_behind ;

    private int cherry_counter ;

    private final Lock lock = new ReentrantLock();


    public static Stage getEndingSceneStage() {
        return endingSceneStage;
    }

    public static void setEndingSceneStage(Stage endingSceneStage) {
        HomePageController.endingSceneStage = endingSceneStage;
    }

    public Text getDynamicText() {
        return dynamicText;
    }

    public void setDynamicText(int dynamicText) {

        String path_score = "src\\main\\java\\project\\InGameSounds\\score.mp3";
        Media media_score = new Media(new File(path_score).toURI().toString());
        MediaPlayer mediaPlayer_score = new MediaPlayer(media_score);

        mediaPlayer_score.play();

        getDynamicText().setText(Integer.toString(dynamicText));
    }

    public Text getDynamicCherryText() {
        return dynamicCherryText;
    }

    public void setDynamicCherryText(int dynamicCherryText) {
        getDynamicCherryText().setText(Integer.toString(dynamicCherryText));
    }

    @FXML
    protected void onHelloButtonClick() {
//        ButtonText.setText("Welcome to JavaFX Application!");
        System.out.println("helloworld");
    }

    // these are the getter setter for the Stage
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        HomePageController.stage = stage;
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



    // these are the getter setter for the media
    public static Media getMedia() {
        return media;
    }

    public static void setMedia(Media media) {
        HomePageController.media = media;
    }
    // these are the getter setter for the mediaPlayer
    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        HomePageController.mediaPlayer = mediaPlayer;
    }

    // these are the getter setter for the PauseMenuStage
    public static Stage getPauseMenuStage() {
        return pauseMenuStage;
    }

    public static void setPauseMenuStage(Stage pauseMenuStage) {
        HomePageController.pauseMenuStage = pauseMenuStage;
    }

    @FXML
    public void switchToRunning(ActionEvent event1) throws IOException {
        // Load the new FXML file
//        fadeOut(volumeProperty1,1.0,0.0);
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }

        newRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        System.out.println("hello2");
        // Set up the fade transition
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), newRoot);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();



//        String mediaPath = "Running game.mp3"; // Replace with the actual path to your audio file
//        Media media = new Media(new File(mediaPath).toURI().toString());
//        mediaPlayer2 = new MediaPlayer(media);
//        mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE); // Play indefinitely
//        volumeProperty2 = new SimpleDoubleProperty(1.0);
//        mediaPlayer2.volumeProperty().bindBidirectional(volumeProperty2);
//        fadeIn(volumeProperty2,0.0,1.0);

        stage = (Stage) ((Node) event1.getSource()).getScene().getWindow();

        // Set the scene with a transparent root first
        scene = new Scene(new Pane(), stage.getScene().getWidth(), stage.getScene().getHeight());

        scene.setOnKeyPressed(event->{
            if (event.getCode() == KeyCode.S && !(isPlayerOnPlatform())){
                if (rotation_counter % 2 == 0){
                    new_player.flip_player();
                    new_player.setPlayer_down_state(1);

                }
                else{
                    new_player.normal_state();
                    new_player.setPlayer_down_state(0);
                }
                rotation_counter++ ;


            }
        });



        stage.setScene(scene);
        stage.setResizable(false);

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
//        fadeOut(volumeProperty2,1.0,0.0);
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
//        fadeOut(volumeProperty1,1.0,0.5);
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
        System.out.println("--------------------------------------------");
        Random random1 = new Random();
        cherry_array = new ArrayList<Cherry>();
        //Setting the background music for the main screen
//        String mediaPath = "Main Menu.mp3"; // Replace with the actual path to your audio file
//        Media media = new Media(new File(mediaPath).toURI().toString());
//        mediaPlayer1 = new MediaPlayer(media);
//        mediaPlayer1.setCycleCount(MediaPlayer.INDEFINITE); // Play indefinitely
//        volumeProperty1 = new SimpleDoubleProperty(1.0);
//        mediaPlayer1.volumeProperty().bindBidirectional(volumeProperty1);
//        fadeIn(volumeProperty1,0.0,1.0);

        Counter = 0 ;
        group1 = new Group();
        cherry_counter = 0;
        trans = new ScaleTransition();

        rod = new Rectangle(5, 100, Color.BLACK) ;

        new_player = new Player();
        new_player.setX_coordinate(new_player.getX());

        new_PauseMenu = new PauseMenu(new_player);

        TransitionArray = new ArrayList<>();
        new_player.setX(37);
        new_player.setY(385);

        Platforms = new ArrayList<Rectangle>();

        rotation_counter = 0;

//
//        pillarGenerator(initialFlag);
//        pillarGenerator(initialFlag);
        for (int i = 0; i < 1000; i++) {

            CherryGetter = random1.nextInt(3);
            Rectangle rectangle ;
            Cherry new_cherry = null ;

            if (i == 0){
                rectangle = new Rectangle(100, 200, Color.BLACK);
            }
            else{
                int x = 50 + random1.nextInt(50);
                System.out.println(x);
                rectangle = new Rectangle(x, 200, Color.BLACK); // Modify size/color as needed

            }
            if (i != 0) {
                if (CherryGetter == 2){

                    new_cherry = new Cherry() ;
                    new_cherry.setX(i*300 - 50);
                    new_cherry.setY(469);

                }

                rectangle.setX(i * 300 + random1.nextInt(200)); // Set X position based on the loop index
            }
            else{
                rectangle.setX(0);
            }
            rectangle.setY(459); // Set Y position

            if (new_cherry != null){
                cherry_array.add(new_cherry);
                group1.getChildren().add(new_cherry);
            }

            Platforms.add(rectangle);
            group1.getChildren().add(rectangle);
        }
        group1.getChildren().add(new_player.getPlayerCherryProperties());
        group1.getChildren().add(new_player);
//        group1.getChildren().add(Platforms.get(0));
//        group1.getChildren().add(Platforms.get(1));

        trans.setNode(rod);
        rod.setHeight(2);
        extendTimeline = new Timeline(
                new KeyFrame(Duration.millis(16), event -> extendRod())
        );
        System.out.println("7");
        System.out.println("hello4");
        extendTimeline.setCycleCount(Timeline.INDEFINITE);

        dropTimeline = new Timeline(
                new KeyFrame(Duration.millis(16), event -> dropRod())
        );

        moveTimeLine = new Timeline(new KeyFrame(Duration.millis(16) , event -> movePlatforms()));
        dropTimeline.setCycleCount(Timeline.INDEFINITE);

        rod.setX(95);
        System.out.println("3");
        rod.setY(457);

        System.out.println("4");
        group1.getChildren().add(rod);
        System.out.println("5");
        ((Pane)newRoot).getChildren().add(group1) ;

        if (StartApplication.getMediaPlayer() != null) {
            StartApplication.getMediaPlayer().stop();
        }

        if (PauseMenuController.getNewMediaPlayer() !=null){
            PauseMenuController.getNewMediaPlayer().stop();
        }
        String path = "src\\main\\java\\project\\background_music_new.mp3";
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.4);






    }
//    public static void fadeIn(DoubleProperty volumeProperty, double d1, double d2) {
//        // Create a Timeline for fade-in effect
//        Timeline fadeInTimeline = new Timeline(
//                new KeyFrame(Duration.seconds(0), new KeyValue(volumeProperty, d1)),
//                new KeyFrame(Duration.seconds(3), new KeyValue(volumeProperty, d2))
//        );
//
//        fadeInTimeline.play();
//    }
//
//
//    public static void fadeOut(DoubleProperty volumeProperty, double d1, double d2) {
//        // Create a Timeline for fade-out effect
//        Timeline fadeOutTimeline = new Timeline(
//                new KeyFrame(Duration.seconds(0), new KeyValue(volumeProperty, d1)),
//                new KeyFrame(Duration.seconds(3), new KeyValue(volumeProperty, d2))
//        );
//
//        fadeOutTimeline.play();
//    }


    @FXML
    private void handleMousePressed2(MouseEvent event){
        CharacterController.FlipCharacter();
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
        dropRod();

//        moveTimeLine.play();
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
    public void dropRod() {
        System.out.println("hello1");
        double pivotX = rod.getX(); // X coordinate of the lower end
        double pivotY = rod.getY() + rod.getHeight(); // Y coordinate of the lower end
        Rotate rotate = new Rotate(0, pivotX, pivotY); // Initial rotation angle is 0
        rod.getTransforms().clear(); // Clear existing transforms
        rod.getTransforms().add(rotate); // Apply the new rotation transform

        // Gradually rotate the rod to be horizontal
        Duration duration = Duration.millis(500); // Duration for the drop animation
        int angle = 90; // The final angle for the rotation

        KeyValue keyValue = new KeyValue(rotate.angleProperty(), angle);
        KeyFrame keyFrame = new KeyFrame(duration, keyValue);

        Timeline timeline = new Timeline(keyFrame);


        timeline.setOnFinished(e-> {
            try {
                movePlayer();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        timeline.play();


    }

    Runnable playerMovement = () -> {

        TranslateTransition movePlayerForward = new TranslateTransition(Duration.millis(1000), new_player);
        movePlayerForward.setByX(rod.getHeight()); // Adjust the distance the player moves forward

        movePlayerForward.setOnFinished(event -> movePlatforms());
        for (int i = 0 ; i<cherry_array.size() ; i++){
            if (cherry_array.get(i).getX() < Platforms.get(current_Platform+1).getX() && Platforms.get(current_Platform).getX() + Platforms.get(current_Platform).getWidth() < cherry_array.get(i).getX()){
                cherry_counter = i ;
                break;
            }
        }
        new_player.boundsInParentProperty().addListener((obs, init_pos,final_pos) -> {
            if (final_pos.intersects((cherry_array.get(cherry_counter)).getBoundsInParent())){
                increaseCherryCount();
                group1.getChildren().remove(cherry_array.get(cherry_counter));
                cherry_array.remove(cherry_array.get(cherry_counter));

                cherry_array.get(cherry_counter).getSound();
            }
        });

        movePlayerForward.play();
    };

    public void movePlayer() throws InterruptedException {
        Thread playerForward = new Thread(playerMovement);

        playerForward.start();


    }



    public void movePlatforms(){

        if (isPlayerOnPlatform() && new_player.getPlayer_down_state() == 1){
            new_player.player_fall();
            try {
                Ending_Scene();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        TranslateTransition movePlayerBackwards = new TranslateTransition(Duration.millis(500), new_player);
        movePlayerBackwards.setByX(-rod.getHeight());
        TransitionArray.add(movePlayerBackwards);
        for (int i = 0; i<Platforms.size() ; i++) {
            TranslateTransition moveTransition = new TranslateTransition(Duration.millis(500) , Platforms.get(i));
            moveTransition.setByX(-rod.getHeight()); // Adjust the movement speed of rectangles
            System.out.println("l1");
            TransitionArray.add(moveTransition);
            System.out.println("l2");
        }

        for (int i = 0; i<cherry_array.size() ; i++){
            TranslateTransition moveTransition = new TranslateTransition(Duration.millis(500) , cherry_array.get(i));
            moveTransition.setByX(-rod.getHeight());
            TransitionArray.add(moveTransition);


        }


//        TranslateTransition movePlayer = new TranslateTransition(Duration.millis(500) , new_player);
//        System.out.println(new_player.getX());
//        movePlayer.setByX(300+Platforms.get(current_Platform+1).getWidth() - rod.getHeight() - Platforms.get(current_Platform).getWidth());
//
//        TransitionArray.add(movePlayer);


        TranslateTransition moveRod = new TranslateTransition(Duration.millis(500),rod);
        moveRod.setByX(-rod.getHeight());

        moveRod.setOnFinished(event -> {


            new_player.setCurrent_pillar(Platforms.get(current_Platform));
            new_player.setNext_pillar(Platforms.get(current_Platform+1));
            System.out.println("The rod lenght is : " + rod_length);
            System.out.println("The width of the tower is :"+Platforms.get(current_Platform+1).getWidth());
            if (rod_length < Platforms.get(current_Platform+1).getX() - Platforms.get(current_Platform).getX() - Platforms.get(current_Platform).getWidth() +5  || rod_length > Platforms.get(current_Platform+1).getX() - Platforms.get(current_Platform).getX() + Platforms.get(current_Platform+1).getWidth() - Platforms.get(current_Platform).getWidth()){
                System.out.println("died");
                new_player.player_fall();
                try {
                    Ending_Scene();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            else{


                double newX = Platforms.get(current_Platform+1).getX() - Platforms.get(current_Platform).getX() + Platforms.get(current_Platform + 1).getWidth() - rod_length - Platforms.get(current_Platform).getWidth();


                System.out.println("This is the x coordinate the player: " + new_player.getX());

                for (int i = 0 ; i< cherry_array.size() ; i++){
                    System.out.println("this is the cherry - " +i+ "x coordinates "+cherry_array.get(i).getX());

                }

                String text = dynamicText.getText();
                int x = 0;
                try{
                    x = Integer.parseInt(text);
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }

                setDynamicText(x+1);


                System.out.println("hjfefe");


                Rectangle new_rod = new Rectangle(5, 100, Color.BLACK);
                new_rod.setHeight(2);
                new_rod.setX(96);
                new_rod.setY(457);



                TransitionArray.clear();

                for (int i = 0; i<Platforms.size() ; i++) {
                    TranslateTransition moveTransition = new TranslateTransition(Duration.millis(500) , Platforms.get(i));
                    moveTransition.setByX(-newX); // Adjust the movement speed of rectangles
                    System.out.println("l1");
                    TransitionArray.add(moveTransition);
                    System.out.println("l2");
                }

                for (int i = 0 ; i <cherry_array.size() ;i++){
                    TranslateTransition moveTransition = new TranslateTransition(Duration.millis(500) , cherry_array.get(i));
                    moveTransition.setByX(-newX);
                    TransitionArray.add(moveTransition);
                }

                TranslateTransition moveRod1 = new TranslateTransition(Duration.millis(500), rod);
                moveRod1.setByX(-newX);
                TransitionArray.add(moveRod1);

                for (int i = 0; i<TransitionArray.size() ; i++){
                    TransitionArray.get(i).play();
                }

                TransitionArray.clear();

                rod = new_rod;

                group1.getChildren().add(rod);

                current_Platform ++ ;




            }



        });

        TransitionArray.add(moveRod);
        for (int i = 0; i<TransitionArray.size() ; i++){
            TransitionArray.get(i).play();
        }
        System.out.println(new_player.getX());

//        group1.getChildren().remove(rod);
        rod_length = rod.getHeight();



    }

    public void playMoveTransition(){

    }


    public void PauseMenu() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Pause-Screen.fxml"));
        Parent pauseMenuRoot = loader.load();

        pauseMenuStage = new Stage();
        pauseMenuStage.initModality(Modality.APPLICATION_MODAL);
        pauseMenuStage.initOwner(stage);
        Scene pauseMenuScene = new Scene(pauseMenuRoot);
        Image icon = new Image("stickhero_charcater-removebg-preview.png") ;
        pauseMenuStage.getIcons().add(icon);
        pauseMenuScene.setFill(Color.TRANSPARENT);
        pauseMenuStage.initStyle(StageStyle.TRANSPARENT);
//        pauseMenuStage.setWidth(400);
//        pauseMenuStage.setHeight(300);
        pauseMenuStage.setResizable(false);
        BoxBlur blur = new BoxBlur(3,3,3);
        scene.getRoot().setEffect(blur);


        FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000), pauseMenuRoot);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);

        // Play the fade in transition
        fadeInTransition.play();



        // Show the pop-up

        pauseMenuStage.setOnCloseRequest(Event::consume);
        pauseMenuStage.initStyle(StageStyle.UNDECORATED); // this removes the close window button

        mediaPlayer.setVolume(0.2);
        pauseMenuStage.setScene(pauseMenuScene);
        pauseMenuStage.show();

    }

    public void Ending_Scene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ending_screen.fxml"));
        Parent EndingSceneRoot = loader.load();
        endingSceneStage = new Stage();
        endingSceneStage.initModality(Modality.APPLICATION_MODAL);
//        endingSceneStage.initOwner(stage);
        Scene endingScene = new Scene(EndingSceneRoot);
        Image icon = new Image("stickhero_charcater-removebg-preview.png") ;
        endingSceneStage.getIcons().add(icon);
        endingScene.setFill(Color.TRANSPARENT);
        endingSceneStage.initStyle(StageStyle.TRANSPARENT);


//        endingSceneStage.setWidth(500);
//        endingSceneStage.setHeight(800);
        endingSceneStage.setResizable(false);
        BoxBlur blur = new BoxBlur(3,3,3);
//        scene.getRoot().setEffect(blur);


        FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000), EndingSceneRoot);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);

        // Play the fade in transition
        fadeInTransition.play();



        // Show the pop-up

        endingSceneStage.setOnCloseRequest(Event::consume);
        endingSceneStage.initStyle(StageStyle.UNDECORATED); // this removes the close window button

        mediaPlayer.setVolume(0.1);
        endingSceneStage.setScene(endingScene);
        endingSceneStage.show();





    }

    public void increaseCherryCount(){
        String text = dynamicCherryText.getText();
        int x = 0;
        try{
            x = Integer.parseInt(text);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }

        setDynamicCherryText(x+1);

    }


    public void clearAll(ActionEvent event) throws IOException {
        endingSceneStage.close();
        Platforms.clear();
        group1.getChildren().clear();
        endingSceneStage.close();
        general_initializer();


    }

    public boolean isPlayerOnPlatform() {
        for (Rectangle platform : Platforms) {
            if (new_player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }






}