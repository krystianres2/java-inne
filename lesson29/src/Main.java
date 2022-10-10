public class Main {
    public static void main(String[] args){

        Animal cat=new Animal(){
            @Override
            void makeVoice() {
                System.out.println("Meoww Meow");
            }
        };

cat.makeVoice();

Animal cat2=new Animal();
cat2.makeVoice();
cat2.eat();
cat.eat();
        System.out.println("---------------------------");

        Animal.Pet pet=cat.new Pet();



    }
}
