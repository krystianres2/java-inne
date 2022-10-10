import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Row>list=new ArrayList<Row>();
//Row[] array=new Row[list.size()];

DbConnector.connect();

//QueryExecutor.executeQuery("INSERT INTO words VALUES (NULL, 'kaczka', 'duck')");

/*try {
    ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words");
    result.next();
    String wordPL = result.getString("wordPL");
    System.out.println(wordPL);
}catch (SQLException e){
    e.printStackTrace();
}*/
        /*try {
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words");
            while (result.next()) {
                System.out.println(result.getString("wordPL") + " - " + result.getString("wordENG"));}
        }catch (SQLException e){
            e.printStackTrace();
        }*/

            QueryExecutor.saveToList(list);
            QueryExecutor.printList(list);
        Row[] array=new Row[list.size()];
        //System.out.println(array.length);
          array = QueryExecutor.listToArray(list,array);
        System.out.println(array[1].wordPl);
        //QueryExecutor.insertNew();
        //QueryExecutor.showAllWords();
        //QueryExecutor.showWithID();
        //QueryExecutor.deleteRow();
    }
}
