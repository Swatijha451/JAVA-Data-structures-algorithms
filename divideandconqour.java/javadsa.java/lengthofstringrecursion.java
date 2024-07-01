
public class lengthofstringrecursion {
    public static int lengthofstring(String str){
    //base case
    if(str.length()==0){
        return 0;
    }
    return lengthofstring(str.substring(1))+1;

    }
    public static void main(String[] args) {
        String str= "abcefgh";
        System.out.print(lengthofstring(str));
    }
}
