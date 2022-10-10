public class Zwierze {

   static int ile=0;
    Zwierze(){
        ile++;
    }

    String name;
    String glos="Grrrrr";
    public void dajGlos(int x){
        for(int i=0;i<x;i++){
            System.out.print(glos);
            System.out.print(" ");
        }
        System.out.println();
    }
    public void przedstawSie(){
        System.out.println("Nazwywam sie: "+ name);
    }


}
