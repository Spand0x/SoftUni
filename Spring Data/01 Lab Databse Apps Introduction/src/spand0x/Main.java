package spand0x;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user");
        String user = scanner.nextLine();
        System.out.println("Please enter password");
        String password = scanner.nextLine();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        System.out.println("Please enter the username of the player");
        String username = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);
             PreparedStatement stmt = connection.prepareStatement(
                     "SELECT u.user_name,\n" +
                     "       u.first_name,\n" +
                     "       u.last_name,\n" +
                     "       COUNT(ug.id) AS games\n" +
                     "FROM users AS u\n" +
                     "JOIN users_games ug on u.id = ug.user_id\n" +
                     "WHERE user_name = ?")) {
            stmt.setString(1, username);

            ResultSet rs =stmt.executeQuery();
            rs.next();
            if(rs.getString("user_name")==null){
                System.out.println("No such user exists");
            }else{
                System.out.printf("User: %s \n" +
                        "%s %s has played %d games",
                        rs.getString("user_name"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("games"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
