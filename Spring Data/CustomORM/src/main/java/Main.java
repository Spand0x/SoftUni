import entities.User;
import orm.Connector;
import orm.EntityManager;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {

        String username = "root";
        String password = "root";

        Connector.createConnection(username,password,"orm_Db");
        EntityManager<User> entityManager = new EntityManager<>(Connector.getConnection());

        User user = new User("Pesho","password",24, new Date());
        entityManager.persists(user);
    }
}
