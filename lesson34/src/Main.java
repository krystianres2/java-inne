public class Main {
    public static void main(String[] args){

      final int LICZBA=3;
long start=System.nanoTime();
        System.out.println(silnia(LICZBA));
long end=System.nanoTime()-start;
        System.out.println("Czas: "+end);
        System.out.println();

        start=System.nanoTime();
        System.out.println(silniaRek(LICZBA));
        end=System.nanoTime()-start;
        System.out.println("Czas: "+end);

    }

    private static long silniaRek(int x) {
        if(x<=1){
        return 1;
    }else{
            return x * silniaRek(x-1);
        }

    }

    private static long silnia(int x) {
        long wynik=1;
        while(x>1){
            wynik *=x;
            x--;
        }
        return wynik;
    }
}
