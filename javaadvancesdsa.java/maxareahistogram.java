import java.util.*;

public class maxareahistogram {
    public static int maxarea(int arr[]){
        int maxArrea=0;
        int nextsmallerright[]=new int[arr.length];//
        int nextsmallerleft[]= new int[arr.length];
        //next samaller rigjt
        Stack <Integer>s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextsmallerright[i]=arr.length;
            } else{
                nextsmallerright[i]=s.peek();
            }
            s.push(i);
        }
        //next smaler rigt
        for(int i=0;i<arr.length;i++){
            s=new Stack<>();//emptying the above stack
            while (!s.isEmpty()&&arr[s.peek()]>=arr[i]) {
                s.pop();
                
            }
            if (s.isEmpty()) {
                nextsmallerleft[i]=-1;
            }
            else{
                nextsmallerleft[i]=s.peek();
                
            }
            s.push(i);

        }
        for (int i = 0; i < arr.length; i++) {
            int height=arr[i];
            int width=nextsmallerright[i]-nextsmallerleft[i]-1;
            int currarea=height*width;
            maxArrea=Math.max(maxArrea, currarea);
            
        }
        return maxArrea;

    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println(maxarea(arr));
        
    }
}
