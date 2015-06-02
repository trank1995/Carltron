package carltron;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.*;
import javax.swing.text.html.ImageView;


import javafx.util.StringConverter;
public class WindowNavigation {

    Scene scene1, scene2, scene3, scene4;
    Stage theStage;
    GameManager game_controller;

    @FXML private Button player1;
    @FXML private Button player2;
    // @FXML private ImageView winner;
    @FXML private Button player1Score;
    @FXML private Button player2Score;
    @FXML public Button again;

    public WindowNavigation() {
        //this.again = new Button();
    }

    public void setStage(Stage primary) {
        this.theStage = primary;
    }


    public void pLayer1Clicked(ActionEvent e) throws Exception {
        //
    }

    public void player2Clicked(ActionEvent e) throws Exception {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource
                ("carltron-game.fxml"));
        Parent root2 = (Parent)loader2.load();

        game_controller = loader2.getController();
        game_controller.setStage(this.theStage);
        root2.setOnKeyPressed(game_controller);

        this.scene2 = new Scene(root2, 800, 600);
        this.theStage.setScene(this.scene2);
        this.theStage.show();
    }

    public void rulesClicked(ActionEvent e) throws Exception {
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource
                ("carltron-rules.fxml"));
        Parent root3 = (Parent)loader3.load();

        WindowNavigation new_window = loader3.getController();
        new_window.setStage(this.theStage);

        this.scene3 = new Scene(root3, 800, 600);
        this.theStage.setScene(this.scene3);
        this.theStage.show();

    }

    public void onBackButton(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource
                ("carltron-menu.fxml"));
        Parent root = (Parent)loader.load();

        WindowNavigation new_window = loader.getController();
        new_window.setStage(this.theStage);

        this.scene1 = new Scene(root, 800, 600);
        this.theStage.setScene(this.scene1);
        this.theStage.show();
    }


    public void victorPage(Stage theVictorStage, int won)
            throws Exception{
        //ystem.out.println(player2Score);
        FXMLLoader loaderp = new FXMLLoader(getClass().getResource
                ("done.fxml"));
        Image image;
        Parent root4 = (Parent)loaderp.load();
        System.out.println(won);
        if (won == 2) {
            image = new Image(getClass().getResourceAsStream("p2logo.png"));
            //this.p2scorecount = 1;
            //game_controller.setScores(this.p1scorecount,this.p2scorecount);
        }else if (won == 1){
            image = new Image(getClass().getResourceAsStream("p1logo.png"));
            //this.p1scorecount = 1;
            //game_controller.setScores(this.p1scorecount,this.p2scorecount);
        }else{
            image = new Image(getClass().getResourceAsStream("drawf.png"));
        }

        Button p1Score = new Button();
        Button p2Score = new Button();

        p1Score.setText(Integer.toString(1));
        p2Score.setText(Integer.toString(2));
        p1Score.setLayoutX(320);
        p1Score.setLayoutY(423);
        p2Score.setLayoutX(320);
        p2Score.setLayoutY(472);

        javafx.scene.image.ImageView iv = new javafx.scene.image.ImageView();
        AnchorPane root7 = (AnchorPane) root4;

        iv.setImage(image);
        iv.setFitWidth(141);
        iv.setFitHeight(22);
        iv.setLayoutX(159);
        iv.setLayoutY(300);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);

        root7.getChildren().add(iv);
        root7.getChildren().add(p1Score);
        root7.getChildren().add(p2Score);


        WindowNavigation new_window = loaderp.getController();
        new_window.setStage(theVictorStage);
        //this.player1Score.setText("meeee");
        //do stuff that changes the score and winner
        theVictorStage.setScene(new Scene(root7, 800, 600));

        theVictorStage.show();
    }

}
