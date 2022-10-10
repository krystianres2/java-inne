public class Dog extends Animal{
    Dog(String imie) throws ZleImieException {
        if(imie.length()==0){
            throw new ZleImieException();
        }
        this.imie=imie;
    }

    String imie;

    @Override
    public void dajGlos() {
        System.out.println("How How");
    }

    public void idz(){
        System.out.println("Ide sobie");
    }

}
