import java.util.ArrayList;
import java.util.List;
import java.lang.Class;
public class Main {
    public static void main(String[] args) {
      KOt[] obj=new KOt[99];

      for(int i=0;i<99;i++){
          obj[i]=new KOt();

      }
obj[0].wiek=5;
        //System.out.println(obj[0].wiek);
        //test listy
        //ArrayList lista=new ArrayList();
        KOt k1=new KOt();
        KOt k2=new KOt();
        KOt k3=new KOt();
        KOt k4=new KOt();

        k1.wiek=0;
        k2.wiek=1;
        k3.wiek=2;
        k4.wiek=3;

       /* lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);
     for (Object k : lista){
         System.out.println(((KOt)k).wiek);
     }
        System.out.println("-------------------------");
        System.out.println("-------------------------");
lista.remove(2);
        for (Object k : lista){
            System.out.println(((KOt)k).wiek);
        }
        System.out.println(((KOt)lista.get(2)).wiek);*/

        ArrayList<KOt>listaG=new ArrayList<KOt>();//generyczna
listaG.add(k1);
listaG.add(k2);
listaG.add(k3);
listaG.add(k4);
for (KOt k:listaG){
    System.out.println(k.wiek);
}
listaG.remove(2);
        System.out.println((listaG.get(2)).wiek);
    }
}
