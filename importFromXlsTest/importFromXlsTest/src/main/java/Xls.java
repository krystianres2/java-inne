import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class Xls extends DbConnector {
    String excelFilePath="C:\\Users\\kryst\\OneDrive\\Pulpit\\testXLS.xlsx";
    int batchSize =20;

    public void importFromXLS() {
        try {
            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();

            String sql = "INSERT INTO words VALUES (NULL,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;

            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            String name1 = nextCell.getStringCellValue();
                            statement.setString(1, name1);
                            break;
                        case 1:
                            String name2 = nextCell.getStringCellValue();
                            statement.setString(2, name2);
                    }//switch
                }
                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
                workbook.close();
                statement.executeBatch();

                conn.commit();
                conn.close();

            }catch (IOException e){
            System.out.println("Error reading file");
            e.printStackTrace();
        }catch (SQLException e){
            System.out.println("Database error");
            e.printStackTrace();
        }

        }//importFromXLS


    //export to XLS

    private String getFileName(String baseName){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new Date());
        return baseName.concat(String.format("_%s.xlsx", dateTimeInfo));
    }//getFileName

    public void export(String table){
        String excelFilePath=getFileName(table.concat("_Export"));
        try{
            String sql="SELECT * FROM ".concat(table);

            Statement statement=conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(table);

            writeHeaderLine(result, sheet);

            writeDataLines(result, workbook, sheet);

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();

            statement.close();

        }catch (SQLException e){
            System.out.println("Database error");
            e.printStackTrace();
        }catch (IOException e){
            System.out.println("File IO error");
            e.printStackTrace();
        }
    }//export

    private void writeHeaderLine(ResultSet result, XSSFSheet sheet) throws SQLException{
        // write header line containing column names
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        Row headerRow = sheet.createRow(0);

        // exclude the first column which is the ID field
        for (int i = 2; i <= numberOfColumns; i++) {
            String columnName = metaData.getColumnName(i);
            Cell headerCell = headerRow.createCell(i - 2);
            headerCell.setCellValue(columnName);
        }
    }//writeHeaderLine

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException{
        ResultSetMetaData metaData= result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        int rowCount = 1;

        while (result.next()) {
            Row row = sheet.createRow(rowCount++);

            for (int i = 2; i <= numberOfColumns; i++) {
                Object valueObject = result.getObject(i);

                Cell cell = row.createCell(i - 2);

                if (valueObject instanceof Boolean)
                    cell.setCellValue((Boolean) valueObject);
                else if (valueObject instanceof Double)
                    cell.setCellValue((double) valueObject);
                else if (valueObject instanceof Float)
                    cell.setCellValue((float) valueObject);
                else if (valueObject instanceof Date) {
                    cell.setCellValue((Date) valueObject);
                    formatDateCell(workbook, cell);
                } else cell.setCellValue((String) valueObject);
            }//if
        }//while
    }//writeDataLines

    private void formatDateCell(XSSFWorkbook workbook, Cell cell){
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        cell.setCellStyle(cellStyle);
    }//formatDateCell



    }



