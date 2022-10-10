import java.util.Scanner;

public class example {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String name;
        Integer age;

        System.out.print("Podaj swoje imie: ");
        name=scanner.nextLine();
        System.out.print("Podaj wiek: ");
age=scanner.nextInt();

       System.out.println("Hello " + name);
       System.out.println(age);

    }

}
