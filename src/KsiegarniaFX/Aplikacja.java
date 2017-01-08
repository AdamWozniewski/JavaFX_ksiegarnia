package KsiegarniaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.border.Border;
//import java.awt.*;

/**
 * Created by Adam on 08.01.2017.
 */
public class Aplikacja extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane layout = new BorderPane();
        Scene s1= new Scene(layout,600,600);

//        TextField tf1=new TextField("chuj");
        Button b0 =new Button("Dostępne");
        Button b1 =new Button("Wypożycz");
        Button b2 =new Button("Doładuj Portfel");
        Button b3 =new Button("Kwota w portfelu");
//        Button b4=new Button("Zakończ");

        HBox buttonVBox=new HBox();
        buttonVBox.getChildren().addAll(b0,b1,b2,b3);

        layout.setTop(buttonVBox);

        primaryStage.setScene(s1);
        primaryStage.setTitle("Księgarnia On-line");
        primaryStage.show();
    }
}
