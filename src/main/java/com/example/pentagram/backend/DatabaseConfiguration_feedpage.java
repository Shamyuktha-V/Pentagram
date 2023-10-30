package com.example.pentagram.backend;
import com.example.pentagram.backend.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.*;
import java.time.LocalDate;
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
                Button follow = new Button();
                int userid1=getuserID(username_check);
                int userid2=getuserID(username);
                String type = check_connection(userid1,userid2);
                if ((!username_check.equals(username)) && (!type.equals("mutual") && (!type.equals("following")))) {
                    UserProfile userProfile = new UserProfile(image_url_replace, username, viewProfile, follow);
                    userProfiles.add(userProfile);
                }

            }
            return userProfiles;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

    public static boolean add_post(String imagepath,int no_likes,int userid,String caption)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("INSERT INTO Post (image_url, number_of_likes, user_id,caption)\n" + "VALUES (?, ?, ?,?); " );

            preparedStatement.setString(1, imagepath);
            preparedStatement.setInt(2, no_likes);
            preparedStatement.setInt(3, userid);
            preparedStatement.setString(4, caption);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of their creation
            try {

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
        return false;
    }

    public static boolean connection_table(int userid1,int userid2,String connection_type)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("INSERT INTO userconnection (user_id_1, user_id_2, connection_type)" + " VALUES (?, ?, ?)");
            preparedStatement.setInt(1, userid1);
            preparedStatement.setInt(2, userid2);
            preparedStatement.setString(3, connection_type);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in reverse order of their creation
            try {

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
        return false;
    }

    public static int getuserID(String username)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            resultset = preparedStatement.executeQuery();
            if (!resultset.isBeforeFirst()) {
                return 0;
            }
            while (resultset.next())
            {
                return resultset.getInt("user_id");
            }
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
        return 0;
    }

    public static int getnopost(int userid)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        int res_count=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM post WHERE user_id=?");
            preparedStatement.setInt(1, userid);
            resultset = preparedStatement.executeQuery();
            if (!resultset.isBeforeFirst()) {
                return 0;
            }
            while (resultset.next())
            {
                res_count++;
            }
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
        return res_count;
    }

    public static int getnofollowers(int userid)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        int res_count=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM userconnection WHERE user_id_2=?");
            preparedStatement.setInt(1, userid);
            resultset = preparedStatement.executeQuery();
            if (!resultset.isBeforeFirst()) {
                return 0;
            }
            while (resultset.next())
            {
                res_count++;
            }
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
        return res_count;
    }

    public static int getnofollowing(int userid)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        int res_count=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM userconnection WHERE user_id_1=?");
            preparedStatement.setInt(1, userid);
            resultset = preparedStatement.executeQuery();
            if (!resultset.isBeforeFirst()) {
                return 0;
            }
            while (resultset.next())
            {
                res_count++;
            }
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
        return res_count;
    }

    public static String check_connection(int userid1,int userid2)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("SELECT * FROM userconnection WHERE user_id_1=? and user_id_2=?");
            preparedStatement.setInt(1, userid1);
            preparedStatement.setInt(2, userid2);
            resultset = preparedStatement.executeQuery();
            if (!resultset.isBeforeFirst()) {
                return "new";
            }
            while (resultset.next())
            {
                return resultset.getString("connection_type");
            }
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
        return "new";
    }

    public static boolean connection_update(int userid1,int userid2)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("UPDATE userconnection SET connection_type = ? WHERE user_id_1 = ? and user_id_2 = ?");
            preparedStatement.setString(1, "mutual"); // Set the new password
            preparedStatement.setInt(2, userid2); // Set the username
            preparedStatement.setInt(3, userid1);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }
            else if(rowsUpdated<=0)
            {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception here
        } finally {
            // Close the resources in reverse order of their creation
            try {
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
        return false;
    }

}