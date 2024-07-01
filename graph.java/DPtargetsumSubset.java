//4,7,1,3,2=>4,1,3,2| 7,3|7,1,2|
//there are also emplty sbsets 
public class DPtargetsumSubset {
    public static boolean sumSumbsetTab(int nums[],int tSum){
        boolean dp[][]=new boolean[nums.length+1][tSum+1];// dp table
        int n=nums.length;
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;//intialize orginay in java booean is intiaized with false
        }
        //i is the items of nums
        //j is the target sum
        //[i,j] will hava the answe
        for(int i=1;i<n+1;i++){
            for(int j=1;j<tSum+1;j++){
                int v=nums[i-1];//here the number itself is weight in the target sum
                if (v<=j&& dp[i-1][j-v]==true) {//valid and include
                    dp[i][j]=true;
                }
                else if (dp[i-1][j]==true) {//invaid
                    dp[i][j]=true;
                }
            }
        }
        return dp[n][tSum];

    }
    public static void main(String[] args) {
        int number[]={1,2,3,4};
        int target=3;
        System.out.println(sumSumbsetTab(number, target));
    }
}
