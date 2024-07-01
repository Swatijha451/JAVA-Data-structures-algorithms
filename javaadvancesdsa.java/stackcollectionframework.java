import java.util.*;
public class stackcollectionframework {
    public static void main(String[] args) {
         Stack <Integer> s=new Stack<>();
         s.push(0);
         s.push(1);
         s.push(2);
         while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
            
         }

        
    }
   
    
}
