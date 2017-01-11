package KsiegarniaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.border.Border;
import java.util.ArrayList;
//import java.awt.*;

/**
 * Created by Adam on 08.01.2017.
 */
public class Aplikacja extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane layout = new BorderPane();
        Scene s1= new Scene(layout,600,600);

        // baza danych książek, moze być pobierane z innego pliku
        ArrayList<Ksiazka> tablicaKsiazek = new ArrayList<Ksiazka>();
        tablicaKsiazek.add(new Ksiazka(1,"Ksiazka 1","autor 1","81274h1h249102974"));
        tablicaKsiazek.add(new Ksiazka(2,"Ksiazka 2","autor 2","098sadgf98sdg980s"));

        // baza danych Użytkowników, moze być pobierane z innego pliku;
        ArrayList<Users> tablicaUżytkowników = new ArrayList<Users>();
        tablicaUżytkowników.add(new Users("ziome1","ziomek1","ziomek1"));
        tablicaUżytkowników.add(new Users("admin","admin","admin"));



        Button b0 =new Button("Dostępne");
        Button b1 =new Button("Wypożycz");
        Button b2 =new Button("Doładuj Portfel");
        Button b3 =new Button("Kwota w portfelu");

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox vBoxWallet=new VBox();

                Label labelSetWallet = new Label("Wpisz kwotę za którą chcesz doładowac konto");
                TextField textFieldWallet= new TextField("Kwota: ");

                textFieldWallet.getText();

//                textFieldWallet.setText("text");

                vBoxWallet.getChildren().addAll(labelSetWallet,textFieldWallet);
                vBoxWallet.setAlignment(Pos.CENTER);
                layout.setCenter(vBoxWallet);
            }
        });

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox vBoxWallet=new VBox();
                Label labelWallet=new Label("Posiadasz :" + tablicaUżytkowników.get(0).getHajs());

                vBoxWallet.getChildren().addAll(labelWallet);
                vBoxWallet.setAlignment(Pos.CENTER);
                layout.setCenter(vBoxWallet);
            }
        });

        HBox buttonVBox=new HBox();
        buttonVBox.getChildren().addAll(b0,b1,b2,b3);

        layout.setTop(buttonVBox);

        primaryStage.setScene(s1);
        primaryStage.setTitle("Księgarnia On-line");
        primaryStage.show();
    }
}
