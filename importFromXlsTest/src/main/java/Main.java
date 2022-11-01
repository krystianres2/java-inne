public class Main {
    public static void main(String[] args){

        DbConnector.connect();

        Xls test=new Xls();

       //test.importFromXLS();
        test.export("words");






    }
}
