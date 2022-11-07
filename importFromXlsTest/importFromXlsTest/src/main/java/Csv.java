import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Csv extends words{

    String csvFilePath="C:\\Users\\kryst\\OneDrive\\Pulpit\\testCSV.csv";



    /*public void importFromCsv(){
    int batchSize=20;
        try {
            String sql = "INSERT INTO words VALUES (NULL,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
            int count = 0;
            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(";");
                String wordPL = data[0];
                String wordENG = data[1];

                statement.setString(1, wordPL);
                statement.setString(2, wordENG);
                statement.addBatch();
                count++;
                System.out.println(count);
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }//while
            lineReader.close();
            statement.executeBatch();
            conn.commit();
            //conn.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            conn.rollback();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }//importFromCsv*/

   /* public void exportToCsv(){
   int batchSize=20;
        try {
            String csvFilePath = "words-export.csv";
            String sql = "SELECT * FROM words";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));
            fileWriter.write("wordPL,wordENG");

            while (result.next()) {
                String wordPL = result.getString("wordPL");
                String wordENG = result.getString("wordENG");

                String line = String.format("\"%s\",%s", wordPL, wordENG);
                fileWriter.newLine();
                fileWriter.write(line);
            }//while
            statement.close();
            fileWriter.close();
        }catch (SQLException e){
            System.out.println("Database error:");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("File IO error");
            e.printStackTrace();
        }
    }//exportToCsv*/

    public void importFromCSVAdv(){
        int batchSize=20;
        try {
            ICsvBeanReader beanReader = null;
            CellProcessor[] processors = new CellProcessor[]{
                    new NotNull(),//wordPL
                    new NotNull() //wordENG
            };
            String sql = "INSERT INTO words (wordPL, wordENG) VALUES(?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            beanReader = new CsvBeanReader(new FileReader(csvFilePath),
                    CsvPreference.STANDARD_PREFERENCE);

            beanReader.getHeader(true); // skip header line

            String[] header = {"wordPL", "wordENG"};
            words bean = null;
            int count = 0;

            while ((bean = beanReader.read(words.class, header, processors)) != null) {
                String wordPL = bean.getWordPL();
                String wordENG = bean.getWordENG();

                statement.setString(1, wordPL);
                statement.setString(2, wordENG);
                statement.addBatch();
                count++;
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }//while

            beanReader.close();
            statement.executeBatch();
            conn.commit();
            conn.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
            try {
                conn.rollback();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }//importFromCSVAdv





}
