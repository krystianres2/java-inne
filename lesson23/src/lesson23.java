public class lesson23 {
    public static void main(String[] args){

Samochod audi=new Samochod("Audi", 4, 2);
audi.iloscKol=4;
audi.marka="Audi";
        System.out.println(audi.iloscKol+" "+audi.marka);

audi.odpal();

audi.zamknijOtworz();
audi.zamknijOtworz();

SamochodSportowy subaru=new SamochodSportowy("Subaru", 4,4);
subaru.zamknijOtworz();
subaru.odpal();

Motocykl suzuki=new Motocykl();
        System.out.println(suzuki.iloscKol);


    }
}
