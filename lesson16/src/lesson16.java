public class lesson16 {
    public static void main(String[] args){
int liczba = 50;
System.out.println("Liczba przed: "+ liczba);
zmien(liczba);
System.out.println("Liczba po: "+ liczba);
liczba oliczba=new liczba();
oliczba.liczba=50;
        System.out.println("Obiekt liczba przed: "+ oliczba.liczba);
        zmien(oliczba);
        System.out.println("Obiket liczba po: "+ oliczba.liczba);
    }
    public static void zmien(int liczba){
liczba= -1;
    }
    public static void zmien(liczba oliczba){
oliczba.liczba = -1;
    }
}
