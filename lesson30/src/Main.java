public class Main {
    public static void main(String[] args){

        //Obliczenia ob1=new Obliczenia();
        //Obliczenia ob2=new Obliczenia();

        Thread ob1=new Thread(new Obliczenia());
        Thread ob2=new Thread(new Obliczenia());

        ob1.start();
        ob2.start();







    }
}
