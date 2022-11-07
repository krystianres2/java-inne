public class words extends DbConnector{
    private String wordPL;
    private String wordENG;

    public words(){
    }

    public words(String wordPL, String wordENG){
        this.wordPL=wordPL;
        this.wordENG=wordENG;
    }

    public String getWordPL() {
        return wordPL;
    }

    public void setWordPL(String wordPL) {
        this.wordPL = wordPL;
    }

    public String getWordENG() {
        return wordENG;
    }

    public void setWordENG(String wordENG) {
        this.wordENG = wordENG;
    }
}
