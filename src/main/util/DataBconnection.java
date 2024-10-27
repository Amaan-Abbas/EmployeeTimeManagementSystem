import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBconnection {

    public static Connection connection = null;

    public static Connection  getConnection() {

        //Check if the connection has already been established or not.
        if(connection == null) {
            try (InputStream input = DataBconnection.class.getClassLoader().getResourceAsStream("db_config.properties")) {
                Properties prop = new Properties();
                prop.load(input);

                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.username");
                String password = prop.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}