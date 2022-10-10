import java.util.ArrayList;
import java.util.Scanner;

public class Parking extends Auto {
static int miejsca=0;
static int maksimum=20;
String pom;
int po=0;
static int p=0;
static int k=0;
static int sc=0;
//static boolean check=false;

   static Scanner input=new Scanner(System.in);

public void addauto(){
    Scanner input2=new Scanner(System.in);
    if(miejsca<maksimum) {
    miejsca++;
    do {
        System.out.println("Podaj marke auta: ");
        pom = input2.nextLine();
        //System.out.println(pom);
        setMarka(pom);
    }while (pom.length()<3);//marka
do {
        System.out.println("Podaj kolor auta: ");
        pom=input2.nextLine();
        setKolor(pom);
}while (pom.length()<3);
        System.out.println("Podaj rejestracje auta: ");
        pom=input2.nextLine();
        setRejestracja(pom);
        System.out.println("Podaj nazwisko: ");
        pom=input2.nextLine();
        setNazwisko(pom);
        System.out.println("Podaj dlugosc abonamentu: ");
        po=input2.nextInt();
        setIleAbonament(po);
        if(ileAbonament>=1){
            abonament=true;
        }else {
            abonament=false;
        }
    }else{
        System.out.println("Nie ma wolnych miejsc");
    }
}//addauto


    public static int deleteAuto(){
    if (miejsca>0) {
        miejsca--;
        System.out.println("Podaj indeks auta do usuniecia");
        p = input.nextInt();
        return p;
    }else {
        System.out.println("Nie ma aut do usuniecia");
    return -1;}
    }//deleteAuto


public static void showall(ArrayList<Parking> lista){
    System.out.println("Na parkingu znajduje sie "+miejsca+" aut");
    k=0;
for(Parking p:lista){
    System.out.println("----------------------------------------");
    System.out.println(k+".");k++;
    System.out.println(p.getMarka());
    System.out.println(p.getKolor());
    System.out.println(p.getRejestracja());
    System.out.println(p.getNazwisko());
    System.out.println(p.getIleAbonament());
    System.out.println("----------------------------------------");
}
}//showall


}
