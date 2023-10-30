package com.example.pentagram.frontend;
import com.example.pentagram.backend.*;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.ButtonType;


import javafx.util.Callback;

import javafx.scene.control.Alert.AlertType;

public class login extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Login Page");
        Image login_backgroundImage = new Image("D:/Studies/sem5/java/pentagram/pics/red_left.JPG");
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

        Image input_backgroundImage = new Image("file:D:/Studies/sem5/java/pentagram/pics/red_abs.jpg");
        ImagePattern input_backgroundPattern = new ImagePattern(input_backgroundImage);
        Pane root = new Pane();
        root.setBackground(new Background(login_background));

        Scene login_page = new Scene(root,1300,750);

        Pane input_pane = new Pane();

        Rectangle input = new Rectangle();
        input.setX(900);
        input.setY(105);
        input.setWidth(400);
        input.setHeight(450);
        input.setArcWidth(20); // Set the width of the corner arc
        input.setArcHeight(20);
        input.setFill(input_backgroundPattern);
        input_pane.getChildren().addAll(input);

        Label log_in=new Label("Login");
        log_in.setLayoutX(1070);
        log_in.setLayoutY(120);
        log_in.setStyle(" -fx-text-fill:#8B0000; -fx-font-size:30");

        Label username=new Label("Username or Email Address");
        username.setLayoutX(1000);
        username.setLayoutY(170);
        username.setStyle(" -fx-text-fill:#8B0000; -fx-font-size:20;-fx-font-family: 'Helvetica';");

        TextField username_input=new TextField();
        username_input.setLayoutX(1010);
        username_input.setLayoutY(220);
        username_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15 ;-fx-font-family: 'Helvetica';");

        Line line1 = new Line();
        line1.setStartX(1010);
        line1.setStartY(250);
        line1.setEndX(1200);
        line1.setEndY(250);

        Label password=new Label("Password");
        password.setLayoutX(1050);
        password.setLayoutY(280);
        password.setStyle(" -fx-text-fill:#8B0000; -fx-font-size:20 ");

        PasswordField password_input=new PasswordField();
        password_input.setLayoutX(1010);
        password_input.setLayoutY(320);
        password_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");

        Line line2 = new Line();
        line2.setStartX(1010);
        line2.setStartY(350);
        line2.setEndX(1200);
        line2.setEndY(350);

        /*final Button login_btn = new Button("View profile");
        login_btn.setMinWidth(50); // Set a minimum width for the button
        login_btn.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;");
        setGraphic(login_btn);
        setAlignment(Pos.CENTER); // Center-align the button
        login_btn.setOnMouseEntered(e -> login_btn.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;")); // Hover effect
        login_btn.setOnMouseExited(e -> login_btn.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;")); // Remove hover eff
*/
        Button login_btn = new Button("Log In");
        login_btn.setLayoutX(1060);
        login_btn.setLayoutY(400);
        login_btn.setStyle("-fx-background-color: #8B0000; -fx-text-fill: white; -fx-font-size:20");
        login_btn.setOnMouseEntered(e -> login_btn.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;-fx-font-size: 20;")); // Hover effect
        login_btn.setOnMouseExited(e -> login_btn.setStyle("-fx-background-color: #8B0000; -fx-text-fill: white;-fx-font-size: 20;")); // Remove hover eff

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



                    String user_dp = DatabaseConfiguration_login.user_pic(username_str);
                    Image user_dp_image = new Image(user_dp);
                    ImageView imageView_user_dp = new ImageView();
                    imageView_user_dp.setImage(user_dp_image);
                    Circle clip = new Circle(95, 95, 95);
                    imageView_user_dp.setClip(clip);
                    imageView_user_dp.setFitWidth(190);
                    imageView_user_dp.setFitHeight(190);
                    imageView_user_dp.setLayoutX(60);
                    imageView_user_dp.setLayoutY(80);

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
                            tableView.setStyle("-fx-table-cell-border-color: transparent; -fx-table-cell-border-width: 0;");
                            tableView.setStyle("-fx-alignment: center;");
// Hide column headings
                            tableView.setStyle("-fx-table-header-background: transparent;");
// Change font and font size
                            tableView.setStyle("-fx-font-family: Arial; -fx-font-size: 16px;");

                            TableColumn<com.example.pentagram.backend.UserProfile, Image> profilePhotoColumn = new TableColumn<>("");
                            profilePhotoColumn.setCellValueFactory(param -> {
                                // Here, we return the Image object from the local file path
                                Image profileImage = new Image(param.getValue().getProfilePhoto());
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
                                            setAlignment(Pos.CENTER); // Center-align the content
                                        }
                                    }
                                };
                            });

                            TableColumn<com.example.pentagram.backend.UserProfile, String> usernameColumn = new TableColumn<>("");
                            usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

                            TableColumn<com.example.pentagram.backend.UserProfile, Button> viewProfileColumn = new TableColumn<>("");
                            viewProfileColumn.setCellValueFactory(new PropertyValueFactory<>("viewProfile"));

                            TableColumn<com.example.pentagram.backend.UserProfile, Button> followColumn = new TableColumn<>("");
                            followColumn.setCellValueFactory(new PropertyValueFactory<>("follow"));
                            usernameColumn.setCellFactory(column -> {
                                return new TableCell<com.example.pentagram.backend.UserProfile, String>() {
                                    private final Text text = new Text();

                                    {
                                        // Set text styles
                                        text.setStyle("-fx-fill: #A93226; -fx-font-family: 'Helvetica';");
                                    }

                                    @Override
                                    protected void updateItem(String item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (empty || item == null) {
                                            setGraphic(null);
                                        } else {
                                            text.setText(item);
                                            setGraphic(text);
                                            setAlignment(Pos.CENTER); // Center-align the text
                                        }
                                    }
                                };
                            });

                            // Style the buttons
                            viewProfileColumn.setCellFactory(column -> {
                                return new TableCell<com.example.pentagram.backend.UserProfile, Button>() {
                                    private final Button button = new Button("View profile");

                                    @Override
                                    protected void updateItem(Button item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (empty || item == null) {
                                            setGraphic(null);
                                        } else {
                                            button.setMinWidth(50); // Set a minimum width for the button
                                            button.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;");
                                            setGraphic(button);
                                            setAlignment(Pos.CENTER); // Center-align the button
                                            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;")); // Hover effect
                                            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;")); // Remove hover effect
                                        }
                                    }
                                };
                            });

                            followColumn.setCellFactory(column -> {
                                return new TableCell<com.example.pentagram.backend.UserProfile, Button>() {
                                    private final Button button = new Button("Follow");
                                    {
                                    button.setOnAction(event ->{
                                        com.example.pentagram.backend.UserProfile userProfile = getTableView().getItems().get(getIndex());
                                        // Implement your follow logic here based on userProfile
                                        int userid1 = DatabaseConfiguration_feedpage.getuserID(username_str);
                                        int userid2 = DatabaseConfiguration_feedpage.getuserID(userProfile.getUsername());
                                        String type1 = DatabaseConfiguration_feedpage.check_connection(userid1, userid2);
                                        String type2 = DatabaseConfiguration_feedpage.check_connection(userid2, userid1);
                                        System.out.println("Follow button clicked for user: " + userProfile.getUsername());
                                        if (type1.equals("new") && type2.equals("new")) {
                                            if (DatabaseConfiguration_feedpage.connection_table(userid1, userid2, "following")) {
                                                button.setText("Following");
                                            } else {
                                                Alert alert = new Alert(AlertType.ERROR);
                                                alert.setTitle("Retry");
                                                alert.setHeaderText(null);
                                                alert.setContentText("We are encountering issue in database,Please try again! in creation");
                                                alert.showAndWait();
                                            }

                                        } else if (type1.equals("new") && type2.equals("following")) {
                                            if (DatabaseConfiguration_feedpage.connection_update(userid1, userid2)) {
                                                DatabaseConfiguration_feedpage.connection_table(userid1,userid2, "mutual");
                                                button.setText("Following");
                                            } else {
                                                Alert alert = new Alert(AlertType.ERROR);
                                                alert.setTitle("Retry");
                                                alert.setHeaderText(null);
                                                alert.setContentText("We are encountering issue in database,Please try again! in updation");
                                                alert.showAndWait();
                                            }
                                        }

                                    });}

                                    @Override
                                    protected void updateItem(Button item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (empty || item == null) {
                                            setGraphic(null);
                                        } else {
                                            button.setMinWidth(50); // Set a minimum width for the button
                                            button.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;");
                                            setGraphic(button);
                                            setAlignment(Pos.CENTER); // Center-align the button
                                            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;")); // Hover effect
                                            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;")); // Remove hover effect
                                        }
                                    }
                                };
                            });

                            tableView.getColumns().addAll(profilePhotoColumn, usernameColumn, viewProfileColumn, followColumn);

                            List<UserProfile> userProfiles = DatabaseConfiguration_feedpage.fetchUserDataFromDatabase(username_str);
                            tableView.getItems().addAll(userProfiles);

