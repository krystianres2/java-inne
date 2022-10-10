import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.Scanner;

public class Others {

   public static int hm=4;//how many good answers

    //function is searching if given number exist in array, if does not exist function return -1
    public static int binarySearch(int arr[], int first, int last, int element){
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr[mid] < element ){
                first = mid + 1;
            }else if ( arr[mid] == element ){
                return mid;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        return -1;
    }//binarySearch

    //function return false if binarySearch return -1 and return true is binarySearch return !1
    public static boolean bSe(int arr[],int element){
        int index=binarySearch(arr,0, arr.length-1,element );
        if(index==-1){
            return false;
        }return true;
    }//bSe

    //function is showing all wordPL and wordENG that exist in list
    public static void printList(ArrayList<Row> list){
        System.out.println();
        for(Row p:list){
            System.out.println(p.wordPl+" - "+ p.wordEng);
        }
        System.out.println();
    } //printList

    //function saves list to array
    public static Row[] listToArray(ArrayList<Row> list, Row[] array){
        try {
            array = list.toArray(new Row[list.size()]);
           /* for (int i = 0; i < array.length; i++) {
                System.out.println(array[i].wordPl);
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }
        return array;
    }//listToArray

//function check if both given string are equal, if length of any string is less than 2 or are not equal function return false
// otherwise return true
    public static boolean checkIfEqual(String firstW, String secondW){
        if (firstW.length()<2){
            return false;}
        if (secondW.length()<2){
            return false;}
        if(firstW.equals(secondW)){
        return true;}
        else {
        return false;}
    }//checkIfEqual

//function return 1 or 2
    public static int random12(){
    int a=(int)(Math.random()*(2)+1);
        return a;
    }//random12

    //fuction return random number between 0 and length
    public static int randomarray(int length){
        if (length<1){
            return -1;
        }
        int min=0;
        int max=length-1;

        int a=(int)(Math.random()*(max-min+1)+min);
        return a;

    }//randomarray

    //function return true if ga in all elements of array equal 2 and false if they !=2
    public static boolean checkIfLearned(Row[]array){
        int a=0;
        for(int i=0;i<array.length;i++){
            if(array[i].ga==hm){
            a++;}
        }
        if (a==array.length){
            return true;
        }else return false;
    }//checkIfLearned


    public static void learn(Row[] array){
        int a=0;
        int b=1;
        int be=-1;//to check if random number is not equal to random number before
        String word=" ";
        Scanner input=new Scanner(System.in);
        do {
            a=randomarray(array.length);
            if(a==be){
                a=randomarray(array.length);
            }
            be=a;
            b=random12();
            if (b==1&&array[a].ga!=hm){
                System.out.println(array[a].wordPl);
                System.out.println("Write this word in English");
                word=input.nextLine();
                if (checkIfEqual(array[a].wordEng,word)){
                    array[a].ga++;
                    System.out.println("Correct");
                    System.out.println();
                }else {
                    System.out.println("Incorrect");
                    System.out.println();
                }
            }//if
            if (b==2&&array[a].ga!=hm){
                System.out.println(array[a].wordEng);
                System.out.println("Write this word in Polish");
                word=input.nextLine();
                if (checkIfEqual(array[a].wordPl,word)){
                    array[a].ga++;
                    System.out.println("Correct");
                    System.out.println();
                }else {
                    System.out.println("Incorrect");
                    System.out.println();
                }
            }//if
            if (b!=1&&b!=2||array[a].ga>hm){
                System.out.println("Error");
            }
        }while (!checkIfLearned(array));
        System.out.println("You have learned all words");
        System.out.println();
    }//learn




}
