//write a function to generate a possible n pairs of baanced parantheses
//{}{}{}->>>>{{{}}}, {{}}{} , {}{{}} ,{}{}{}, 
import java.util.*;
public class DPprintParantheses {
    //total=tota numbers of characters i.e. 2*n, open=count of opening bracket till now, close=count of closing
    //bracket ti now,s=string repersenting te parantheses til now, ans= a list store all the generated 
    //paranthese
    public static void printParanthesesRec(int total,int close,int open,String s,ArrayList<String>ans){
        //if the string s contains tota number of caracters this means that s is valid
        if (s.length()==total&&open==close&&open==total/2) {
            ans.add(s);
            return;
        }
        //if the cont of open barckts is more than the count of closing brackets,we cam give cosing bracket at 
        //this position
        if (open>close) {
            printParanthesesRec(total, close+1, open, s+"}", ans);
        }
        //if the count of open brackets is ess thente total?2, we can give opening bracket at this position
        if(open<total/2){
            printParanthesesRec(total, close, open+1, s+"{", ans);
        }
        //ese we can ony give closing bracket at thois index 
       // else{
        //    printParanthesesRec(total, close+1, open, s+"}", ans);
        //}

    }
    public static void validParanthese(int n){
        ArrayList<String>ans=new ArrayList<>();
        int total=2*n;
        printParanthesesRec(total, 0, 0, "", ans);
        for(String s:ans){
        System.out.println(s);
        }
    }
    public static void _printParanthese(char str[],int pos,int n,int open,int close){
        if (close==n) {
            for(int i=0;i<str.length;i++){
                System.out.print(str[i]);
            }
            System.out.println();
            return;

        }
        else{
            if(open>close){
                str[pos]='}';
                _printParanthese(str, pos+1, n, open, close+1);
                return;

            }
            if(open<n){
                str[pos]='{';
                _printParanthese(str, pos+1, n, open+1, close);
                return;
            }
        }
    }
    public static void printParanthese(char str[],int n){
        if (n>0) {
            _printParanthese(str, 0, n, 0, 0);
            return;
        }
    }
    public static void main(String[] args) {
        int n=4;
        //char str[]= new char[2*n]; 
        validParanthese(n);
        
       // printParanthese(str, n);
    }
        
}
