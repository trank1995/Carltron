/**
 * There are still some stuffs left to do
 * after version 1
 * (1) Switch to settings and switch back
 * (2) Pass data from settings to other classes
 * */
package carltron;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * WindowNavigation.java
 * This class integrated several fxml files and
 * let players switch between pages
 * June 1, 2015 - version 1
 * */
public class WindowNavigation {
    //Instance variables
    //pages contents
    Scene scene1, scene2, scene3, scene4;
    //use this object make page
    Stage theStage;
    //controller for the game page
    GameManager game_controller;
    //Instance variables end
    public  int f1;
    public int f2;


    @FXML private Button player1;
    @FXML private Button player2;
    // @FXML private ImageView winner;
    @FXML private Button player1Score;
    @FXML private Button player2Score;
    @FXML public Button again;

    public WindowNavigation() {
        //this.again = new Button();

    }

    /**
     * setStage(Stage) sets current stage as given stage.
     *
     * @param primary
     */
    public void setStage(Stage primary) {
        this.theStage = primary;
    }

    public void setScore(int p1, int p2){
        this.f1 = p1;
        this.f2 = p2;
    }
    /**
     * player1Clicked(ActionEvent): this part is not yet implemented in
     * version 1.
     *
     * @param e
     * @throws Exception
     */
    public void pLayer1Clicked(ActionEvent e) throws Exception {
        //load game page
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource
                ("carltron-game.fxml"));
        Parent root2 = (Parent)loader2.load();
        //prepare the controller
        game_controller = loader2.getController();
        game_controller.setStage(this.theStage);
        game_controller.setPlayerNumber(1);
        game_controller.setScore(this.f1, this.f2);
        game_controller.setGameManager(this.game_controller);
        root2.setOnKeyPressed(game_controller);
        //show the scene
        this.scene2 = new Scene(root2, 800, 600);
        this.theStage.setScene(this.scene2);
        this.theStage.show();
    }

    /**
     * player2Clicked(ActionEvent) creates a 2 players game upon request.
     *
     * @param e
     * @throws Exception
     */
    public void player2Clicked(ActionEvent e) throws Exception {
        //load game page
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource
                ("carltron-game.fxml"));
        Parent root2 = (Parent)loader2.load();
        //prepare the controller
        game_controller = loader2.getController();
        game_controller.setStage(this.theStage);
        game_controller.setPlayerNumber(2);
        game_controller.setScore(this.f1, this.f2);

        root2.setOnKeyPressed(game_controller);
        //show the scene
        this.scene2 = new Scene(root2, 800, 600);
        this.theStage.setScene(this.scene2);
        this.theStage.show();
    }

    /**
     * rulesClicked(ActionEvent) moves to the rule page upon request.
     *
     * @param e
     * @throws Exception
     */
    public void rulesClicked(ActionEvent e) throws Exception {
        //load the rule page
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource
                ("carltron-rules.fxml"));
        Parent root3 = (Parent)loader3.load();
        //prepare the controller
        WindowNavigation new_window = loader3.getController();
        new_window.setStage(this.theStage);
        //show the scene
        this.scene3 = new Scene(root3, 800, 600);
        this.theStage.setScene(this.scene3);
        this.theStage.show();

    }

    /**
     * onBackButton(ActionEvent) loads the main page upon request.
     *
     * @param e
     * @throws Exception
     */
    public void onBackButton(ActionEvent e) throws Exception {
        //load the menu page
        FXMLLoader loader = new FXMLLoader(getClass().getResource
                ("carltron-menu.fxml"));
        Parent root = (Parent)loader.load();
        //prepare the controller
        WindowNavigation new_window = loader.getController();
        new_window.setStage(this.theStage);
        //show the scene
        this.scene1 = new Scene(root, 800, 600);
        this.theStage.setScene(this.scene1);
        this.theStage.show();
    }

    /**
     * victorPage(Stage) loads the victory page when the game ends.
     *
     * @param theVictorStage
     * @param won
     * @throws Exception
     */
    public void victorPage(Stage theVictorStage, int won)
            throws Exception{
        //load the page
        FXMLLoader loaderp = new FXMLLoader(getClass().getResource
                ("done.fxml"));
        Image image;
        Parent root4 = (Parent)loaderp.load();
        //create the image depending on the winner
        if (won == 2) {
            //player2 won
            this.f2 = this.f2 + 1;
            image = new Image(getClass().getResourceAsStream("p2logo.png"));
        } else if (won == 1) {
            //player1 won
            this.f1 = this.f1 + 1;
            image = new Image(getClass().getResourceAsStream("p1logo.png"));
        } else {
            //tie
            image = new Image(getClass().getResourceAsStream("drawf.png"));
        }
        //use button to show score
        Button p1Score = new Button();
        Button p2Score = new Button();
        //show the score
        p1Score.setText(Integer.toString(this.f1));
        p2Score.setText(Integer.toString(this.f2));
        p1Score.setLayoutX(320);
        p1Score.setLayoutY(423);
        p2Score.setLayoutX(320);
        p2Score.setLayoutY(472);
        //create imageview object and anchorpane object
        javafx.scene.image.ImageView iv = new javafx.scene.image.ImageView();
        AnchorPane root7 = (AnchorPane) root4;
        //put the image in the imageview object
        iv.setImage(image);
        iv.setFitWidth(141);
        iv.setFitHeight(22);
        iv.setLayoutX(159);
        iv.setLayoutY(300);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
        //put imageview in anchorpane

        //creating medals and adding them to the frame depending on scores
        int scoreDef= this.f1 - this.f2;
        javafx.scene.image.ImageView medalP = new javafx.scene.image
                .ImageView();
        javafx.scene.image.ImageView medalg = new javafx.scene.image
                .ImageView();
        javafx.scene.image.ImageView medalo = new javafx.scene.image
                .ImageView();
        Image medalssilver;
        Image medalsgold;
        Image crown;

        //Checking the scoe difference and adding the right medals to the
        // right player depending on score.
        if (scoreDef >= 2){
            medalssilver = new Image(getClass().getResourceAsStream
                    ("silvermedal.png"));
            medalP.setImage(medalssilver);
            medalP.setFitWidth(45);
            medalP.setFitHeight(51);
            medalP.setPreserveRatio(true);
            medalP.setSmooth(true);
            medalP.setCache(true);
            medalP.setLayoutX(100);
            medalP.setLayoutY(411);
            root7.getChildren().add(medalP);
        }

        if (scoreDef <= -2){
            medalssilver = new Image(getClass().getResourceAsStream
                    ("silvermedal.png"));
            medalP.setImage(medalssilver);
            medalP.setFitWidth(45);
            medalP.setFitHeight(51);
            medalP.setPreserveRatio(true);
            medalP.setSmooth(true);
            medalP.setCache(true);
            medalP.setLayoutX(100);
            medalP.setLayoutY(469);
            root7.getChildren().add(medalP);
        }

        if (scoreDef >= 3){
            medalsgold = new Image(getClass().getResourceAsStream
                    ("GoldMedal.png"));
            medalg.setImage(medalsgold);
            medalg.setFitWidth(76);
            medalg.setFitHeight(51);
            medalg.setPreserveRatio(true);
            medalg.setSmooth(true);
            medalg.setCache(true);
            medalg.setLayoutX(43);
            medalg.setLayoutY(411);
            root7.getChildren().add(medalg);
        }

        if (scoreDef <= -3){
            medalsgold = new Image(getClass().getResourceAsStream
                    ("GoldMedal.png"));
            medalg.setImage(medalsgold);
            medalg.setFitWidth(76);
            medalg.setFitHeight(51);
            medalg.setPreserveRatio(true);
            medalg.setSmooth(true);
            medalg.setCache(true);
            medalg.setLayoutX(43);
            medalg.setLayoutY(469);
            root7.getChildren().add(medalg);
        }

        if (scoreDef >= 4){
            crown = new Image(getClass().getResourceAsStream
                    ("Crownmedal.png"));
            medalo.setImage(crown);
            medalo.setFitWidth(52);
            medalo.setFitHeight(44);
            medalo.setPreserveRatio(true);
            medalo.setSmooth(true);
            medalo.setCache(true);
            medalo.setLayoutX(374);
            medalo.setLayoutY(419);
            root7.getChildren().add(medalo);
        }

        if (scoreDef <= -4){
            crown = new Image(getClass().getResourceAsStream
                    ("Crownmedal.png"));
            medalo.setImage(crown);
            medalo.setFitWidth(52);
            medalo.setFitHeight(44);
            medalo.setPreserveRatio(true);
            medalo.setSmooth(true);
            medalo.setCache(true);
            medalo.setLayoutX(374);
            medalo.setLayoutY(466);
            root7.getChildren().add(medalo);
        }

        root7.getChildren().add(iv);
        root7.getChildren().add(p1Score);
        root7.getChildren().add(p2Score);


        WindowNavigation new_window = loaderp.getController();
        new_window.setStage(theVictorStage);
        new_window.setScore(this.f1, this.f2);
        //put the anchorpane in the scene and show it
        theVictorStage.setScene(new Scene(root7, 800, 600));
        theVictorStage.show();
    }
}