// Set the preferred width and height for the TableView
                            tableView.setPrefWidth(1200); // Set the width to 1200 pixels
                            tableView.setPrefHeight(750); // Set the height to 750 pixels

// Set the preferred width for columns
                            profilePhotoColumn.setPrefWidth(300);
                            usernameColumn.setPrefWidth(300);
                            viewProfileColumn.setPrefWidth(300);
                            followColumn.setPrefWidth(300);

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

                    profile_btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            // Create a new pane with a white background
                            Pane profilePane = new Pane();
                            profilePane.setPrefSize(1800, 1400); // Set the width to 800 pixels and height to 600 pixels

                            profilePane.setStyle("-fx-background-color: white;");



                            // Add the circular user_dp image to the profilePane
                            profilePane.getChildren().addAll(imageView_user_dp);

                            // Set the user_dp's position within profilePane
                            imageView_user_dp.setLayoutX(300);
                            imageView_user_dp.setLayoutY(80);

                            Text usernameText = new Text(username_str);
                            usernameText.setFont(Font.font("Monotype Corsiva", 36));
                            usernameText.setFill(Color.BLACK);
                            usernameText.setLayoutX(650); // Adjust the X position as needed
                            usernameText.setLayoutY(100); // Adjust the Y position as needed

                            // Add the usernameText to profilePane
                            profilePane.getChildren().addAll(usernameText);

                            Button followButton = new Button("Follow");
                            followButton.setMinWidth(80); // Set a minimum width for the button
                            followButton.setPrefWidth(120); // Set the preferred width for the button
                            followButton.setMinHeight(30); // Set a minimum height for the button
                            followButton.setPrefHeight(40); // Set the preferred height for the button
                            followButton.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white; -fx-font-size: 20px;");

                            followButton.setOnMouseEntered(e -> {
                                followButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 20px;"); // Maintain the font size
                            });

                            followButton.setOnMouseExited(e -> {
                                followButton.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white; -fx-font-size: 20px;"); // Maintain the font size
                            });
