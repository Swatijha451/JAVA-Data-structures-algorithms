import java.util.Stack;

public class duplicateparantheses {
    public static boolean isDuplicate(String str){
        Stack<Character>s= new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch= str.charAt(i);
            //closing parantheses
            if(ch==')'){
                int count=0;
                while (s.peek()!='(') {
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;//duplicate exist
                }
                else{
                    return false;//not duplicate
                }
            }
            else{
                //opening parantheses
                s.push(ch);
            }
            
        }
        return false;
    }
    public static void main(String[] args) {
        String str="(((a+(b)))+(c+d))";
        System.out.println(isDuplicate( str));
    }
}
