public class Main {
    public static void main(String[] args){
        Animal kot=new Cat();
        kot.dajGlos();


       /* System.out.println(pies instanceof Cat);
        if(pies instanceof Cat){
            ((Cat)pies).idz();
        }

        if(pies instanceof Dog){
            ((Dog)pies).idz();
        }
        System.out.println(pies instanceof Animal);*/

        try {
            Animal pies=new Dog("");
            pies.dajGlos();

            ((Dog) pies).idz();
            int a=5/0;
        }catch(ClassCastException e){
            System.out.println(e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("Blad arytmetyczny");
        } catch(Exception e){
            System.out.println("Inny blad");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("\nWykonuje sie i tak");
        }



    }
}
