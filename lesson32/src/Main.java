public class Main {
    public static void main(String[] args){
    int j=100000;
        String s="";
        long start=System.currentTimeMillis();
        for(int i=0;i<j;i++){
            s+="a";


        }
        System.out.println(s);
        System.out.println("Czas: "+(System.currentTimeMillis()-start));

        StringBuilder sb=new StringBuilder();

        start=System.currentTimeMillis();
        for(int i=0;i<j;i++){
            sb.append("a");
        }
        System.out.println(sb.toString());
        System.out.println("Czas: "+(System.currentTimeMillis()-start));







    }
}