// Adjust the button's layout as needed
                            followButton.setLayoutX(770);
                            followButton.setLayoutY(70);

// Add the followButton to the profilePane
                            // Create an HBox for labels "Posts," "Followers," and "Following"
                            HBox labelsBox = new HBox(120); // Adjust spacing as needed
                            labelsBox.setAlignment(Pos.CENTER);
                            labelsBox.setLayoutX(650); // Adjust the X position as needed
                            labelsBox.setLayoutY(200); // Adjust the Y position as needed
                            int user_id = DatabaseConfiguration_feedpage.getuserID(username_str);

                            int no_post = DatabaseConfiguration_feedpage.getnopost(user_id);
                            String postsLabel_text = Integer.toString(no_post) + " Posts";
                            Label postsLabel = new Label();
                            postsLabel.setFont(Font.font("Ariel", 24)); // Set the font size and style
                            postsLabel.setTextFill(Color.web("#C0392B")); // Set the text color
                            postsLabel.setText(postsLabel_text);

                            int no_followers = DatabaseConfiguration_feedpage.getnofollowers(user_id);
                            String followersLabel_text = Integer.toString(no_followers)+" Followers";
                            Label followersLabel = new Label();
                            followersLabel.setFont(Font.font("Ariel", 24)); // Set the font size and style
                            followersLabel.setTextFill(Color.web("#C0392B")); // Set the text color
                            followersLabel.setText(followersLabel_text);

                            int no_following = DatabaseConfiguration_feedpage.getnofollowing(user_id);
                            String followingLabel_text = Integer.toString(no_following)+" Following";
                            Label followingLabel = new Label();
                            followingLabel.setFont(Font.font("Ariel", 24)); // Set the font size and style
                            followingLabel.setTextFill(Color.web("#C0392B")); // Set the text color
                            followingLabel.setText(followingLabel_text);

                            labelsBox.getChildren().addAll(postsLabel, followersLabel, followingLabel);

                            Button backButton = new Button("Back");
                            backButton.setMinWidth(80); // Set a minimum width for the button
                            backButton.setPrefWidth(120); // Set the preferred width for the button
                            backButton.setMinHeight(30); // Set a minimum height for the button
                            backButton.setPrefHeight(40); // Set the preferred height for the button
                            backButton.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white; -fx-font-size: 20px;");

                            backButton.setOnMouseEntered(e -> {
                                backButton.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white; -fx-font-size: 20px;"); // Maintain the font size
                            });

                            backButton.setOnMouseExited(e -> {
                                backButton.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white; -fx-font-size: 20px;"); // Maintain the font size
                            });

                            backButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    home_pane.getChildren().remove(profilePane);
                                }
                            });

                            backButton.setLayoutX(30);
                            backButton.setLayoutY(700); // Adjust the Y position as needed

                            profilePane.getChildren().addAll(followButton, labelsBox,backButton);

                            /*TableView<com.example.pentagram.backend.UserProfile> follower_table = new TableView<>();
                            follower_table.setStyle("-fx-table-cell-border-color: transparent; -fx-table-cell-border-width: 0;");
                            follower_table.setStyle("-fx-alignment: center;");
// Hide column headings
                            follower_table.setStyle("-fx-table-header-background: transparent;");
// Change font and font size
                            follower_table.setStyle("-fx-font-family: Arial; -fx-font-size: 16px;");*/

                            // Define TableView, create a column, and set its properties
                            TableView<com.example.pentagram.backend.UserProfile> followerTable = new TableView<>();
                            followerTable.setStyle("-fx-control-inner-background: #A93226; -fx-background-color: #A93226;");
                            followerTable.setStyle("-fx-table-cell-border-color: #A93226; -fx-table-cell-border-width: 0;");
                            followerTable.setStyle("-fx-alignment: center;");
                            followerTable.setStyle("-fx-table-header-background: #A93226;");
                            followerTable.setStyle("-fx-font-family: Arial; -fx-font-size: 24px;");
                            TableColumn<com.example.pentagram.backend.UserProfile, String> followerColumn = new TableColumn<>("Followers");
                            followerColumn.setCellValueFactory(new PropertyValueFactory<>("property1")); // Replace with your actual data model properties
                            followerTable.getColumns().add(followerColumn);

                            followerTable.setLayoutX(220);
                            followerTable.setLayoutY(300);
                            followerTable.setPrefSize(250, 350);
                            followerColumn.setPrefWidth(250);
                            int userid = DatabaseConfiguration_feedpage.getuserID(username_str);

                            TableView<com.example.pentagram.backend.UserProfile> followingTable = new TableView<>();
                            followingTable.setStyle("-fx-control-inner-background: #A93226; -fx-background-color: #A93226;");
                            followingTable.setStyle("-fx-table-cell-border-color: #A93226; -fx-table-cell-border-width: 0;");
                            followingTable.setStyle("-fx-alignment: center;");
                            followingTable.setStyle("-fx-table-header-background: #A93226;");
                            followingTable.setStyle("-fx-font-family: Arial; -fx-font-size: 24px;");
                            TableColumn<com.example.pentagram.backend.UserProfile, String> followingColumn = new TableColumn<>("Following");
                            followingColumn.setCellValueFactory(new PropertyValueFactory<>("property1")); // Replace with your actual data model properties
                            followingTable.getColumns().add(followingColumn);


