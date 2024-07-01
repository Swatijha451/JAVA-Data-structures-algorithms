//te next greater element of some elemnt x in an array is the first grester element that is
//to the right of x in the same array 
//arr[6,8,0,1,3]= nextgraeter[8,-1,1,3,-1]
import java.util.*;
public class nextgreaterelement {
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        Stack <Integer>s = new Stack<>();
        int nextgreater[]=new int [arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while (!s.isEmpty()&&arr[s.peek()]<=arr[i]) {
                s.pop();
                
            }
            if (s.isEmpty()) {
                nextgreater[i]=-1;//in case there is no element larger than i
            }
            else{
                nextgreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for (int i = 0; i < nextgreater.length; i++) {
            System.out.print(nextgreater[i]+" ");
            
        }
        System.out.println();
    }
    
}
