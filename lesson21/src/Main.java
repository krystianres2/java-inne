import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args){

        ArrayList<String> lista=new ArrayList<>();
        lista.add("Poznan");
        lista.add("Warszawa");
        lista.add("Gdansk");
        lista.add("Szczecin");

        System.out.println();

        for(String e:lista){
            System.out.println(e);
        }

        Collections.sort(lista);
        System.out.println();
        for(String e:lista){
            System.out.println(e);
        }
        System.out.println();
        System.out.println(Collections.min(lista));
        System.out.println();
        System.out.println(Collections.max(lista));

        Collections.reverse(lista);
        System.out.println();
        for(String e:lista){
            System.out.println(e);
        }

        Collections.shuffle(lista); //potasuj
        System.out.println();
        for(String e:lista){
            System.out.println(e);
        }

ArrayList<Animal> koty=new ArrayList<Animal>();
Animal kot1=new Animal("Czarny");
Animal kot2=new Animal("Bury");
Animal kot3=new Animal("Rudy");
Animal kot4=new Animal("Bialy");
Animal kot5=new Animal("Bialy");
kot4.wiek=10;

koty.add(kot1);
koty.add(kot2);
koty.add(kot3);
koty.add(kot4);
koty.add(kot5);

        System.out.println();
        for(Animal kot:koty){
            System.out.println(kot.name+" "+kot.wiek+ " lat.");
        }

        Collections.sort(koty);

        System.out.println();
        for(Animal kot:koty){
            System.out.println(kot.name+" "+kot.wiek+ " lat.");
        }


    }
}
