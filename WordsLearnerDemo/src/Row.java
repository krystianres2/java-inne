public class Row {
    String wordPl;
    String wordEng;
    int ga=0; //good answers

    //getters and setters

String getWordPl(){return this.wordPl;}//getter

public static void setWordPl(String wordPl){
if(wordPl.length()<2){
        System.out.println("Incorrect words lenght");}
}//setter

String getWordEng(){return this.wordEng;}//getter

public static void setWordEng(String wordEng){
   if (wordEng.length()<2){
        System.out.println("Incorrect words lenght");}
}//setter

int getGa(){return this.ga;}//getter



}