// Set layout and position for the followerTable
                            followingTable.setLayoutX(580);
                            followingTable.setLayoutY(300);
                            followingTable.setPrefSize(250, 350);
                            followingColumn.setPrefWidth(250);


// Add the followerTable to profilePane
                            //profilePane.getChildren().add(followerTable);



                            TableView<com.example.pentagram.backend.UserProfile> postTable = new TableView<>();
                            postTable.setStyle("-fx-table-cell-border-color: transparent; -fx-table-cell-border-width: 0;");
                            postTable.setStyle("-fx-alignment: center;");
// Hide column headings
                            postTable.setStyle("-fx-table-header-background: transparent;");
// Change font and font size
                            postTable.setStyle("-fx-font-family: Arial; -fx-font-size: 16px;");

                            TableColumn<com.example.pentagram.backend.UserProfile, Image> postColumn = new TableColumn<>("post");
                            postColumn.setCellValueFactory(param -> {
                                // Here, we return the Image object from the local file path
                                Image profileImage = new Image(param.getValue().getProfilePhoto());
                                return new SimpleObjectProperty<>(profileImage);
                            });

                            postColumn.setCellFactory(column -> {
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
                                            setAlignment(Pos.CENTER); // Center-align the content
                                        }
                                    }
                                };
                            });

                            TableColumn<com.example.pentagram.backend.UserProfile, Button> likeColumn = new TableColumn<>("like");
                            likeColumn.setCellValueFactory(new PropertyValueFactory<>("like"));
                            //In this code, we create a custom cell factory for the postColumn that returns a Button. This way, you can display the "View profile" button in each cell of the postTable. Make sure to adapt this code to your specific data model as needed.

                            likeColumn.setCellFactory(column -> {
                                return new TableCell<com.example.pentagram.backend.UserProfile, Button>() {
                                    private final Button button = new Button("like");

                                    @Override
                                    protected void updateItem(Button item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (empty || item == null) {
                                            setGraphic(null);
                                        } else {
                                            button.setMinWidth(50); // Set a minimum width for the button
                                            button.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;");
                                            setGraphic(button);
                                            setAlignment(Pos.CENTER); // Center-align the button
                                            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;")); // Hover effect
                                            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;")); // Remove hover effect
                                        }
                                    }
                                };
                            });

                            TableColumn<com.example.pentagram.backend.UserProfile, Button> commentColumn = new TableColumn<>("Comments");
                            likeColumn.setCellValueFactory(new PropertyValueFactory<>("comments"));
                            //In this code, we create a custom cell factory for the postColumn that returns a Button. This way, you can display the "View profile" button in each cell of the postTable. Make sure to adapt this code to your specific data model as needed.

                            likeColumn.setCellFactory(column -> {
                                return new TableCell<com.example.pentagram.backend.UserProfile, Button>() {
                                    private final Button button = new Button("comment");

                                    @Override
                                    protected void updateItem(Button item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (empty || item == null) {
                                            setGraphic(null);
                                        } else {
                                            button.setMinWidth(50); // Set a minimum width for the button
                                            button.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;");
                                            setGraphic(button);
                                            setAlignment(Pos.CENTER); // Center-align the button
                                            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;")); // Hover effect
                                            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white;")); // Remove hover effect
                                        }
                                    }
                                };
                            });
                            postTable.setLayoutX(900);
                            postTable.setLayoutY(300);
                            postTable.setPrefSize(600, 600);
                            postColumn.setPrefWidth(250);
                            likeColumn.setPrefWidth(150);
                            commentColumn.setPrefWidth(250);


                            postTable.getColumns().addAll(postColumn, likeColumn,commentColumn);
                            profilePane.getChildren().addAll(followerTable,followingTable,postTable);
                            // Add the new pane to home_pane
                            home_pane.getChildren().addAll(profilePane);
                        }
                    });



                    Button post = new Button("New post");
                    post.setLayoutX(80);
                    post.setLayoutY(705);
                    post.setStyle("-fx-background-color:#FFFFFF; -fx-text-fill:#010000; -fx-font-size:16; -fx-font-family:Georgia" );

                    post.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
