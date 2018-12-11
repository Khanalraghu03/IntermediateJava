

package gui.basic;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;

//import javafx.scene.control.Button;

public class BasicWindow extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        Button button = new Button("OK"); //setText not found
//        Scene scene = new Scene(button, 200, 250);
        primaryStage.setTitle("Window Title");
//        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
