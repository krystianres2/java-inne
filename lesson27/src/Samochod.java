public class Samochod extends Pojazd implements Poruszanie{
    int iloscKol;
    Samochod(String nazwa, int iloscKol) {
        super(nazwa);
        this.iloscKol=iloscKol;
    }

    @Override
    public void jedzDoPrzodu() {
        System.out.println("jAde");
    }

    @Override
    public void skrecaj() {
        System.out.println("Skrecam");
    }
}
