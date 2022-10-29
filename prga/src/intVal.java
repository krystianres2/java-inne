import java.util.Scanner;

public class intVal {
    public static int inputInt(){
        int num=0;
        String strInput;
        boolean valid = false;
        Scanner input=new Scanner(System.in);
        while (valid==false){
            System.out.println("Podaj liczbe: ");
            strInput=input.nextLine();

            try {
                num=Integer.parseInt(strInput);
                valid=true;
            }catch (NumberFormatException e){
                System.out.println("Error, podaj liczbe ");
            }
        }//while
        return num;
    }
}
