import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QueryExecutor extends DbConnector {

    public static ResultSet executeSelect(String selectQuery){
        try {
            Connection connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectQuery);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }//executeSelect

    public static void executeQuery(String query){
        try {
            Connection connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            statement.execute(query);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }//executeQuery
    public static void showAllWords(){
        try {
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words");
            while (result.next()) {
                System.out.println(result.getString("wordPL") + " - " + result.getString("wordENG"));}
        }catch (SQLException e){
            e.printStackTrace();
        }
        }//showAllWords

    public static void showWithID(){
        try {
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words");
            while (result.next()) {
                System.out.println(result.getInt("word_ID") + ". " + result.getString("wordPL") + " - " + result.getString("wordENG"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }//showWithID

    public static void insertNew(){
        String wordPL;
        String wordENG;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Write word in Polish: ");
            wordPL = input.nextLine();
            System.out.println("Write word in English: ");
            wordENG = input.nextLine();
            //QueryExecutor.executeQuery("INSERT INTO words VALUES (NULL, "+wordPL+", "+wordENG+" )");
            String insertStr="INSERT INTO words VALUES (NULL,?,?)";
            Statement stmt=conn.createStatement();
            PreparedStatement preparedStatement=conn.prepareStatement(insertStr);
            preparedStatement.setString(1,wordPL);
            preparedStatement.setString(2,wordENG);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }//insertNew

    public static void deleteRow(){
        int num;//ID num
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Write word_ID that you wanna delete: ");
            num = input.nextInt();
            String deleteStr = "DELETE FROM words WHERE word_ID=?";
            Statement stmt = conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(deleteStr);
            preparedStatement.setInt(1, num);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }//deleteRow

    public static void saveToList(ArrayList<Row> list){
        try {
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words");
            while (result.next()) {
                //System.out.println(result.getInt("word_ID") + ". " + result.getString("wordPL") + " - " + result.getString("wordENG"));
                Row pom=new Row();
                pom.wordPl=result.getString("wordPL");
                pom.wordEng= result.getString("wordENG");
                list.add(pom);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }//saveToList

    public static void printList(ArrayList<Row> list){
        System.out.println();
        for(Row p:list){
            System.out.println(p.wordPl+" - "+ p.wordEng);
        }
        System.out.println();
    } //printList
    public static Row[] listToArray(ArrayList<Row> list, Row[] array){
    array=list.toArray(new Row[list.size()]);
    for (int i=0;i< array.length;i++){
        System.out.println(array[i].wordPl);
    }
    return array;
    }//listToArray

    }

