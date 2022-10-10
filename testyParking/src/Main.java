import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int wyb=0;
        int it=0;
        Scanner scanner=new Scanner(System.in);
        ArrayList<Parking>lista=new ArrayList<Parking>();
Parking p1=new Parking();

//p1.addauto();

        //System.out.println(p1.getKolor());
        //System.out.println(p1.getMarka());
        //System.out.println(p1.getRejestracja());
        //System.out.println(p1.getNazwisko());
        try {
            Parking[] obj = new Parking[99];
            for (int i = 0; i < 99; i++) {
                obj[i] = new Parking();
            }

            while (wyb != 4) {

                System.out.println("1.Dodaj auto");
                System.out.println("2.Usun auto");
                System.out.println("3.Wypisz wszystkie auta");
                System.out.println("4.Wyjdz");

                System.out.println("Co chcesz zrobic: ");
                wyb = scanner.nextInt();

                switch (wyb) {
                    case 1:
                        obj[it].addauto();
                        System.out.println("Pomyslnie dodano nowe auto na miejsce nr. " + (Parking.miejsca - 1));
                        System.out.println();
                        lista.add(obj[it]);
                        it++;
                        break;
                    case 2:
                        //Parking.deleteAuto();
                        if (Parking.p < lista.size() && Parking.p >= 0) {
                            lista.remove(Parking.deleteAuto());
                            System.out.println("Pomyslnie usunieto auto nr. " + Parking.p);
                        }
            /*else {
                System.out.println("Nie ma aut do usuniecia");
            }*/
                        break;
                    case 3:
                        System.out.println((lista.get(0)).nazwisko);
                        Parking.showall(lista);
                        break;
                }//switch

            }//while


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
