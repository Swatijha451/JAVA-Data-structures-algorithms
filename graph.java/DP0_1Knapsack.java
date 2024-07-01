//dp conditions->choices, optimal solution(best possible solution)

public class DP0_1Knapsack {
    public static int knapsackRec(int val[], int wt[],int w, int n){
        //base case
        //if capacity is 0 or items are 0
        if (w==0||n==0) {
            return 0;
        }
        if (wt[n-1]<=w) {//valid condition
            //include condition
            int ans1= val[n-1]+knapsackRec(val, wt, w-wt[n-1], n-1);//resulting capacity and no of items after selecting
            //exclude
            int ans2= knapsackRec(val, wt, w,n-1);
            return Math.max(ans1, ans2);
        }
        //invalid condition
        else{
            return knapsackRec(val, wt, w, n-1);

        }

    }
    //dp steps->
    //capacity and items are  variable and dependent on each other so we make 2d dp array
    public static int knapsackMemo(int val[],int wt[],int w,int n,int dp[][]){
        //base case
        if (w==0||n==0) {
            return 0;
        }
        if (dp[n][w]!=-1) {//if value already exist dont calculate it again just return that value
            return dp[n][w];
        }
        if (wt[n-1]<=w) {//valid condition
            //include condition
            int ans1=val[n-1]+knapsackMemo(val, wt, w-wt[n-1], n-1, dp);
            //exclude
            int ans2=knapsackMemo(val, wt, w, n-1, dp);
             dp[n][w]=Math.max(ans1, ans2);
             return dp[n][w];
            
        }
        //invcalid condition
        else{
            dp[n][w]= knapsackMemo(val, wt, w, n-1, dp);
            return dp[n][w];

        }
    }
    //create table, meaning of every elemnt in table + intialize, fill bottom up or samll to large
    //or increasing order
    public static int knapsackTab(int val[], int wt[],int W){
        int n= val.length;
        int dp[][]= new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){//0Th column filled with 0
            dp[i][0]=0;//no items->no profit
        }
        for(int j=0;j<dp[0].length;j++){//0th row filed with 0
            dp[0][j]=0;// no capacity->no items in knapsack-.no profit
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];//
                int w=wt[i-1];
                if(w<=j){//valid
                    int incProfit=v+dp[i-1][j-w];
                    int excProfit=dp[i-1][j];
                    dp[i][j]=Math.max(incProfit, excProfit);

                }
                else{
                    //invalid condition
                    int excProfit=dp[i-1][j];
                    dp[i][j]=excProfit;
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};// items cost
        int wt[]={2,5,1,3,4};//item wt
        int w=7;//maximum capacity of knapsack
        //int dp[][]=new int[val.length+1][w+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        System.out.println(knapsackTab(val, wt, w));
        
    }
}
