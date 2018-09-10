package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        File logFile = new File("C:/IMS/setup.txt");
        if(logFile.length() == 0)
        {
            try {

                Parent root = FXMLLoader.load(getClass().getResource("config.fxml"));
                Stage s = new Stage();
                s.setTitle("Configuration");
                s.setResizable(false);
                Image icon = new Image(getClass().getResourceAsStream("icon.png"));
                s.getIcons().add(icon);
                s.setScene(new Scene(root, 432, 411));
                s.show();
            } catch (Exception e) {
                System.out.println("Couldnt load window");

            }
        }
        else {
            Parent root = FXMLLoader.load(getClass().getResource("loggin.fxml"));

            primaryStage.setTitle("Login Window");
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.centerOnScreen();
            primaryStage.setScene(new Scene(root, 462, 400));
            primaryStage.show();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }



}