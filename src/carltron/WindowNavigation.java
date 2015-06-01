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


    public void victorPage(Stage theVictorStage, int won) throws Exception{
        FXMLLoader loaderp = new FXMLLoader(getClass().getResource
                ("done.fxml"));

        Parent root4 = (Parent)loaderp.load();

        WindowNavigation new_window = loaderp.getController();
        new_window.setStage(theVictorStage);
        //this.player1Score.setText("meeee");
        //do stuff that changes the score and winner
        theVictorStage.setScene(new Scene(root4, 800, 600));

        theVictorStage.show();
    }

}
