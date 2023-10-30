package com.example.pentagram.frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.ImagePattern;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class feedpage extends Application {
    Label user_name;
    @Override
    public void start(Stage primaryStage) {

    }

    public void update(String s)
    {
        user_name= new Label(s);

    }
    public static void main(String[] args) {
        launch(args);
    }

}
