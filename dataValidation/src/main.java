import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
/*int a=0;
boolean valid=false;
        Scanner input=new Scanner(System.in);
        //while (valid==false) {
    while (valid==false) {
        //valid = false;
        System.out.println("podaj liczbe: ");
        try {

            a = input.nextInt();
            valid = true;
        } catch (InputMismatchException e) {
            System.out.println("Podaj wartosc liczbowa");
            //valid = true;
        }
    }
       // }
        System.out.println("Liczba "+ a);*/
    Keyboard kb =new Keyboard();

    //Test case int
    int intInput;
    String promptMsg1="Enter an integer value: ";
    String errorMsg1="Invalid entry, enter an integer value";
    intInput=kb.readInteger(promptMsg1, errorMsg1);
        System.out.println("You entered the value "+ intInput);


    //Test case double
        double doubleInput;
        String promptMsg2="Enter a double value: ";
        String errorMsg2="Invalid entry, enter an double value";
        doubleInput=kb.readDouble(promptMsg2, errorMsg2);
        System.out.println("You entered the value "+ doubleInput);

        //Test case int2
        int intInput2;
        String promptMsg3="Enter an integer value in the range (1-10): ";
        String errorMsg3="Invalid entry, enter an integer value in the range (1-10)";
        intInput2=kb.readInteger(promptMsg3, errorMsg3,1,10);
        System.out.println("You entered the value "+ intInput2);
    }
}