public class lesson14 {
    public static void main(String[] args){

        Zwierze kot =new Zwierze();
        System.out.println(Zwierze.ile);

        kot.glos="Meeeow";
        kot.name="Milka";
       kot.przedstawSie();
       kot.dajGlos(3);

       Zwierze pies=new Zwierze();
        System.out.println(Zwierze.ile);
       pies.name="Reksio";
       pies.przedstawSie();


    }
}
