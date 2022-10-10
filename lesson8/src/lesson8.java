import java.util.Random;
import java.util.Scanner;

public class lesson8 {
    public static void main(String[] args){

       /* int ile=0, licz, odp;
        Scanner scanner=new Scanner(System.in);
        Random rnd=new Random();
        licz=rnd.nextInt(10);
System.out.println("Zgadnij liczbę od 0 do 9");
do{
    ile++;
    System.out.println("Podaj liczbę: ");
    odp=scanner.nextInt();
    if(odp>licz){
        System.out.println("Mniejsza ");
    }
    if(odp<licz){
        System.out.println("Większa");
    }
}while(odp!=licz);
System.out.println("Zgadłeś za " + ile + " razem");*/
int a,b,wyb=0;
Scanner scanner=new Scanner(System.in);

System.out.println("Podaj liczbe a: ");
a= scanner.nextInt();
        System.out.println("Podaj liczbe b: ");
        b= scanner.nextInt();
        while(wyb!=5) {
        System.out.println("1. dodaj");
        System.out.println("2. odejmij");
        System.out.println("3. pomnóż");
        System.out.println("4. podziel");
        System.out.println("5. wyjdz");

        System.out.println("Co chesz zrobić: ");
        wyb= scanner.nextInt();



    switch (wyb) {
        case 1:
            System.out.println(a + b);
            break;
        case 2:
            System.out.println(a - b);
            break;
        case 3:
            System.out.println(a * b);
            break;
        case 4:
            System.out.println(a / b);
            break;
        default:
            System.out.println("nie");
    }
}//while
    }
}
