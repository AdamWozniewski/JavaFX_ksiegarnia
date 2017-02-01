package KsiegarniaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
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
        BorderPane layout_admin = new BorderPane();

        Scene login = new Scene(layout_login,300,300);
        Scene s1= new Scene(layout,600,600);
        Scene s2= new Scene(layout_admin,600,600);

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
        tablicaUzytkowników.add(new Users("ziomek1","ziomek1","ziomek1"));
        tablicaUzytkowników.add(new Users("admin","admin","admin"));




        Button b0 =new Button("Wypożycz");
        Button b1 =new Button("Dostępne");
        Button b2 =new Button("Doładuj Portfel");
        Button b3 =new Button("Kwota w portfelu");
        Button b4 =new Button("Wyloguj");


        Button admin_allBook= new Button("W magazynie");
        Button admin_allUsers= new Button("Lista Użytkowników");
        Button admin_addBook= new Button("Dodaj Książkę");
        Button admin_wylog= new Button("Wyloguj");



        // WYLOGOWANIE SIE



        b0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox vb =new VBox();
                HBox hb =new HBox();
                int i=0;
                for (Ksiazka ks: tablicaKsiazek) {
                    boolean status;
                    CheckBox ksBox=new CheckBox(ks.getTitle());
                    if(ks.getAccess()!=false){

                        ksBox.setSelected(true);
                        status=true;
                    }
                    else{

                        ksBox.setSelected(false);
                        status=false;
                    }
                    vb.getChildren().addAll(ksBox);

                    ksBox.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if(status == false){
                                ksBox.setSelected(true);
                                ks.changeAccess(true);
                            }
                            else{
                                ksBox.setSelected(false);
                                ks.changeAccess(false);

                            }

                        }
                    });

                    i++;
                }

                vb.setAlignment(Pos.CENTER);
                layout.setCenter(vb);
            }
        });

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                VBox vBoxAllKnigi=new VBox();
                Label[] lab;
//                lab = new Label[tablicaKsiazek.size()];
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



        admin_allBook.setOnAction(new EventHandler<ActionEvent>() {
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
                layout_admin.setCenter(vBoxAllKnigi);
            }
        });

        admin_allUsers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox vBoxAllKnigi=new VBox();
                Label[] lab;
                lab = new Label[tablicaKsiazek.size()];
                for (Users ks:tablicaUzytkowników) {
                    if(ks.getName().equals("admin")){
                        vBoxAllKnigi.getChildren().add(new Label("++++++  "+ks.getName()+"  ++++++"));
                    }
                    else{
                        vBoxAllKnigi.getChildren().add(new Label(ks.getName()));
                    }
                }

                vBoxAllKnigi.setAlignment(Pos.CENTER);
                layout_admin.setCenter(vBoxAllKnigi);
            }
        });

        admin_addBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button dodaj=new Button("Dodaj");

                Label writeHere=new Label("Tu wpisz kolejno :");

                TextField adminID=new TextField("Wpisz ID");
                TextField adminTitle=new TextField("Wpisz tytuł");
                TextField adminAuthor=new TextField("Wpisz Autora");
                TextField adminisbn=new TextField("Wpisz isbn");

                VBox vBoxAddBook=new VBox();
                vBoxAddBook.getChildren().addAll(writeHere,adminID,adminTitle,adminAuthor,adminisbn,dodaj);
                vBoxAddBook.setAlignment(Pos.CENTER);

                dodaj.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        int idParseInt=Integer.parseInt(adminID.getText());
                        tablicaKsiazek.add(new Ksiazka(idParseInt,adminTitle.getText(),adminAuthor.getText(),
                                adminisbn.getText()));
                    }
                });

                layout_admin.setCenter(vBoxAddBook);
            }
        });

        HBox buttonVBox=new HBox();
//        buttonVBox.getChildren().addAll(b0,b1,b2,b3);
//        layout.setTop(buttonVBox);


        VBox vBoxLogin=new VBox();
        vBoxLogin.getChildren().addAll(loginTF,psswdTF,getLogin);
        layout_login.setCenter(vBoxLogin);
        vBoxLogin.setAlignment(Pos.CENTER);

        HBox adminHBox=new HBox();
//        adminHBox.getChildren().addAll();
//        adminHBox.setAlignment(Pos.CENTER);
//        layout_admin.setTop(adminHBox);


        primaryStage.setScene(login);



//        Budowanie scen
//        uzytkownik

        buttonVBox.getChildren().addAll(b0,b1,b2,b3,b4);
        buttonVBox.setAlignment(Pos.CENTER);
        layout.setTop(buttonVBox);

//        admin

        adminHBox.getChildren().addAll(admin_allBook,admin_allUsers,admin_addBook,admin_wylog);
        adminHBox.setAlignment(Pos.CENTER);
        layout_admin.setTop(adminHBox);


        getLogin.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                boolean IfAdmin;
                for (Users us:tablicaUzytkowników) {
                    if(loginTF.getText().equals(us.getName()) && psswdTF.getText().equals(us.getPsswd())){
                        if (loginTF.getText().equals("admin")){

                            //ADMIN


                            primaryStage.setScene(s2);
                        }
                        else {


                            primaryStage.setScene(s1);

                        }
                        break;
                    }
                }

            }
        });

        admin_wylog.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(login);
                loginTF.setText("Podaj login");
                psswdTF.setText("Podaj hasło");

            }
        });
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(login);
                loginTF.setText("Podaj login");
                psswdTF.setText("Podaj hasło");
            }
        });
        primaryStage.setTitle("Księgarnia On-line");
        primaryStage.show();
    }


}
