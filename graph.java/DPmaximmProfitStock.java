//maximum profit after buying & seling stocks with transaction fees. find max profit & diff in day.we can 
//make multiple transactoin one after other not  at the same time
//At any moment we can either buy/sell-. f we decide to buy then we can either sell or hold it on to next idx
//if we decide to sell, incur transactio fee & pass on to next index or buy another stock(transaction 2)
import java.util.*;
public class DPmaximmProfitStock {
    public static int maximumProfitRec(int idx, int n, int buy,int prices[],int fee){
        //base case
      if (idx==n) {
        return 0;// if the index pointer has reached te end of te array
      }
      int profit=0;
      //you can either buy or no buy
      if (buy==0) {
        //-price[idx] becase after technically buying cost reduces profit,
        //at first indes we buy than we cant have a profit
        profit=Math.max(-prices[idx]+maximumProfitRec(idx+1, n, 1, prices, fee),//buying condition
        maximumProfitRec(idx+1, n, 0, prices, fee));//not buying
      }
      else{
        //if we sell or not sell
        profit=Math.max(prices[idx]-fee+maximumProfitRec(idx+1, n, 0, prices, fee),//sell
        maximumProfitRec(idx+1, n,1, prices, fee));//not sel and buy stays 1
      }
      return profit;
       
    }
    //memoization
    public static int maximumProfitMemo(int arr[],int idx,int buy,int fee,int dp[][] ){
        int n=arr.length;
        //bae case
        if (idx==n) {
            return 0;
        }
        //if the vaue has already been cacuated
        if (dp[idx][buy]!=-1) {
            return dp[idx][buy];
        }
        int profit=0;
        for(int i=1;i<n;i++){
            if (buy==0) {
                dp[idx][buy]= profit=Math.max(-arr[idx]+maximumProfitMemo(arr,idx+1,1,fee,dp),
                maximumProfitMemo(arr,idx+1,0,fee,dp));
            }
            else{
                dp[idx][buy]=profit=Math.max(arr[idx]-fee+maximumProfitMemo(arr, idx+1, 0, fee, dp),
                maximumProfitMemo(arr, idx+1, 1, fee, dp));
            }
        }
        return profit;


    }
    public static int maximumProfitTab(int arr[],int fee){
        //2d table profit on dp[i][j]->i=prices on ith day & j->wheather or not we are holding the stock
        //f[0][0]=0 first day we can ony buy astock and not old and thus profit wil be negative
        //f[1][0]=-arr[0]//we buy a stock on first day
        int buy=-arr[0];
        int sell=0;
        int n=arr.length;
        for(int i=1;i<n;i++){
            int temp=buy;
            buy=Math.max(buy,sell-arr[i]);
            sell=Math.max(sell, temp+arr[i]-fee);
        }
        return Math.max(sell, buy);
    }
    public static void main(String[] args) {
        int arr[]={6,1,7,2,4,8};
        int n= arr.length;
        int fee=2;
         int dp[][]=new int[n+1][2];
         for(int i=0;i<n+1;i++){
             Arrays.fill(dp[i],-1);
         }
        //System.out.println(maximumProfitRec(0, n, 0, arr, fee));
        System.out.println(maximumProfitMemo(arr, 0, 0,fee, dp));
        System.out.println(maximumProfitTab(arr, fee));
    }
}
