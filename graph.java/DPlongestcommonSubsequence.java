//longest subsequence between 2 strings here maeans length of common words among the strrings continously 
public class DPlongestcommonSubsequence {
    public static int LCSrec(String s1, String s2, int n, int m){
        
        //base case
        if (n==0||m==0) {//if s1 length is 0 or ""|| s2 length is 0 or""
            return 0;
        }
        if (s1.charAt(n-1)==s2.charAt(m-1)) {
        
           return  LCSrec(s1, s2, n-1, m-1)+1;//+1 for ist common word then for nect, next , next....
        }
        else{
            int ans1=LCSrec(s1, s2, n-1, m);
            int ans2=LCSrec(s1, s2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }
    public static int LCSmemo(String s1,String s2,int n, int m, int dp[][]){
        if(n==0||m==0){
            return 0;
        }
        if (dp[n][m]!=-1) {
            return dp[n][m];
        }
        if (s1.charAt(n-1)==s2.charAt(m-1)) {
        
            return  LCSmemo(s1, s2, n-1, m-1,dp)+1;//+1 for ist common word then for nect, next , next....
         }
         else{
             int ans1=LCSmemo(s1, s2, n-1, m,dp);
             int ans2=LCSmemo(s1, s2, n, m-1,dp);
            return Math.max(ans1, ans2);
         }   
    }
    public static int LCStab(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if (i==0||j==0) {
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)) {//same  letter
                    dp[i][j]=dp[i-1][j-1]+1;//
                }else{//different letter
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);//max of up &left index of dp table
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1="abcdeg";
        String s2="abedg";//ans wil be abdg
        // int dp[][]= new int [s1.length()+1][s2.length()+1];
        // for(int i=0;i<s1.length()+1;i++){
        //     for(int j=0;j<s2.length()+1;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println(LCSmemo(s1, s2,s1.length(), s2.length(), dp));
        System.out.println(LCStab(s1, s2));
        
    }
}
