import java.util.Scanner;

public class CesarEncryption {
    public static String inputFromUser(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your text to encrypt");
        String result=sc.nextLine();
        sc.close();
        return result;
    }
    public static String encrypt(String message){
StringBuilder sb=new StringBuilder(message);
int distance=5;//o ile przesunac
for(int i=0;i<sb.length();i++){
int c=(int)sb.charAt(i);
if (c+distance>122){
    c=31+(distance-(122-c));
}else {
    c+=distance;
}
sb.setCharAt(i,(char)c);
}
return sb.toString();
    }



}
