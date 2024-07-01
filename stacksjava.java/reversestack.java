import java.util.*;
public class reversestack{
    public static void reversestackfunc(Stack<Integer>s){
        //base case
       // reversing using recursion
       if(s.isEmpty()){
        return;
       }
       int top= s.pop();
       //recursion called
       reversestackfunc(s);
       pushAtbottom(s, top);

    }
    public static void pushAtbottom(Stack<Integer>s,int data){
        //base case
        if (s.isEmpty()) {
            return;
        }
            int top=s.pop();
            //recursive ca for the next level
            pushAtbottom(s, data);
            s.push(top);
        
    }
    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        reversestackfunc(s);
        System.out.print(s);
        

    }

}