import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
try {

    ArrayList<Row> list = new ArrayList<Row>();
    // Row[] array=new Row[list.size()];

    int x = 0;//to choose an action
    int hmw = 0;// hom many words
    Scanner input=new Scanner(System.in);

    DbConnector.connect();


    while (x != 5) {
        System.out.println("1. start learning");
        System.out.println("2. insert new words");
        System.out.println("3. delete words");
        System.out.println("4. show all words");
        System.out.println("5. exit");

        System.out.println("Type number of action that you choose");
        x=input.nextInt();
        System.out.println();
        switch (x) {
            case 1:
                QueryExecutor.saveToList(list);
                Row[] array = new Row[list.size()];
                array=Others.listToArray(list, array);
                Others.learn(array);
                break;
            case 2:
                Scanner input2=new Scanner(System.in);
                System.out.println("How many words you wanna insert: ");
                hmw=input2.nextInt();
                if (hmw>0) {
                    for (int i = 0; i < hmw; i++) {
                        QueryExecutor.insertRow();
                        System.out.println();
                    }
                }//if
                break;
            case 3:
                QueryExecutor.showWithID();
                QueryExecutor.deleteRow();
                break;
            case 4:
                QueryExecutor.showAllWords();
                System.out.println();
                break;
            case 5:
                break;
            default:
                System.out.println("Incorrect choice");
        }//switch
    }//while
}catch (Exception e){
    e.printStackTrace();
}
    }//main
}
