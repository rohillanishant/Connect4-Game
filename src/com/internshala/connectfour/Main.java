package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootgridpane = loader.load();

        controller=loader.getController();
        controller.createPlayground();

        MenuBar menuBar=createmenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menupane= (Pane) rootgridpane.getChildren().get(0);
        menupane.getChildren().add(menuBar);

        Scene scene = new Scene(rootgridpane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private  MenuBar createmenu() {
        Menu fm= new Menu("File");
        MenuItem fm1=new MenuItem("New Game");
        fm1.setOnAction(event -> controller.resetGame());
        MenuItem fm2=new MenuItem("Reset Game");
        fm2.setOnAction(event -> controller.resetGame());
        SeparatorMenuItem sp = new SeparatorMenuItem();
        MenuItem fm3=new MenuItem("Exit Game");
        fm3.setOnAction(event -> exitgame());
        fm.getItems().addAll(fm1,fm2,sp,fm3);

        Menu hm= new Menu("Help");
        MenuItem hm1=new MenuItem(" About Connect4");
        hm1.setOnAction(event -> aboutconnect4());
        SeparatorMenuItem sp1 = new SeparatorMenuItem();
        MenuItem hm2=new MenuItem("About Me");
        hm2.setOnAction(event -> aboutme());
        hm.getItems().addAll(hm1,sp1,hm2);

        MenuBar menubar=new MenuBar();

        menubar.getMenus().addAll(fm,hm);
        return menubar;

    }

    private void aboutme() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Developer");
        alert.setHeaderText("Nishant Rohilla");
        alert.setContentText("This game is developed by Mr.Nishant Rohilla in June 2021 by learning from Internshala Core Java Course");
        alert.show();
    }

    private void aboutconnect4() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to Play?");
        alert.setContentText("Connect Four is a two-player game in which the player who first connected 4 same coloured discs will win");
        alert.show();
    }

    private void exitgame() {
        Platform.exit();
        System.exit(0);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
