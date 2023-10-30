package com.example.pentagram.frontend;
import com.example.pentagram.backend.*;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.ImagePattern;
import javafx.scene.layout.VBox;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import javafx.util.Callback;

import javafx.scene.control.Alert.AlertType;

public class login extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Login Page");
        Image login_backgroundImage = new Image("D:/Studies/sem5/java/pentagram/pics/login_final.JPG");
        BackgroundImage login_background = new BackgroundImage(
                login_backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                null,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        false
                )
        );

        Image input_backgroundImage = new Image("file:D:/Studies/sem5/java/pentagram/pics/login_rect.jpg");
        ImagePattern input_backgroundPattern = new ImagePattern(input_backgroundImage);
        Pane root = new Pane();
        root.setBackground(new Background(login_background));

        Scene login_page = new Scene(root,1300,750);

        Pane input_pane = new Pane();

        Rectangle input = new Rectangle();
        input.setX(105);
        input.setY(105);
        input.setWidth(400);
        input.setHeight(450);
        input.setArcWidth(20); // Set the width of the corner arc
        input.setArcHeight(20);
        input.setFill(input_backgroundPattern);
        input_pane.getChildren().addAll(input);

        Label log_in=new Label("Login");
        log_in.setLayoutX(270);
        log_in.setLayoutY(120);
        log_in.setStyle(" -fx-text-fill:#2C165C; -fx-font-size:30");

        Label username=new Label("Username or Email Address");
        username.setLayoutX(180);
        username.setLayoutY(170);
        username.setStyle(" -fx-text-fill:#2C165C; -fx-font-size:20");

        TextField username_input=new TextField();
        username_input.setLayoutX(190);
        username_input.setLayoutY(220);
        username_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");

        Line line1 = new Line();
        line1.setStartX(150);
        line1.setStartY(250);
        line1.setEndX(450);
        line1.setEndY(250);

        Label password=new Label("Password");
        password.setLayoutX(260);
        password.setLayoutY(280);
        password.setStyle(" -fx-text-fill:#2C165C; -fx-font-size:20");

        PasswordField password_input=new PasswordField();
        password_input.setLayoutX(190);
        password_input.setLayoutY(320);
        password_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");

        Line line2 = new Line();
        line2.setStartX(150);
        line2.setStartY(350);
        line2.setEndX(450);
        line2.setEndY(350);

        Button login_btn = new Button("Log In");
        login_btn.setLayoutX(265);
        login_btn.setLayoutY(400);
        login_btn.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");
        login_btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String username_str = username_input.getText();
                String password_str = password_input.getText();
                String res= DatabaseConfiguration_login.check_login(username_str,password_str);
                if(res.equals("user"))
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Username is incorrect");
                    alert.showAndWait();
                    username_input.clear();
                    password_input.clear();
                }
                else if(res.equals("true"))
                {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully logged in");
                    alert.showAndWait();
                    primaryStage.setTitle("Home page");
                    Pane home_pane = new Pane();
                    home_pane.setStyle("-fx-background-color: #E5E4E2;");
                    Scene home_scene = new Scene(home_pane,1300,750);

                    Pane post_pane = new Pane();

                    Rectangle details = new Rectangle();
                    details.setWidth(300);
                    details.setHeight(950);
                    details.setFill(Color.WHITE);
                    details.setX(0);
                    details.setY(0);




                    Image instag_logo = new Image("D:/Studies/sem5/java/pentagram/pics/insta_logo.PNG");
                    Image home = new Image("D:/Studies/sem5/java/pentagram/pics/home.PNG");
                    Image like = new Image("D:/Studies/sem5/java/pentagram/pics/like.JPG");
                    Image add_post = new Image("D:/Studies/sem5/java/pentagram/pics/add_post.PNG");
                    Image comment = new Image("D:/Studies/sem5/java/pentagram/pics/comment.PNG");
                    Image search = new Image("D:/Studies/sem5/java/pentagram/pics/search.PNG");
                    Image settings = new Image("D:/Studies/sem5/java/pentagram/pics/settings.PNG");
                    Image saved = new Image("D:/Studies/sem5/java/pentagram/pics/saved.PNG");
                    Image notification = new Image("D:/Studies/sem5/java/pentagram/pics/notification.PNG");
                    Image profile = new Image("D:/Studies/sem5/java/pentagram/pics/profile.PNG");
                    Image back_image = new Image("D:/Studies/sem5/java/pentagram/pics/back.PNG");
                    Image next_image = new Image("D:/Studies/sem5/java/pentagram/pics/next.png");


                    ImageView imageView_instag_logo = new ImageView(instag_logo);
                    ImageView imageView_home = new ImageView(home);
                    ImageView imageView_like = new ImageView(like);
                    ImageView imageView_add_post = new ImageView(add_post);
                    ImageView imageView_comment = new ImageView(comment);
                    ImageView imageView_search = new ImageView(search);
                    ImageView imageView_settings = new ImageView(settings);
                    ImageView imageView_saved = new ImageView(saved);
                    ImageView imageView_notification = new ImageView(notification);
                    ImageView imageView_profile = new ImageView(profile);
                    ImageView imageView_back = new ImageView(back_image);
                    ImageView imageView_next = new ImageView(next_image);


                    int desiredWidth=40;
                    int desiredHeight=40;


                    imageView_instag_logo.setFitWidth(desiredWidth);
                    imageView_instag_logo.setFitHeight(desiredHeight);
                    imageView_home.setFitWidth(desiredWidth);
                    imageView_home.setFitHeight(desiredHeight);
                    imageView_like.setFitWidth(desiredWidth);
                    imageView_like.setFitHeight(desiredHeight);
                    imageView_add_post.setFitWidth(desiredWidth);
                    imageView_add_post.setFitHeight(desiredHeight);
                    imageView_comment.setFitWidth(desiredWidth);
                    imageView_comment.setFitHeight(desiredHeight);
                    imageView_search.setFitWidth(desiredWidth);
                    imageView_search.setFitHeight(desiredHeight);
                    imageView_settings.setFitWidth(desiredWidth);
                    imageView_settings.setFitHeight(desiredHeight);
                    imageView_saved.setFitWidth(desiredWidth);
                    imageView_saved.setFitHeight(desiredHeight);
                    imageView_notification.setFitWidth(desiredWidth);
                    imageView_notification.setFitHeight(desiredHeight);
                    imageView_profile.setFitWidth(desiredWidth);
                    imageView_profile.setFitHeight(desiredHeight);
                    imageView_add_post.setFitWidth(desiredWidth);
                    imageView_add_post.setFitHeight(desiredHeight);
                    imageView_next.setFitWidth(50);
                    imageView_next.setFitHeight(50);
                    imageView_back.setFitWidth(50);
                    imageView_back.setFitHeight(50);


                    imageView_instag_logo.setLayoutX(30);
                    imageView_instag_logo.setLayoutY(30);
                    imageView_home.setLayoutX(40);
                    imageView_home.setLayoutY(340);
                    imageView_search.setLayoutX(40);
                    imageView_search.setLayoutY(400);
                    imageView_saved.setLayoutX(40);
                    imageView_saved.setLayoutY(460);
                    imageView_notification.setLayoutX(40);
                    imageView_notification.setLayoutY(520);
                    imageView_settings.setLayoutX(40);
                    imageView_settings.setLayoutY(580);
                    imageView_profile.setLayoutX(40);
                    imageView_profile.setLayoutY(640);
                    imageView_add_post.setLayoutX(40);
                    imageView_add_post.setLayoutY(700);



                    Label insta=new Label("Pentagram");
                    insta.setLayoutX(80);
                    insta.setLayoutY(35);
                    insta.setStyle(" -fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:20; -fx-font-family:Georgia; -fx-font-weight:bold");

                    Label user_name= new Label();
                    user_name.setLayoutX(80);
                    user_name.setLayoutY(300);
                    user_name.setText(username_str);
                    user_name.setStyle(" -fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:20; -fx-font-family:Georgia; -fx-font-weight:bold");

                    Button feed = new Button("Feed");
                    feed.setLayoutX(80);
                    feed.setLayoutY(345);
                    feed.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:16; -fx-font-family:Georgia" );


                    Button explore = new Button("Explore");
                    explore.setLayoutX(80);
                    explore.setLayoutY(405);
                    explore.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:16; -fx-font-family:Georgia" );


                    explore.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent Event) {
                           TableView<com.example.pentagram.backend.UserProfile> tableView = new TableView<>();
                            tableView.setStyle("-fx-font-family: Arial; -fx-font-size: 16px;");
                            tableView.setStyle("-fx-alignment: center;");

                            TableColumn<com.example.pentagram.backend.UserProfile, Image> profilePhotoColumn = new TableColumn<>("Profile photo");
                            profilePhotoColumn.setCellValueFactory(param -> {
                                // Here, we return the Image object from the local file path
                                Image profileImage = new Image("file:" + param.getValue().getProfilePhoto());
                                return new SimpleObjectProperty<>(profileImage);
                            });

                            profilePhotoColumn.setCellFactory(column -> {
                                return new TableCell<com.example.pentagram.backend.UserProfile, Image>() {
                                    private final ImageView imageView = new ImageView();

                                    @Override
                                    protected void updateItem(Image item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (empty || item == null) {
                                            setGraphic(null);
                                        } else {
                                            imageView.setImage(item);
                                            imageView.setFitWidth(50);
                                            imageView.setFitHeight(50);
                                            setGraphic(imageView);
                                        }
                                    }
                                };
                            });

                            TableColumn<com.example.pentagram.backend.UserProfile, String> usernameColumn = new TableColumn<>("Username");
                            usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

                            TableColumn<com.example.pentagram.backend.UserProfile, Button> viewProfileColumn = new TableColumn<>("View Profile");
                            viewProfileColumn.setCellValueFactory(new PropertyValueFactory<>("viewProfile"));

                            TableColumn<com.example.pentagram.backend.UserProfile, Button> followColumn = new TableColumn<>("Follow");
                            followColumn.setCellValueFactory(new PropertyValueFactory<>("follow"));

                            tableView.getColumns().addAll(profilePhotoColumn,usernameColumn, viewProfileColumn, followColumn);
                            tableView.setStyle("-fx-control-inner-background: #76D7C4; -fx-background-color: #76D7C4;");
                            List<UserProfile> userProfiles = DatabaseConfiguration_feedpage.fetchUserDataFromDatabase();
                            tableView.getItems().addAll(userProfiles);
                            tableView.setPrefWidth(1200); // Set the width to 600 pixels
                            tableView.setPrefHeight(750); // Set the height to 400 pixels
                            profilePhotoColumn.setPrefWidth(300); // Set the width for Profile Photo column to 100 pixels
                            usernameColumn.setPrefWidth(300);     // Set the width for Username column to 150 pixels
                            viewProfileColumn.setPrefWidth(300);   // Set the width for View Profile column to 200 pixels
                            followColumn.setPrefWidth(300);        // Set the width for Follow column to 80 pixels

                            VBox vBox = new VBox(tableView);
                            vBox.setLayoutY(25);
                            vBox.setLayoutX(325);

                            home_pane.getChildren().addAll(vBox);
                        }
                    });

                    Button collection = new Button("Collection");
                    collection.setLayoutX(80);
                    collection.setLayoutY(465);
                    collection.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:16; -fx-font-family:Georgia" );


                    Button notification_btn = new Button("Notification");
                    notification_btn.setLayoutX(80);
                    notification_btn.setLayoutY(525);
                    notification_btn.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:16; -fx-font-family:Georgia" );


                    Button settings_btn = new Button("Settings");
                    settings_btn.setLayoutX(80);
                    settings_btn.setLayoutY(585);
                    settings_btn.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:16; -fx-font-family:Georgia" );


                    Button profile_btn = new Button("Profile");
                    profile_btn.setLayoutX(80);
                    profile_btn.setLayoutY(645);
                    profile_btn.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:16; -fx-font-family:Georgia" );


                    Button post = new Button("New post");
                    post.setLayoutX(80);
                    post.setLayoutY(705);
                    post.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:16; -fx-font-family:Georgia" );


                    Rectangle post1 = new Rectangle();
                    post1.setWidth(300);
                    post1.setHeight(300);
                    post1.setFill(Color.WHITE);
                    post1.setX(325);
                    post1.setY(25);

                    Rectangle post2 = new Rectangle();
                    post2.setWidth(300);
                    post2.setHeight(300);
                    post2.setFill(Color.WHITE);
                    post2.setX(650);
                    post2.setY(25);

                    Rectangle post3 = new Rectangle();
                    post3.setWidth(300);
                    post3.setHeight(300);
                    post3.setFill(Color.WHITE);
                    post3.setX(975);
                    post3.setY(25);

                    Rectangle post4 = new Rectangle();
                    post4.setWidth(300);
                    post4.setHeight(300);
                    post4.setFill(Color.WHITE);
                    post4.setX(325);
                    post4.setY(350);

                    Rectangle post5 = new Rectangle();
                    post5.setWidth(300);
                    post5.setHeight(300);
                    post5.setFill(Color.WHITE);
                    post5.setX(650);
                    post5.setY(350);

                    Rectangle post6 = new Rectangle();
                    post6.setWidth(300);
                    post6.setHeight(300);
                    post6.setFill(Color.WHITE);
                    post6.setX(975);
                    post6.setY(350);


                    post_pane.getChildren().addAll(post1,post2,post3,post4,post5,post6,explore);
                    home_pane.getChildren().addAll(details,insta,imageView_instag_logo,user_name,imageView_home,imageView_search,imageView_saved,imageView_notification,imageView_settings,imageView_profile,imageView_add_post,feed,collection,post,notification_btn,settings_btn,profile_btn,post_pane);
                    primaryStage.setScene(home_scene);
                }
                else if(res.equals("false"))
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Username and password doesn't match");
                    alert.showAndWait();
                    password_input.clear();
                }
            }
        });
        Button forgot_btn = new Button("Forgot password?");
        forgot_btn.setLayoutX(235);
        forgot_btn.setLayoutY(460);
        forgot_btn.setStyle("-fx-text-fill:#2C165C; -fx-font-size:15");
        forgot_btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Forgot password page");
                Pane forgot_pane = new Pane();

                Rectangle password_change = new Rectangle();
                password_change.setX(105);
                password_change.setY(105);
                password_change.setWidth(400);
                password_change.setHeight(450);
                password_change.setArcWidth(20); // Set the width of the corner arc
                password_change.setArcHeight(20);
                password_change.setFill(input_backgroundPattern);
                forgot_pane.getChildren().addAll(password_change);


                Label forgot_password=new Label("Forgot Password");
                forgot_password.setLayoutX(215);
                forgot_password.setLayoutY(120);
                forgot_password.setStyle("-fx-text-fill:#2C165C; -fx-font-size:25");

                Label user_forget=new Label("Username");
                user_forget.setLayoutX(160);
                user_forget.setLayoutY(180);
                user_forget.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                TextField user_forget_input=new TextField();
                user_forget_input.setLayoutX(270);
                user_forget_input.setLayoutY(180);
                user_forget_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");

                Line line3 = new Line();
                line3.setStartX(270);
                line3.setStartY(211);
                line3.setEndX(455);
                line3.setEndY(211);

                Label school=new Label("Institution");
                school.setLayoutX(160);
                school.setLayoutY(250);
                school.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                TextField school_input=new TextField();
                school_input.setLayoutX(270);
                school_input.setLayoutY(250);
                school_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");

                Line line13 = new Line();
                line13.setStartX(270);
                line13.setStartY(280);
                line13.setEndX(455);
                line13.setEndY(280);


                Label nick_name=new Label("Nickname");
                nick_name.setLayoutX(160);
                nick_name.setLayoutY(320);
                nick_name.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                TextField nickname_input=new TextField();
                nickname_input.setLayoutX(270);
                nickname_input.setLayoutY(320);
                nickname_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");

                Line line4 = new Line();
                line4.setStartX(270);
                line4.setStartY(350);
                line4.setEndX(455);
                line4.setEndY(350);

                Button change_password = new Button("Submit");
                change_password.setLayoutX(265);
                change_password.setLayoutY(400);
                change_password.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                Button back_forgot = new Button("Back");
                back_forgot.setLayoutX(265);
                back_forgot.setLayoutY(460);
                back_forgot.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                back_forgot.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        root.getChildren().clear();
                        root.getChildren().add(input_pane);
                    }
                });

                change_password.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String user_forget_str = user_forget_input.getText();
                        String school_str = school_input.getText();
                        String nick_str = nickname_input.getText();
                        String res= DatabaseConfiguration_login.forgot_password(user_forget_str,school_str,nick_str);
                        if(res.equals("true"))
                        {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("Verified successfully");
                            alert.showAndWait();

                            Pane forgot_pane_1 = new Pane();

                            Rectangle password_change_1 = new Rectangle();
                            password_change_1.setX(105);
                            password_change_1.setY(105);
                            password_change_1.setWidth(400);
                            password_change_1.setHeight(450);
                            password_change_1.setArcWidth(20); // Set the width of the corner arc
                            password_change_1.setArcHeight(20);
                            password_change_1.setFill(input_backgroundPattern);
                            forgot_pane_1.getChildren().addAll(password_change_1);


                            Label change_password_label =new Label("Change Password");
                            change_password_label.setLayoutX(215);
                            change_password_label.setLayoutY(120);
                            change_password_label.setStyle("-fx-text-fill:#2C165C; -fx-font-size:25");

                            Label user_change=new Label("Username");
                            user_change.setLayoutX(200);
                            user_change.setLayoutY(180);
                            user_change.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                            TextField user_change_input=new TextField();
                            user_change_input.setLayoutX(200);
                            user_change_input.setLayoutY(220);
                            user_change_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");

                            Line line14 = new Line();
                            line14.setStartX(200);
                            line14.setStartY(250);
                            line14.setEndX(385);
                            line14.setEndY(250);

                            Label new_password=new Label("New Password");
                            new_password.setLayoutX(200);
                            new_password.setLayoutY(260);
                            new_password.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                            PasswordField new_password_input=new PasswordField();
                            new_password_input.setLayoutX(200);
                            new_password_input.setLayoutY(300);
                            new_password_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");

                            Line line15 = new Line();
                            line15.setStartX(200);
                            line15.setStartY(330);
                            line15.setEndX(385);
                            line15.setEndY(330);

                            Label confirm_password=new Label("Confirm password");
                            confirm_password.setLayoutX(200);
                            confirm_password.setLayoutY(340);
                            confirm_password.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                            PasswordField confirm_password_input=new PasswordField();
                            confirm_password_input.setLayoutX(200);
                            confirm_password_input.setLayoutY(380);
                            confirm_password_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");

                            Line line16 = new Line();
                            line16.setStartX(200);
                            line16.setStartY(410);
                            line16.setEndX(385);
                            line16.setEndY(410);

                            Button change_password_btn = new Button("Submit");
                            change_password_btn.setLayoutX(265);
                            change_password_btn.setLayoutY(440);
                            change_password_btn.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                            change_password_btn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {

                                    String user_change_str =user_change_input.getText();
                                    String new_password_str = new_password_input.getText();
                                    String confirm_password_str = confirm_password_input.getText();
                                    if(confirm_password_str.equals(new_password_str)) {
                                        String res= DatabaseConfiguration_login.change_password(user_change_str, new_password_str);
                                        if (res.equals("true")) {
                                            Alert alert = new Alert(AlertType.INFORMATION);
                                            alert.setTitle("Information Dialog");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Password changed successfully");
                                            alert.showAndWait();
                                            root.getChildren().clear();
                                            root.getChildren().add(input_pane);
                                        }
                                        else if(res.equals("false"))
                                        {
                                            Alert alert = new Alert(AlertType.ERROR);
                                            alert.setTitle("Retry");
                                            alert.setHeaderText(null);
                                            alert.setContentText("We are encountering issue in database,Please try again!");
                                            alert.showAndWait();
                                            root.getChildren().clear();
                                            root.getChildren().add(input_pane);
                                        }
                                        else if(res.equals("user"))
                                        {
                                            Alert alert = new Alert(AlertType.ERROR);
                                            alert.setTitle("Information Dialog");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Username is incorrect");
                                            alert.showAndWait();
                                            user_change_input.clear();
                                        }

                                    }
                                    else
                                    {
                                        Alert alert = new Alert(AlertType.ERROR);
                                        alert.setTitle("Information Dialog");
                                        alert.setHeaderText(null);
                                        alert.setContentText("New password and confirm password doesn't matches");
                                        alert.showAndWait();
                                        new_password_input.clear();
                                        confirm_password_input.clear();

                                    }

                                }
                            });

                            forgot_pane_1.getChildren().addAll(change_password_label,user_change,user_change_input,line14,new_password,new_password_input,line15,confirm_password,confirm_password_input,line16,change_password_btn);
                            root.getChildren().add(forgot_pane_1);
                        }
                        else
                        {
                            if(res.equals("nickname"))
                            {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("Nickname is incorrect");
                            alert.showAndWait();
                            nickname_input.clear();
                            } else if (res.equals("user")) {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Information Dialog");
                                alert.setHeaderText(null);
                                alert.setContentText("User name is incorrect");
                                alert.showAndWait();
                                user_forget_input.clear();
                                nickname_input.clear();
                                school_input.clear();
                            } else if (res.equals("institution")) {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Information Dialog");
                                alert.setHeaderText(null);
                                alert.setContentText("institution name is incorrect");
                                alert.showAndWait();
                                school_input.clear();
                            } else if (res.equals("false")) {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Information Dialog");
                                alert.setHeaderText(null);
                                alert.setContentText("Information provided are incorrect");
                                alert.showAndWait();
                                nickname_input.clear();
                                school_input.clear();
                            }
                        }

                    }
                });

                forgot_pane.getChildren().addAll(forgot_password,school_input,school,nickname_input,nick_name,change_password,line3,line4,back_forgot,user_forget_input,user_forget,line13);
                root.getChildren().add(forgot_pane);
            }
        });
        Button signup_btn = new Button("Doesn't have an account? Create account");
        signup_btn.setLayoutX(160);
        signup_btn.setLayoutY(500);
        signup_btn.setStyle(" -fx-text-fill:#2C165C; -fx-font-size:15");
        signup_btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Sign up page");
                Pane signup1_pane = new Pane();

                Rectangle signup1_rect = new Rectangle();
                signup1_rect.setX(105);
                signup1_rect.setY(105);
                signup1_rect.setWidth(400);
                signup1_rect.setHeight(450);
                signup1_rect.setArcWidth(20); // Set the width of the corner arc
                signup1_rect.setArcHeight(20);
                signup1_rect.setFill(input_backgroundPattern);
                signup1_pane.getChildren().addAll(signup1_rect);


                Label signup1_label=new Label("Sign UP");
                signup1_label.setLayoutX(255);
                signup1_label.setLayoutY(120);
                signup1_label.setStyle("-fx-text-fill:#2C165C; -fx-font-size:25");

                Label mailid=new Label("Mail id");
                mailid.setLayoutX(160);
                mailid.setLayoutY(180);
                mailid.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                TextField mailid_input=new TextField();
                mailid_input.setLayoutX(270);
                mailid_input.setLayoutY(180);
                mailid_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");



                Line line5 = new Line();
                line5.setStartX(270);
                line5.setStartY(210);
                line5.setEndX(455);
                line5.setEndY(210);

                Label full_name=new Label("Full name");
                full_name.setLayoutX(160);
                full_name.setLayoutY(250);
                full_name.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                TextField fullname_input=new TextField();
                fullname_input.setLayoutX(270);
                fullname_input.setLayoutY(250);
                fullname_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");



                Line line6 = new Line();
                line6.setStartX(270);
                line6.setStartY(280);
                line6.setEndX(455);
                line6.setEndY(280);

                Label signup_username=new Label("Username");
                signup_username.setLayoutX(160);
                signup_username.setLayoutY(320);
                signup_username.setStyle(" -fx-text-fill:#2C165C; -fx-font-size:20");

                TextField signup_username_input=new TextField();
                signup_username_input.setLayoutX(270);
                signup_username_input.setLayoutY(320);
                signup_username_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");



                Line line7 = new Line();
                line7.setStartX(270);
                line7.setStartY(350);
                line7.setEndX(455);
                line7.setEndY(350);

                Label signup_password=new Label("Password");
                signup_password.setLayoutX(160);
                signup_password.setLayoutY(390);
                signup_password.setStyle(" -fx-text-fill:#2C165C; -fx-font-size:20");

                PasswordField signup_password_input=new PasswordField();
                signup_password_input.setLayoutX(270);
                signup_password_input.setLayoutY(390);
                signup_password_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");


                Line line8 = new Line();
                line8.setStartX(270);
                line8.setStartY(420);
                line8.setEndX(455);
                line8.setEndY(420);

                Button next1_btn = new Button("Next");
                next1_btn.setLayoutX(375);
                next1_btn.setLayoutY(460);
                next1_btn.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");
                next1_btn.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        primaryStage.setTitle("Sign up page");
                        Pane signup2_pane = new Pane();

                        Rectangle signup2_rect = new Rectangle();
                        signup2_rect.setX(105);
                        signup2_rect.setY(105);
                        signup2_rect.setWidth(400);
                        signup2_rect.setHeight(450);
                        signup2_rect.setArcWidth(20); // Set the width of the corner arc
                        signup2_rect.setArcHeight(20);
                        signup2_rect.setFill(input_backgroundPattern);
                        signup2_pane.getChildren().addAll(signup2_rect);


                        Label signup2_label=new Label("Sign UP");
                        signup2_label.setLayoutX(255);
                        signup2_label.setLayoutY(120);
                        signup2_label.setStyle("-fx-text-fill:#2C165C; -fx-font-size:25");

                        Label date=new Label("DOB");
                        date.setLayoutX(160);
                        date.setLayoutY(180);
                        date.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                        DatePicker datePicker = new DatePicker();

                        VBox vbox = new VBox(datePicker);
                        vbox.setLayoutX(270);
                        vbox.setLayoutY(180);


                        Label bio=new Label("Bio");
                        bio.setLayoutX(160);
                        bio.setLayoutY(250);
                        bio.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                        TextField bio_input=new TextField();
                        bio_input.setLayoutX(270);
                        bio_input.setLayoutY(250);
                        bio_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");


                        Line line9 = new Line();
                        line9.setStartX(270);
                        line9.setStartY(280);
                        line9.setEndX(455);
                        line9.setEndY(280);

                        Label insta_dp=new Label("Image path");
                        insta_dp.setLayoutX(160);
                        insta_dp.setLayoutY(320);
                        insta_dp.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                        TextField insta_dp_input=new TextField();
                        insta_dp_input.setLayoutX(270);
                        insta_dp_input.setLayoutY(320);
                        insta_dp_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");

                        Line line10 = new Line();
                        line10.setStartX(270);
                        line10.setStartY(350);
                        line10.setEndX(455);
                        line10.setEndY(350);

                        Label school_name=new Label("Institution");
                        school_name.setLayoutX(160);
                        school_name.setLayoutY(380);
                        school_name.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                        TextField scl_input=new TextField();
                        scl_input.setLayoutX(270);
                        scl_input.setLayoutY(380);
                        scl_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");

                        Line line11 = new Line();
                        line11.setStartX(270);
                        line11.setStartY(410);
                        line11.setEndX(455);
                        line11.setEndY(410);

                        Label nickname_label=new Label("Nickname");
                        nickname_label.setLayoutX(160);
                        nickname_label.setLayoutY(440);
                        nickname_label.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                        TextField nick_name_input=new TextField();
                        nick_name_input.setLayoutX(270);
                        nick_name_input.setLayoutY(440);
                        nick_name_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");

                        Line line12 = new Line();
                        line12.setStartX(270);
                        line12.setStartY(471);
                        line12.setEndX(455);
                        line12.setEndY(471);

                        Button next2_btn = new Button("Sign Up");
                        next2_btn.setLayoutX(370);
                        next2_btn.setLayoutY(500);
                        next2_btn.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                        next2_btn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {

                                LocalDate dob = datePicker.getValue();
                                String mailid_str=mailid_input.getText();
                                String fullname_str=fullname_input.getText();
                                String signup_username_str=signup_username_input.getText();
                                String signup_password_str=signup_password_input.getText();
                                String bio_str=bio_input.getText();
                                String insta_dp_str=insta_dp_input.getText();
                                String scl_name_str=scl_input.getText();
                                String nickname_str=nick_name_input.getText();
                                if(DatabaseConfiguration_login.check_user(signup_username_str))
                                {
                                    Alert alert = new Alert(AlertType.WARNING);
                                    alert.setTitle("Information Dialog");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Username already exist");
                                    alert.showAndWait();
                                }
                                else
                                {
                                    if(DatabaseConfiguration_login.Signup_backend(mailid_str,fullname_str,signup_username_str,signup_password_str,dob,bio_str,insta_dp_str,scl_name_str,nickname_str))
                                    {
                                        Alert alert = new Alert(AlertType.INFORMATION);
                                        alert.setTitle("Information Dialog");
                                        alert.setHeaderText(null);
                                        alert.setContentText("User registration successful!");
                                        alert.showAndWait();
                                    }
                                    else
                                    {
                                        Alert alert = new Alert(AlertType.ERROR);
                                        alert.setTitle("Retry");
                                        alert.setHeaderText(null);
                                        alert.setContentText("We are encountering issue in database,Please try again!");
                                        alert.showAndWait();
                                    }
                                    root.getChildren().clear();
                                    signup_btn.setText("Doesn't have an account? Create account");
                                    signup_btn.setLayoutX(160);
                                    signup_btn.setLayoutY(500);
                                    signup_btn.setStyle(" -fx-text-fill:#2C165C; -fx-font-size:15");
                                    input_pane.getChildren().remove(signup_btn);
                                    input_pane.getChildren().add(signup_btn);
                                    root.getChildren().add(input_pane);
                                }
                            }
                        });

                        signup_btn.setText("Back");
                        signup_btn.setLayoutX(145);
                        signup_btn.setLayoutY(500);
                        signup_btn.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                        signup2_pane.getChildren().addAll(signup2_label,date,vbox,bio,bio_input,line9,next2_btn,signup_btn,insta_dp_input,insta_dp,line10,school_name,scl_input,line11,nickname_label,line12,nick_name_input);
                        root.getChildren().add(signup2_pane);

                    }});
                Button back_home = new Button("Back");
                back_home.setLayoutX(175);
                back_home.setLayoutY(460);
                back_home.setStyle("-fx-text-fill:#2C165C; -fx-font-size:20");

                back_home.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        root.getChildren().clear();
                        signup_btn.setText("Doesn't have an account? Create account");
                        signup_btn.setLayoutX(160);
                        signup_btn.setLayoutY(500);
                        signup_btn.setStyle(" -fx-text-fill:#2C165C; -fx-font-size:15");
                        input_pane.getChildren().remove(signup_btn);
                        input_pane.getChildren().add(signup_btn);
                        root.getChildren().add(input_pane);
                    }
                });

                signup1_pane.getChildren().addAll(signup1_label,mailid,mailid_input,line5,full_name,fullname_input,line6,signup_username,signup_username_input,line7,signup_password,signup_password_input,line8,next1_btn,back_home);
                root.getChildren().add(signup1_pane);
            }
        });
        input_pane.getChildren().addAll(log_in,username,password,username_input,password_input,line1,line2,login_btn,signup_btn,forgot_btn);
        root.getChildren().add(input_pane);

        primaryStage.setScene(login_page);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
