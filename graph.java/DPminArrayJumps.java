//the array given stores the number of steps that can be taken at that point for exampe arr[1]=3 i.e. we can take 
//1 or 2 or 3 but not more thn 3 from arr[1] position 
// this question is not greedy but dp as there is always coice in how many steps to take

import java.util.Arrays;

public class DPminArrayJumps{
    public static int minArryJumps(int arr[]){
//ere starting point/index is variabe so we create 1d dp array containing dp[i]=min number of jumps (i to n-1 )     
        int n=arr.length;
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        //dp[n-1]=destination, whic will always have 0 min jumps 
        //initialization
        dp[n-1]=0;
        //i=kaha se jump lena hai , j= kaha tak jump lene hai
        for(int i=n-2;i>=0;i--){
            int jumps=arr[i];//maximum jumps
            int ans=Integer.MAX_VALUE;
            for(int j=i+1;j<=i+jumps && j<n;j++){// if are standing at i then we can go to i+1 til i+maximm jumps
                //j<n because wile jumping we dont go out of the array
                if (dp[j]!=-1) {
                    ans= Math.min(ans,dp[j]+1);
                }
            }
            if (ans!=Integer.MAX_VALUE) {
                dp[i]=ans;
            }
        }
        return dp[0];

    }
    public static void main(String args[]){
        //find the minimm number of jumps needed to be taken to reach destination 
        int arr[]={2,3,1,1,4};
        System.out.println(minArryJumps(arr));

    }
}
