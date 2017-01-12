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
        BorderPane layout_login = new BorderPane();

        Scene login = new Scene(layout_login,300,300);
        Scene s1= new Scene(layout,600,600);

        //Login
        TextField loginTF=new TextField("podaj login");
        TextField psswdTF=new TextField("podaj haslo");
        Button getLogin=new Button("zaloguj");





        // baza danych książek, moze być pobierane z innego pliku
        ArrayList<Ksiazka> tablicaKsiazek = new ArrayList<Ksiazka>();
        tablicaKsiazek.add(new Ksiazka(1,"Ksiazka 1","autor 1","81274h1h249102974"));
        tablicaKsiazek.add(new Ksiazka(2,"Ksiazka 2","autor 2","098sadgf98sdg980s"));

        // baza danych Użytkowników, moze być pobierane z innego pliku;
        ArrayList<Users> tablicaUzytkowników = new ArrayList<Users>();
        tablicaUzytkowników.add(new Users("ziome1","ziomek1","ziomek1"));
        tablicaUzytkowników.add(new Users("admin","admin","admin"));




        Button b0 =new Button("Dostępne");
        Button b1 =new Button("Wypożycz");
        Button b2 =new Button("Doładuj Portfel");
        Button b3 =new Button("Kwota w portfelu");

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                VBox vBoxAllKnigi=new VBox();
                Label[] lab;
                lab = new Label[tablicaKsiazek.size()];
                for (Ksiazka ks:tablicaKsiazek) {
                    if(ks.getAccess()==true){
                        vBoxAllKnigi.getChildren().add(new Label(ks.getTitle()));
                    }
                }

                vBoxAllKnigi.setAlignment(Pos.CENTER);
                layout.setCenter(vBoxAllKnigi);
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox vBoxWallet=new VBox();

                Label labelSetWallet = new Label("Wpisz kwotę za którą chcesz doładowac konto");
                TextField textFieldWallet= new TextField("Kwota: ");



                Button OK = new Button("Doładuj");
//
//                textFieldWallet.setText("text");
//
                OK.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        double hajs=Double.parseDouble(textFieldWallet.getText());
                        tablicaUzytkowników.get(0).upgradeWallet(hajs);
                    }
                });
                vBoxWallet.getChildren().addAll(labelSetWallet,textFieldWallet,OK);
                vBoxWallet.setAlignment(Pos.CENTER);
                layout.setCenter(vBoxWallet);
            }
        });

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox vBoxWallet=new VBox();
                Label labelWallet=new Label("Posiadasz :" + tablicaUzytkowników.get(0).getHajs());

                vBoxWallet.getChildren().addAll(labelWallet);
                vBoxWallet.setAlignment(Pos.CENTER);
                layout.setCenter(vBoxWallet);
            }
        });

        HBox buttonVBox=new HBox();
        buttonVBox.getChildren().addAll(b0,b1,b2,b3);

        layout.setTop(buttonVBox);


        VBox vBoxLogin=new VBox();
        vBoxLogin.getChildren().addAll(loginTF,psswdTF,getLogin);
        layout_login.setCenter(vBoxLogin);
        vBoxLogin.setAlignment(Pos.CENTER);


        primaryStage.setScene(login);

        getLogin.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                for (Users us:tablicaUzytkowników) {
                    if(loginTF.getText().equals(us.getName()) && psswdTF.getText().equals(us.getPsswd())){
                        primaryStage.setScene(s1);
                        break;
                    }
                }

            }
        });

        primaryStage.setTitle("Księgarnia On-line");
        primaryStage.show();
    }
}
