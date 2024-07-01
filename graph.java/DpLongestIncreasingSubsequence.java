//longest subseqence length

import java.util.Arrays;
import java.util.HashSet;

public class DpLongestIncreasingSubsequence {
    public static int LCStab(int arr[],int arr2[]){
        int n=arr.length;
        int m=arr2.length;
        int dp[][]=new int[n+1][m+1];
        //initialize
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0){//when arr1 || arr2 is empty lis will be 0;
                    dp[i][j]=0;//0th row, 0th col
                }
            }
        }
        //bottom up filling dp
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr[i-1]==arr2[j-1]){//if the elements same
                    dp[i][j]=dp[i-1][j-1]+1;//check for other eements
                }
                else{//if not same
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);//
                }
            }
        }
        return dp[n][m];

    }
    public static int longestIncresingSubsequenceTab(int arr[]){
        //creating hashset to get unique elements of arr
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        //copy of arr in arr2 with unique elemnts of set
        int arr2[]=new int[set.size()];
        int i=0;
        for(int num:set){
            arr2[i]=num;
            i++;

        }
        //sort the unique elments of arr2 to do lcs operation on arr to find the longest incresing subsequence
        Arrays.sort(arr2);
        return LCStab(arr, arr2);
    }
    public static void main(String[] args) {
        int arr[]={50,3,10,7,40,80};
        System.out.println(longestIncresingSubsequenceTab(arr));

    }
}
