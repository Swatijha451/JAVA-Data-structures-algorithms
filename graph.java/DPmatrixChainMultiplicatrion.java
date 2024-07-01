/*some rues of matrix multiplication-> A[a*b],B[c*d]-> A*B
 * A*B is ony possible when b==c i.e. rows of A==columns of B
 * size of A*B=a*d
 * no of operation to multiply A & B =a*b*d
 * order of multiplications-.(((ab)c)d) or (a(b(cd))) or ((a(bc))d) or(a((bc)d)) or ((ab)(cd))
 * size of matrices in array will be arr[i-1]*arr[i]
 */
//import java.util.*;
public class DPmatrixChainMultiplicatrion {
    public static int MCMrec(int arr[],int i, int j){// i=starting point j=ending point of arr
        //base case
        if(i==j){
            return 0;// a single matrix cannot be multiplied by itself
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){//k wil go 1 to j-1 as i-1 will go negative if i starts from 0 & j wil start 
            //j-1 because when k becomes j-1 then j to j will be possible but j+1 to j is not valid
            //set 1 A1,A2,A3....Ak size=arr[i-1]*arr[k]//a*b
            int cost1=MCMrec(arr, i, k);
            //set 2 Ak+1..Aj seze=arr[k+1-1]*arr[j]=arr[k]*arr[j]//c*d
            int cost2=MCMrec(arr, k+1, j);
            int cost3=arr[i-1]*arr[k]*arr[j];//a*b*d
            int finaCost=cost1+cost2+cost3;
             ans=Math.min(ans, finaCost);
        }
        return ans;
    } 
    //memoization is more optimised recursion wher te multiple recrsive call is not done for same value,infact
    //it is stored in dp at its predefined index to be use later
    //tc=O(n*m)=row*column of the 2d Dp
    public static int MCMmemo(int arr[], int i, int j, int dp[][]){ 
        
        int ans=Integer.MAX_VALUE;
        //base case
        if(i==j){
            dp[i][j]=0;//when the there is matrix multiplication is invalid
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        //size of resutant matrix=arr[i-1]*arr[i]
        for(int k=i;k<=j-1;k++){
            int cost1=MCMmemo(arr, i, k, dp);//set 1
            int cost2=MCMmemo(arr, k+1, j, dp);//set2
            int cost3=arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans, cost1+cost2+cost3);
            dp[i][j]=ans;

        }
        return dp[i][j];
    }
    public static int MCMtab(int arr[]){
        int n= arr.length;
        int dp[][]=new int[n][n];
        //initiaization-> filing up diagonally
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (i==j) {//the diagonal in te dp wil be initiaized with 0  
                    dp[i][j]=0;//where single matrix is there
                }
            }
        }
        for(int len=2;len<=n-1;len++){//row going diagonaay len 0=0 len[1]=0 diagonay initaized
            for(int i=1;i<=n-len;i++){//row 
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1  ;k++){
                    int cost1=dp[i][k];//set1
                    int cost2=dp[k+1][j];//set2
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j], cost3+cost1+cost2);

                }
            }
        }
        return dp[1][n-1];
    }
        
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        //A=1*2, B=2*3, C=3*4 d=4*3
        //we have to find the order in which A<B<C<D shold ne multiplied such tat nber of opertions is minimum
        //other words find to minimun cost so its a Dp problem
        
        //System.out.println(MCMrec(arr, 1, n-1  ));
        // int dp[][]= new int [n][n];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // System.out.println(MCMmemo(arr, 1, n-1, dp));
        System.out.println(MCMtab(arr));
    }
}
