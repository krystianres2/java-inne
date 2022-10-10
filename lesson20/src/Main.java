import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){

        LinkedList<String> lista=new LinkedList<>();
        lista.add("Poznan");
        lista.add("Warszawa");
        lista.remove(0);
        for(String e:lista){
        //System.out.println(e);
}
        HashMap<Integer,String> mapa=new HashMap<>();
        mapa.put(1,"Poniedzialek");
        mapa.put(5,"Piatek");
        mapa.put(7,"Niedziela");

        System.out.println(mapa.get(5));
        System.out.println();
for(String e:mapa.values()){
    System.out.println(e);
}
        LinkedHashSet<String> zbior = new LinkedHashSet<>();
        zbior.add("Warszawa");
        zbior.add("Poznan");
        zbior.add("Szczecin");
        zbior.add("Szczecin");
        System.out.println();

        for(String e: zbior){
            System.out.println(e);
        }

        System.out.println(zbior.size());



    }
}
