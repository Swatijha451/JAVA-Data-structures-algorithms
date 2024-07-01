//find the number of all possible BSTs with given n nodes->catalan nmber pattern
//BST=eft node<root node<right node
//0,1,2,5,9,14 for nodes[0,1,2,3,4,5] and so on
public class DPcountingTrees {
    //tabation
    public static int countBSTs(int n){
        int dp[]=new int [n+1];
        //initializtion
        dp[0]=1;
        dp[1]=1;
        //ottom up fill
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];//left=dp[j],right=dp[i-j-1],dp[i]+=left*right
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(countBSTs(n));
    }
}
