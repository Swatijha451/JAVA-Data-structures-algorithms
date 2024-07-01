//it is similar to 0-1 knapsack except for the fact include item can be taken multiple times for maximum value
public class DPunboundedKnapsack {
    public static int unboundedKnapsack(int []val,int[] wt,int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];
        //intialization
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;//0th column wherw there is no aximum capacity
        }
        for(int j=0;j<W+1;j++){
            dp[0][j]=0;//0Th row ehere there are np items 
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if (wt[i-1]<=j) {//valid condition->incude/exclude
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j] );
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];

    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};// items cost
        int wt[]={2,5,1,3,4};//item wt
        int w=7;
        System.out.println(unboundedKnapsack(val, wt, w));
    }
    
}

