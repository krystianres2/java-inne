public class Auto {
String marka="BMW";
String rejestracja="999999999";
String kolor="Bialy";
String nazwisko="Kowalski";
boolean abonament=false;
int ileAbonament=6;
//String pom="a";

//getter
String getMarka(){
    return "Model: "+this.marka;
}
//setter
void setMarka(String marka){
    if(marka.length()>2){
        this.marka=marka;
        //Parking.check=true;
    }else{
        System.out.println("Niepoprawna nazwa");
        //Parking.check=false;
    }
}
//getter
String getKolor(){
    return "Kolor: "+this.kolor;
}
//setter
public void setKolor(String kolor){
    if(kolor.length()>=3){
        this.kolor=kolor;
    }else{
        System.out.println("Niepoprawna nazwa");
    }
}
    //getter
     String getRejestracja(){
        return "Rejestracja: "+this.rejestracja;
    }
    //setter
    void setRejestracja(String rejestracja){
        if(rejestracja.length()>=4){
            this.rejestracja=rejestracja;
        }else{
            System.out.println("Niepoprawna nazwa");
        }
    }

    //getter
    String getNazwisko(){
        return "Nazwisko: "+this.nazwisko;
    }
    //setter
    void setNazwisko(String nazwisko){
        if(nazwisko.length()>=2){
            this.nazwisko=nazwisko;
        }else{
            System.out.println("Niepoprawna nazwa");
        }
    }
    //getter
    String getIleAbonament(){
        return "Dlugosc abonamentu w godzinach: "+this.ileAbonament;
    }
    //setter
    void setIleAbonament(int ileAbonament){
        if(ileAbonament>=1){//godziny
            this.ileAbonament=ileAbonament;
        }else{
            System.out.println("Niepoprawna wartosc");
        }
    }







}
