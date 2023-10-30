package com.example.pentagram.backend;
import com.example.pentagram.backend.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConfiguration_feedpage {

   public static List<UserProfile> fetchUserDataFromDatabase(String username_check) {
        List<UserProfile> userProfiles = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM user ");
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                String username = resultset.getString("username");
                String image_url_replace = resultset.getString("image_url");
                Button viewProfile = new Button("View Profile");
                Button follow = new Button("Follow");
                if(!username_check.equals(username))
                {
                    UserProfile userProfile = new UserProfile(image_url_replace, username, viewProfile, follow);
                    userProfiles.add(userProfile);
                }

            }
            return userProfiles;
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of their creation
            try {
                if (resultset != null) {
                    resultset.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userProfiles;
    }
}
