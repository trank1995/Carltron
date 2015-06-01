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

public class Main extends Application {

    Scene scene1;
    Stage theStage;


    public Main() {
        //does nothing here
    }

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource
                ("carltron-menu.fxml"));

        Parent root = (Parent)loader.load();
        this.scene1 = new Scene(root, 800, 600);

        //creating a new window navigation object and setting the primary
        WindowNavigation new_window = loader.getController();
        new_window.setStage(primaryStage);

        //this sets the logo of the game to the custom logo
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

    public static void main(String[] args) {
        launch(args);
    }
}