// Create a custom dialog
                            Dialog<ButtonType> dialog = new Dialog<>();
                            dialog.setTitle("Add Post");
                            dialog.setHeaderText("Choose a file from your local disk");

// Create the Choose File button
                            ButtonType chooseButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
                            dialog.getDialogPane().getButtonTypes().addAll(chooseButton, ButtonType.CANCEL);

                            Button chooseFileButton = new Button("Choose");
                            chooseFileButton.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white; -fx-font-size: 16px;");
                            chooseFileButton.setPrefWidth(100); // Set the preferred width for the button
                            chooseFileButton.setPrefHeight(10);

// Create a GridPane for dialog content
                            GridPane grid = new GridPane();
                            grid.setHgap(10);
                            grid.setVgap(10);

// Create a label and a text field for caption
                            Label captionLabel = new Label("Caption:");
                            TextField captionInput = new TextField();

// Set the style for the label and text field
                            captionLabel.setStyle("-fx-background-color: #CB4335; -fx-text-fill: white; -fx-font-size: 16px;");
                            captionInput.setStyle("-fx-background-color: white; -fx-text-fill: #CB4335; -fx-font-size: 16px;");

// Add label and text field to the grid
                            grid.add(captionLabel, 1, 1);
                            grid.add(captionInput, 2, 1);
                            grid.add(chooseFileButton, 1,2);
