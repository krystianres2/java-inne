import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QueryExecutor extends DbConnector {

    static int numOfRows=countRows();//to save number of added rows

    //type select question to function argument to execute Select
    public static ResultSet executeSelect(String selectQuery){
        try{
            Connection connection=DbConnector.connect();
            Statement statement=connection.createStatement();
            return statement.executeQuery(selectQuery);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }//executeSelect

    //function return number of rows in table
    public static int countRows(){
        int a=0;
        try {
            ResultSet result=QueryExecutor.executeSelect("SELECT COUNT(*) FROM words");
            result.next();
            a= result.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }return a;
    }//countRows

    // User types word in Polish and word in English and these words are inserted into database
   public static void insertRow(){
        String wordPL=" ";
        String wordENG=" ";
        try {
            Scanner input=new Scanner(System.in);
            do {
                System.out.println("Write word in Polish: ");
                wordPL = input.nextLine();
                setWordPl(wordPL);
            }while (wordPL.length()<2||isNumeric(wordPL));
            do {
                System.out.println("Write word in English: ");
                wordENG = input.nextLine();
                setWordEng(wordENG);
            }while (wordENG.length()<2||isNumeric(wordENG));
            String insertStr="INSERT INTO words VALUES (NULL,?,?)";
            Statement stmt=conn.createStatement();
            PreparedStatement preparedStatement=conn.prepareStatement(insertStr);
            preparedStatement.setString(1,wordPL);
            preparedStatement.setString(2,wordENG);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        numOfRows++;
   }//insertRow

    //User types word_ID that he wanna delete. All word_ID from database are saved to tab and if given word_ID exist,
    //Row with that word_ID is deleted
    public static void deleteRow(){
        int num=0;//ID of row
        int[] tab=new int[numOfRows];
        try{
            ResultSet result=QueryExecutor.executeSelect("SELECT word_ID FROM words");
            while (result.next()){
                int i=0;
                tab[i]=result.getInt("word_ID");
                i++;
            }//while
            Scanner input=new Scanner(System.in);
            System.out.println("Write word_ID that you wanna delete: ");
            num=input.nextInt();
            if (Others.bSe(tab,num)) {
                String deleteStr = "DELETE FROM words WHERE word_ID=?";
                Statement stmt = conn.createStatement();
                PreparedStatement preparedStatement = conn.prepareStatement(deleteStr);
                preparedStatement.setInt(1, num);
                preparedStatement.executeUpdate();
                numOfRows--;
            }//else{
               // System.out.println("The word with the given word_ID does not exist");}// does not work idk
        }catch (SQLException e){
            e.printStackTrace();
        }
    }//deleteRow

    //function is showing all wordPL and wordENG(next to) that exist in database
    public static void showAllWords(){
    try {
        ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words");
        while (result.next()) {
            System.out.println(result.getString("wordPL") + " - " + result.getString("wordENG"));
        }

    }catch (SQLException e){
        e.printStackTrace();
    }
    }//showAllWords

    //function is showing all rows that exist in database
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

    // function is saving all rows to list
    public static void saveToList(ArrayList<Row> list){
        try {
            ResultSet result = QueryExecutor.executeSelect("SELECT * FROM words");
            while (result.next()) {
                Row pom=new Row();
                pom.wordPl=result.getString("wordPL");
                pom.wordEng= result.getString("wordENG");
                list.add(pom);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }//saveToList

    //function check if given String is numeric, if it is return true, if it isn't return false
    public static boolean isNumeric(String string) {
        int intValue;
        //System.out.println(String.format("Parsing string: \"%s\"", string));
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            // System.out.println("Niepoprawna nazwa");
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }//isNumeric
}
