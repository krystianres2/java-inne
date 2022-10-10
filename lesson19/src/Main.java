import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

Animal kot1=new Animal("Rudy");
Animal kot2=new Animal("Bury");
Animal kot3=new Animal("Biały");

        ArrayList lista=new ArrayList();
        ArrayList<Animal> listaG=new ArrayList<Animal>();     //generyczna


        lista.add(kot1);
        lista.add(kot2);
        lista.add(kot3);

        listaG.add(kot1);
        listaG.add(kot2);
        listaG.add(kot3);

        ArrayList<Animal> listaT=new ArrayList<Animal>();
        for(Animal T:listaG){
                listaG.add(T.)
        }


        System.out.println((listaG.get(0)).imie);
        System.out.println("------------");
        for(Animal k : listaG){
            System.out.println(k.imie);
        }
        System.out.println("------------");




        System.out.println("------------");
        for(Object k : lista){
            System.out.println(((Animal)k).imie);
        }
        System.out.println("------------");

        System.out.println(((Animal)lista.get(0)).imie);
        System.out.println(lista.size());
        System.out.println(lista.contains(kot1));//check if added
        lista.remove(kot2);
        lista.remove(0);

        lista.clear();
        System.out.println(lista.size());



        System.out.println("------------");
        for(Object k : lista){
            System.out.println(((Animal)k).imie);
        }
        System.out.println("------------");
    }
}
