import java.util.Scanner;

public class Main {
    public static void main(String[] args){

String input=CesarEncryption.inputFromUser();
        System.out.println(input);
String encrypted=CesarEncryption.encrypt(input);
        System.out.println(encrypted);




    }
}
