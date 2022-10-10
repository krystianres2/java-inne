import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector extends Row {

   private static String DB_URL="jdbc:mysql://localhost:3306/learner";
   private static String USERNAME= "root";
   private static String PASSWORD="";
   static Connection conn;
//Connection connection=null;

    public static Connection connect(){
        Connection connection=null;
    try {
        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        conn=connection;
       // System.out.println("Polaczono z baza danych");
        }catch (SQLException e){
        e.printStackTrace();
        }
    return connection;
    }//connect

}
