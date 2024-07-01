//Minimum Subset Sum & Partitioning subsets=Variation of 0-1 Knapsack problem
//sum= sum of elememnts of arr, 
//|sum2-sum1|=0 => best case scenario, it implies sum2==sum1
//if the set1 and 2 contains sum/2 elements then, sets wil have equally divided no of elements
public class DPminimumSumPartition {
    //find the sum of n elements
    //create dp[n+1][w+1] where n= size of array w is capacity , here it is sum/2
    public static int minPartition(int arr[]){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        //create dp
        int w= sum/2;
        //initialize
        int dp[][]=new int[n+1][w+1];
         for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
         }
        //fill -> bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if (arr[i-1]<=j) {//valid condition->come or not come int the set
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }
                else{//invalid condition
                    dp[i][j]=dp[i-1][j];//exclude
                }
            }
        }
        int sum1=dp[n][w];
        int sum2=sum=sum1;
        return Math.abs(sum1-sum2);
    }
    public static void main(String[] args) {
        int nums[]={1,6,11,5};
        System.out.println(minPartition(nums));
    }
}