// Set the grid as the content of the dialog
                            dialog.getDialogPane().setContent(grid);

// Handle the OK button action


                            final String[] post_pic = new String[1];
                            chooseFileButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    FileChooser fileChooser = new FileChooser();
                                    fileChooser.setTitle("Open Image File");
                                    fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
                                    File selectedFile = fileChooser.showOpenDialog(new Stage());

                                    if (selectedFile != null) {
                                        post_pic[0] = selectedFile.toURI().toString();
                                    }
                                }
                            });
                            // Handle button action
                            dialog.setResultConverter(dialogButton -> {
                                if (dialogButton == chooseButton) {
                                    int user_id = DatabaseConfiguration_feedpage.getuserID(username_str);
                                    if(DatabaseConfiguration_feedpage.add_post(post_pic[0],0,user_id,captionInput.getText()))
                                    {
                                        Alert alert = new Alert(AlertType.INFORMATION);
                                        alert.setTitle("Information Dialog");
                                        alert.setHeaderText(null);
                                        alert.setContentText("Post added successful!");
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
                                }
                                return null;
                            });


                            Optional<ButtonType> result = dialog.showAndWait();
                        }
                    });


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


                    post_pane.getChildren().addAll(post1,post2,post3,post4,post5,post6,explore,profile_btn);
                    home_pane.getChildren().addAll(details,insta,imageView_instag_logo,imageView_user_dp,user_name,imageView_home,imageView_search,imageView_saved,imageView_notification,imageView_settings,imageView_profile,imageView_add_post,feed,collection,post,notification_btn,settings_btn,post_pane);
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
        forgot_btn.setLayoutX(1020);
        forgot_btn.setLayoutY(460);
        forgot_btn.setStyle("-fx-text-fill:#8B0000; -fx-font-size:15");
        forgot_btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Forgot password page");
                Pane forgot_pane = new Pane();

                Rectangle password_change = new Rectangle();
                password_change.setX(900);
                password_change.setY(105);
                password_change.setWidth(400);
                password_change.setHeight(450);
                password_change.setArcWidth(20); // Set the width of the corner arc
                password_change.setArcHeight(20);
                password_change.setFill(input_backgroundPattern);
                forgot_pane.getChildren().addAll(password_change);


                Label forgot_password=new Label("Forgot Password");
                forgot_password.setLayoutX(1030);
                forgot_password.setLayoutY(140);
                forgot_password.setStyle("-fx-text-fill:#8B0000; -fx-font-size:25");

                Label user_forget=new Label("Username");
                user_forget.setLayoutX(970);
                user_forget.setLayoutY(200);
                user_forget.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                TextField user_forget_input=new TextField();
                user_forget_input.setLayoutX(1070);
                user_forget_input.setLayoutY(200);
                user_forget_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");


                Label school=new Label("Institution");
                school.setLayoutX(970);
                school.setLayoutY(270);
                school.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                TextField school_input=new TextField();
                school_input.setLayoutX(1070);
                school_input.setLayoutY(270);
                school_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");



                Label nick_name=new Label("Nickname");
                nick_name.setLayoutX(970);
                nick_name.setLayoutY(340);
                nick_name.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                TextField nickname_input=new TextField();
                nickname_input.setLayoutX(1070);
                nickname_input.setLayoutY(320);
                nickname_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");

                Button change_password = new Button("Submit");
                change_password.setLayoutX(1070);
                change_password.setLayoutY(400);
                change_password.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                Button back_forgot = new Button("Back");
                back_forgot.setLayoutX(1085);
                back_forgot.setLayoutY(460);
                back_forgot.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

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

                forgot_pane.getChildren().addAll(forgot_password,school_input,school,nickname_input,nick_name,change_password,back_forgot,user_forget_input,user_forget);
                root.getChildren().add(forgot_pane);
            }
        });
        Button signup_btn = new Button("Doesn't have an account? Create account");
        signup_btn.setLayoutX(950);
        signup_btn.setLayoutY(500);
        signup_btn.setStyle(" -fx-text-fill:#8B0000; -fx-font-size:15");
        signup_btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setTitle("Sign up page");
                Pane signup1_pane = new Pane();


                final Rectangle[] signup1_rect = {new Rectangle()};
                signup1_rect[0].setX(900);
                signup1_rect[0].setY(105);
                signup1_rect[0].setWidth(400);
                signup1_rect[0].setHeight(450);
                signup1_rect[0].setArcWidth(20); // Set the width of the corner arc
                signup1_rect[0].setArcHeight(20);
                signup1_rect[0].setFill(input_backgroundPattern);
                signup1_pane.getChildren().addAll(signup1_rect[0]);


                Label signup1_label=new Label("SignUp");
                signup1_label.setLayoutX(1060);
                signup1_label.setLayoutY(120);
                signup1_label.setStyle("-fx-text-fill:#8B0000; -fx-font-size:25");

                Label mailid=new Label("Mail id");
                mailid.setLayoutX(970);
                mailid.setLayoutY(180);
                mailid.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                TextField mailid_input=new TextField();
                mailid_input.setLayoutX(1060);
                mailid_input.setLayoutY(180);
                mailid_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");


                Label full_name=new Label("Full name");
                full_name.setLayoutX(970);
                full_name.setLayoutY(250);
                full_name.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                TextField fullname_input=new TextField();
                fullname_input.setLayoutX(1060);
                fullname_input.setLayoutY(250);
                fullname_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");


                Label signup_username=new Label("Username");
                signup_username.setLayoutX(970);
                signup_username.setLayoutY(320);
                signup_username.setStyle(" -fx-text-fill:#8B0000; -fx-font-size:20");

                TextField signup_username_input=new TextField();
                signup_username_input.setLayoutX(1060);
                signup_username_input.setLayoutY(320);
                signup_username_input.setStyle("-fx-background-color:#E6E6FA;-fx-text-fill:#2C165C; -fx-font-size:15");



                Label signup_password=new Label("Password");
                signup_password.setLayoutX(970);
                signup_password.setLayoutY(390);
                signup_password.setStyle(" -fx-text-fill:#8B0000; -fx-font-size:20");

                PasswordField signup_password_input=new PasswordField();
                signup_password_input.setLayoutX(1060);
                signup_password_input.setLayoutY(390);
                signup_password_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");


                Button next1_btn = new Button("Next");
                next1_btn.setLayoutX(1200);
                next1_btn.setLayoutY(460);
                next1_btn.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");
                next1_btn.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        primaryStage.setTitle("Sign up page");
                        Pane signup2_pane = new Pane();

                        Rectangle signup2_rect = new Rectangle();
                        signup2_rect.setX(900);
                        signup2_rect.setY(105);
                        signup2_rect.setWidth(400);
                        signup2_rect.setHeight(450);
                        signup2_rect.setArcWidth(20); // Set the width of the corner arc
                        signup2_rect.setArcHeight(20);
                        signup2_rect.setFill(input_backgroundPattern);
                        signup2_pane.getChildren().addAll(signup2_rect);


                        Label signup2_label=new Label("Sign UP");
                        signup2_label.setLayoutX(1080);
                        signup2_label.setLayoutY(120);
                        signup2_label.setStyle("-fx-text-fill:#8B0000; -fx-font-size:25");

                        Label date=new Label("DOB");
                        date.setLayoutX(970);
                        date.setLayoutY(180);
                        date.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                        DatePicker datePicker = new DatePicker();

                        VBox vbox = new VBox(datePicker);
                        vbox.setLayoutX(1080);
                        vbox.setLayoutY(180);


                        Label bio=new Label("Bio");
                        bio.setLayoutX(970);
                        bio.setLayoutY(250);
                        bio.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                        TextField bio_input=new TextField();
                        bio_input.setLayoutX(1080);
                        bio_input.setLayoutY(250);
                        bio_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");



                        Label insta_dp=new Label("Image path");
                        insta_dp.setLayoutX(970);
                        insta_dp.setLayoutY(320);
                        insta_dp.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                        final Button[] chooseImageButton = {new Button("Choose Image")};

                        final String[] user_pic_url = new String[1];
                        chooseImageButton[0].setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                FileChooser fileChooser = new FileChooser();
                                fileChooser.setTitle("Open Image File");
                                fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));
                                File selectedFile = fileChooser.showOpenDialog(new Stage());

                                if (selectedFile != null) {
                                    user_pic_url[0] =selectedFile.toURI().toString();
                                }
                            }
                        });
                        chooseImageButton[0].setLayoutX(1080);
                        chooseImageButton[0].setLayoutY(320);
                        chooseImageButton[0].setStyle("-fx-background-color:#8B0000; -fx-text-fill:white; -fx-font-size:15");


                        Label school_name=new Label("Institution");
                        school_name.setLayoutX(970);
                        school_name.setLayoutY(370);
                        school_name.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                        TextField scl_input=new TextField();
                        scl_input.setLayoutX(1070);
                        scl_input.setLayoutY(370);
                        scl_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");


                        Label nickname_label=new Label("Nickname");
                        nickname_label.setLayoutX(970);
                        nickname_label.setLayoutY(420);
                        nickname_label.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                        TextField nick_name_input=new TextField();
                        nick_name_input.setLayoutX(1070);
                        nick_name_input.setLayoutY(420);
                        nick_name_input.setStyle("-fx-background-color:#E6E6FA; -fx-text-fill:#2C165C; -fx-font-size:15");



                        Button next2_btn = new Button("Sign Up");
                        next2_btn.setLayoutX(1170);
                        next2_btn.setLayoutY(470);
                        next2_btn.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

                        next2_btn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {

                                LocalDate dob = datePicker.getValue();
                                String mailid_str=mailid_input.getText();
                                String fullname_str=fullname_input.getText();
                                String signup_username_str=signup_username_input.getText();
                                String signup_password_str=signup_password_input.getText();
                                String bio_str=bio_input.getText();
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
                                    if(DatabaseConfiguration_login.Signup_backend(mailid_str,fullname_str,signup_username_str,signup_password_str,dob,bio_str, user_pic_url[0],scl_name_str,nickname_str))
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

                        signup2_pane.getChildren().addAll(signup2_label,date,vbox,bio,bio_input,next2_btn,signup_btn, chooseImageButton[0],insta_dp,school_name,scl_input,nickname_label,nick_name_input);
                        root.getChildren().add(signup2_pane);

                    }});
                Button back_home = new Button("Back");
                back_home.setLayoutX(950);
                back_home.setLayoutY(460);
                back_home.setStyle("-fx-text-fill:#8B0000; -fx-font-size:20");

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

                signup1_pane.getChildren().addAll(signup1_label,mailid,mailid_input,full_name,fullname_input,signup_username,signup_username_input,signup_password,signup_password_input,next1_btn,back_home);
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
