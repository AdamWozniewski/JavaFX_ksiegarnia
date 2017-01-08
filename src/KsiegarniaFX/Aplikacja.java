package KsiegarniaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.border.Border;

/**
 * Created by Adam on 08.01.2017.
 */
public class Aplikacja extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane layout = new BorderPane();
        Scene s1= new Scene(layout,600,600);

        
        primaryStage.setScene(s1);
        primaryStage.setTitle("Księgarnia On-line");
        primaryStage.show();
    }
}
