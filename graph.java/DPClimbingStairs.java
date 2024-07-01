//count ways to reach the nth stair, the person can take 1 or 2 steps 
import java.util.*;
public class DPClimbingStairs {
    //recursion
    public static int countWaysRec(int n){
        if (n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return countWaysRec(n-1)+countWaysRec(n-2);
    }
    //memoization
    public static int countWaysMem(int n, int []ways){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if (ways[n]!=-1) {
            return ways[n];
        }
        ways[n]=countWaysMem(n-1, ways)+countWaysMem(n-2, ways);
        return ways[n];

    }
    //tabulation
    public static int countWaysTabulation(int n){
        int ways[]=new int[n+1];
        ways[0]=1;
        ways[1]=1;
        for(int i=2;i<=n;i++){
            ways[i]=ways[i-1]+ways[i-2];
        }
        return ways[n];
    }

   public static void main(String[] args) {
    int n=5 ;
    int []ways=new int[n+1];
    Arrays.fill(ways,-1);

    System.out.println(countWaysTabulation(n));
   } 
}
