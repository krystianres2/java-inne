import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnector {
    private static String DB_URL="jdbc:mysql://localhost:3306/learner";
    private static String USERNAME="root";
    private static String PASSWORD="";
    static Connection conn;//to catch connection

    public static Connection connect(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(DB_URL, USERNAME,PASSWORD);
            connection.setAutoCommit(false);
            conn=connection;
            //System.out.println("Connected to database");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }//connect


}
