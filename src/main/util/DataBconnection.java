import java.io.InputStream; //Import for accessing the input Stream for properties files.
import java.sql.Connection; // Import for establishing connection with database.
import java.sql.DriverManager; //Import for using DriverManager class.
import java.util.Properties; //Import for Handling properties files

public class DataBconnection { //Method used to establish connection with the Database.

    public static Connection connection = null; //Static variable to hold connection object

    public static Connection  getConnection() {

        //Check if the connection has already been established or not.
        if(connection == null) {
            try (InputStream input = DataBconnection.class.getClassLoader().getResourceAsStream("db_config.properties")) {
                Properties prop = new Properties(); //Properties object to store the database properties.
                prop.load(input); //Load the database credentials from the properties files.

                //Getting the Database URL, username, password from the properties file.
                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.username");
                String password = prop.getProperty("db.password");

                //Establishing connection using the driver manager class
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace(); //Print any error that occurs during connection attempt.
            }
        }
        return connection; //Return connection if successful otherwise returns null.
    }
}