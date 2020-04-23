package spand0x;

import java.sql.*;
import java.util.*;

public class Main {
    private static final String DATABASE_CONNECTION = "jdbc:mysql://localhost/";
    private static final String DATABASE_NAME = "minions_db";

    private static Connection connection;
    private static PreparedStatement statement;
    private static String query;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        try {
            connection = DriverManager.getConnection(DATABASE_CONNECTION + DATABASE_NAME, properties);
            //Exercise 2: Get Villains' Name
//            getVillainsNamesEx();
            //Exercise 3: Get Minion Names
//            getMinionNamesEx();
            //Exercise 4: Add Minion
            //addMinionEx();
            //Exercise 5: Change Town Names Casing
//            changeTownNamesCasingEx();
            //Exercise 6: Remove Villain
//            removeVillainEx();
            //Exercise 7: Print All Minion Names
//            printAllMinionNamesEx();
            //Exercise 8: Increase Minions Age
//            increaseMinionsAgeEx();
            //Exercise 9: Increase Age Stored Procedure
//            increaseAgeProcedureEX();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    //Exercise 2
    private static void getVillainsNamesEx() throws SQLException {
        query = "SELECT v.name,\n" +
        "       COUNT(mv.minion_id) AS count\n" +
        "FROM villains AS v\n" +
        "JOIN minions_villains mv on v.id = mv.villain_id\n" +
        "GROUP BY v.name\n" +
        "HAVING count > 15\n" +
        "ORDER BY count DESC ";

        statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.printf("%s %d %n", rs.getString("name"),
            rs.getInt("count"));
        }
    }

    //Exercise 3
    private static void getMinionNamesEx() throws SQLException {
        System.out.println("Exercise 3: Please Enter ID");
        int villainId = Integer.parseInt(scanner.nextLine());
        String villainName = checkAndGetEntityNameById(villainId, "villains");
        if (villainName == null) {
            System.out.println("No villain with ID " + 10 + " exists in the database.");
            return;
        }
        System.out.println("Villain: " + villainName);
        int counter = 1;
        query = "SELECT v.name AS villain_name,\n" +
        "       m.name AS minion_name,\n" +
        "       m.age\n" +
        "FROM minions AS m\n" +
        "JOIN minions_villains mv on m.id = mv.minion_id\n" +
        "JOIN villains v on mv.villain_id = v.id\n" +
        "WHERE v.id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.printf("%d. %s %d %n",
            counter,
            rs.getString("minion_name"),
            rs.getInt("age"));
            counter++;
        }
    }

    //Exercise 4
    private static void addMinionEx() throws SQLException {
        System.out.println("Exercise 4: Please Enter Minion And Villain information:");
        String[] minionInfo = scanner.nextLine().split("\\s+");
        String minionName = minionInfo[1];
        int age = Integer.parseInt(minionInfo[2]);
        String townName = minionInfo[3];

        String villainName = scanner.nextLine().split("\\s+")[1];



        if (!checkEntityByName(townName, "towns")) {
            addTownByName(townName);
            System.out.println("Town " + townName + " was added to the database.");
        }
        if (!checkEntityByName(villainName, "villains")) {
            addVillain(villainName, "evil");
            System.out.println("Villain " + villainName + " was added to the database.");
        }
        int townId = getEntityIdByName(townName, "towns");
        int villainId = getEntityIdByName(villainName, "villains");

        query = "INSERT INTO minions (name,age,town_id) VALUE (?,?,?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, minionName);
        statement.setInt(2, age);
        statement.setInt(3, townId);
        statement.executeUpdate();

        int minionId = getEntityIdByName(minionName, "minions");

        query = "INSERT INTO minions_villains (minion_id,villain_id) VALUE (?,?)";
        statement = connection.prepareStatement(query);
        statement.setInt(1, minionId);
        statement.setInt(2, villainId);
        System.out.println("Successfully added " + minionName + " to be minion of " + villainName);
    }

    //Exercise 5
    private static void changeTownNamesCasingEx() throws SQLException {
        System.out.println("Exercise 5: Please enter country name:");
        String country = scanner.nextLine();
        query = "SELECT name from towns\n" +
                "WHERE country = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, country);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            query = "UPDATE towns\n" +
                    "SET name = UPPER(name)\n" +
                    "WHERE country = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, country);
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " town names were affected.");
            List<String> towns = new LinkedList<>();
            query = "SELECT name from towns WHERE country = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, country);
            rs = statement.executeQuery();
            while (rs.next()) {
                towns.add(rs.getString("name"));
            }
            System.out.println(Arrays.toString(towns.toArray()));
        } else {
            System.out.println("No town names were affected");
        }
    }

    //Exercise 6
    private static void removeVillainEx() throws SQLException {
        System.out.println("Exercise 6: Please Enter Villain id: ");
        int id = Integer.parseInt(scanner.nextLine());
        String villainName = checkAndGetEntityNameById(id,"villains");
        if(villainName == null){
            System.out.println("No such villain was found");
            return;
        }

        query = "DELETE FROM minions_villains\n" +
                "WHERE villain_id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        int rowsAffected = statement.executeUpdate();

        query = "DELETE FROM villains WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        statement.executeUpdate();
        System.out.println(villainName + " was deleted");
        System.out.println(rowsAffected + " minions released");
    }

    //Exercise 7
    private static void printAllMinionNamesEx() throws SQLException {
        query = "SELECT name FROM minions ORDER BY id";
        statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        List<String> result = new LinkedList<>();
        while (rs.next()) {
            result.add(rs.getString("name"));
        }
        for (int first = 0, last = result.size() - 1; first <= last; first++, last--) {
            System.out.println(result.get(first));
            if (first != last) {
                System.out.println(result.get(last));
            }
        }
    }

    //Exercise 8
    private static void increaseMinionsAgeEx() throws SQLException {
        System.out.println("Exercise 9: Please enter ids: ");
        int[] ids = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int id : ids) {
            query = "UPDATE minions\n" +
                    "SET age  = age + 1,\n" +
                    "name = LOWER(name)\n" +
                    "WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        query = "SELECT name,age FROM minions";
        statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.printf("%s %d %n", rs.getString("name"), rs.getInt("age"));
        }
    }

    //Exercise 9
    private static void increaseAgeProcedureEX() throws SQLException {
        System.out.println("Enter minion id: ");
        int minionId = Integer.parseInt(scanner.nextLine());
        query = "CALL usp_get_older(?)";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1,minionId);
        callableStatement.execute();

    }


    //Additional
    private static int getEntityIdByName(String name, String tableName) throws SQLException {
        query = "SELECT id FROM " + tableName + " WHERE name = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt("id");
    }

    private static int addVillain(String villainName, String evilFactor) throws SQLException {
        query = "INSERT INTO villains (name,evilness_factor)" +
                "VALUE(?,?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, villainName);
        statement.setString(2, evilFactor);
        return statement.executeUpdate();
    }

    private static void addTownByName(String town) throws SQLException {
        query = "INSERT INTO towns (name)\n" +
                "VALUE(?);";
        statement = connection.prepareStatement(query);
        statement.setString(1, town);
        statement.executeUpdate();
    }

    private static boolean checkEntityByName(String name, String tableName) throws SQLException {
        query = "SELECT name FROM " + tableName + " WHERE name = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        return rs.next();
    }

    private static String checkAndGetEntityNameById(int id, String tableName) throws SQLException {
        query = "SELECT name FROM " + tableName + " where id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getString("name");
        }
        return null;
    }


}
