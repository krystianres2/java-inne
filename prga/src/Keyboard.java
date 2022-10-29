import java.util.Scanner;

public class Keyboard {
    private Scanner input;
    Keyboard(){
        input=new Scanner(System.in);
    }
    public int readInteger(String promptMsg,String errorMsg){
        int num=0;
        String strInput;
        boolean valid = false;

        while (valid==false){
            System.out.println(promptMsg);
            strInput=input.nextLine();
            try {
                num=Integer.parseInt(strInput);
                valid=true;
            }catch (NumberFormatException e){
                System.out.println(errorMsg);
            }
        }//while
        return num;
    }//readInteger

    public int readInteger(String promptMsg,String errorMsg, int low, int high){
        int num=0;
        String strInput;
        boolean valid = false;

        while (valid==false){
            System.out.println(promptMsg);
            strInput=input.nextLine();
            try {
                num=Integer.parseInt(strInput);
                if(num>=low && num<=high)
                    valid=true;
                else
                    System.out.println(errorMsg);
            }catch (NumberFormatException e){
                System.out.println(errorMsg);
            }
        }//while
        return num;
    }//readInteger


    public double readDouble(String promptMsg,String errorMsg){
        double num=0;
        String strInput;
        boolean valid = false;

        while (valid==false){
            System.out.println(promptMsg);
            strInput=input.nextLine();
            try {
                num=Double.parseDouble(strInput);
                valid=true;
            }catch (NumberFormatException e){
                System.out.println(errorMsg);
            }
        }//while
        return num;
    }//readDouble
}
