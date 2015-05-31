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

public class Main extends Application {

    Scene scene1, scene2, scene3;
    Stage theStage;

    @FXML private Button player1;
    @FXML private Button player2;

    // set private to prevent instantiation
    private Main() {}

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        this.theStage = primaryStage;

//        FXMLLoader loader = new FXMLLoader(getClass().getResource
//                ("carltron-game.fxml"));
//        Parent root = (Parent)loader.load();
//        GameManager gameManager = loader.getController();
//        root.setOnKeyPressed(gameManager);
//        primaryStage.setTitle("CarlTron");
//        primaryStage.setScene(new Scene(root, 800, 600));
//        primaryStage.setResizable(false);
//        primaryStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource
                ("carltron-menu.fxml"));
//        FXMLLoader loader2 = new FXMLLoader(getClass().getResource
//                ("carltron-game.fxml"));
//        FXMLLoader loader3 = new FXMLLoader(getClass().getResource
//                ("carltron-rules.fxml"));


        Parent root = (Parent)loader.load();
//        Parent root2 = (Parent)loader2.load();
//        Parent root3 = (Parent)loader3.load();

        this.scene1 = new Scene(root, 800, 600);
//        scene2 = new Scene(root2, 800, 600);
//        scene3 = new Scene(root3, 800, 600);

        Main new_main = loader.getController();
        new_main.setStage(primaryStage);
        //WindowNavigation windowNavigation = loader.getController();
        //windowNavigation.setStage(primaryStage);
        //GameManager gameManager = loader.getController();
        //root.setOnKeyPressed(windowNavigation);

        primaryStage.getIcons().add(new Image(getClass().getResource
                ("images/logo.png").toExternalForm()));
        primaryStage.setTitle("CarlTron");
        primaryStage.setScene(this.scene1);
        primaryStage.setResizable(false);
        setStage(primaryStage);
        primaryStage.show();
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

        //Main new_main = loader2.getController();
        //new_main.setStage(this.theStage);

        GameManager game_controller = loader2.getController();
        root2.setOnKeyPressed(game_controller);

        this.scene2 = new Scene(root2, 800, 600);
        this.theStage.setScene(this.scene2);
        this.theStage.show();
    }

    public void rulesClicked(ActionEvent e) throws Exception {
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource
                ("carltron-rules.fxml"));
        Parent root3 = (Parent)loader3.load();

        Main new_main = loader3.getController();
        new_main.setStage(this.theStage);

        this.scene3 = new Scene(root3, 800, 600);
        this.theStage.setScene(this.scene3);
        this.theStage.show();

    }

    public void onBackButton(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource
                ("carltron-menu.fxml"));
        Parent root = (Parent)loader.load();

        Main new_main = loader.getController();
        new_main.setStage(this.theStage);

        this.scene1 = new Scene(root, 800, 600);
        this.theStage.setScene(this.scene1);
        this.theStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
