import java.util.*;
public class reversestack{
    public static void reverseStack(Stack<Integer>s){
        //base case
       // reversing using recursion
       if(s.isEmpty()){
        return;
       }
       int top= s.pop();
       //recursion called
       reverseStack(s);
       pushatbottom.pushAtbottom(s, top);

    }
    
    public static void printstack(Stack<Integer>s){
        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);
        s.push(0);
        
        reverseStack(s);
        printstack(s);
    
       }

    }

