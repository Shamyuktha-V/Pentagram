package com.example.pentagram.backend;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.sql.*;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

public class DatabaseConfiguration_login {

    static {
        // Set the java.library.path to include the directory containing the OpenCV library
        // Load the OpenCV library
        System.loadLibrary("opencv_java480"); // Replace with the correct library name
    }
    public static boolean check_user(String username)
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
                return false;
            }
            else
            {
                return true;
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
        return false;
    }

    public static boolean Signup_backend(String mailid_str, String fullname_str, String signup_username_str, String signup_password_str, LocalDate dob, String bio_str, String insta_dp_str,String scl_name_str,String nickname_str)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("INSERT INTO user (username, email, password, full_name, date_of_birth, bio, image_url, institution, nickname) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, signup_username_str);
            preparedStatement.setString(2, mailid_str);
            preparedStatement.setString(3, signup_password_str);
            preparedStatement.setString(4, fullname_str);

            preparedStatement.setDate(5, Date.valueOf(dob));
            preparedStatement.setString(6, bio_str);
            preparedStatement.setString(7, insta_dp_str);
            preparedStatement.setString(8, scl_name_str);
            preparedStatement.setString(9, nickname_str);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
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

    public static String forgot_password(String username,String institution,String nickname)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("SELECT institution,nickname FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            resultset = preparedStatement.executeQuery();
            if (!resultset.isBeforeFirst()) {
                return "user";
            } else {
                while (resultset.next()) {
                    String retrievedInstitution = resultset.getString("institution");
                    String retrievedNickname = resultset.getString("nickname");
                    if (retrievedInstitution.equals(institution) && retrievedNickname.equals(nickname)) {
                        return "true";
                    } else if(retrievedInstitution.equals(institution)) {
                        return "nickname";
                    }else if(retrievedNickname.equals(nickname)){
                        return "institution";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception here
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
        return "false";

    }

    public static String change_password(String username,String newPassword)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("UPDATE user SET password = ? WHERE username = ?");
            preparedStatement.setString(1, newPassword); // Set the new password
            preparedStatement.setString(2, username); // Set the username
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return "true";
            }
            else if(rowsUpdated<=0)
            {
                return "user";
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
        return "false";
    }

    public static String check_login(String username,String password)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            preparedStatement = connection.prepareStatement("SELECT password FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            resultset = preparedStatement.executeQuery();
            if (!resultset.isBeforeFirst()) {
                return "user";
            } else {
                while (resultset.next()) {
                    String retrievedPassword = resultset.getString("password");
                    if (retrievedPassword.equals(password)) {
                        return "true";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception here
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
        return "false";

    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        String username ;
        System.out.println("Enter user:");
        Scanner in = new Scanner(System.in);
        username=in.next();
        String password = "password123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pentagram", "root", "Shamu@123");
            System.out.println("hi");
            preparedStatement = connection.prepareStatement("SELECT password FROM user WHERE username=?");
            preparedStatement.setString(1, username);
            resultset = preparedStatement.executeQuery();
            if (!resultset.isBeforeFirst()) {
                System.out.println("User not found.");
            } else {
                while (resultset.next()) {
                    String retrievedPassword = resultset.getString("password");
                    if (retrievedPassword.equals(password)) {
                        System.out.println("Password matches");
                    } else {
                        System.out.println("Passwords did not match.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception here
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
        VideoCapture camera = new VideoCapture(0); // 0 represents the default camera (usually the webcam)

        if (!camera.isOpened()) {
            System.err.println("Error: Camera not found!");
            return;
        }

        Mat frame = new Mat();

        if (camera.read(frame)) {
            // Capture successful, save the image
            String outputFileName = "capturedImage.jpg";
            Imgcodecs.imwrite(outputFileName, frame);
            System.out.println("Image captured and saved to " + outputFileName);
        } else {
            System.err.println("Error: Failed to capture image!");
        }

        // Release the camera
        camera.release();
    }
}

