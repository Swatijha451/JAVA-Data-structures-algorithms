//retrn the length of longest common substring, substring restarts after one different letter not continue
// like subsequence problem
public class DPlongestCommonSubtstring {
    public static int LCSubstringTab(String s1, String s2){
        int n= s1.length();
        int m= s2.length();
        int ans=0;   
        //create dp
        int dp[][]= new int[n+1][m+1];
        
        //initialise
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0||j==0) {//if s1 or s2 is 0 or empty ""
                    dp[i][j]=0;
                }
            }
        }
        //in this dp table it does not necessariy mean the answer lies at dp[n][m]index ,
        // it can be anywhere in dp
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j]=0;
                }

            }
        }
        return ans;

    }
    public static void main(String[] args) {
        String s1="abcdgh";
        String s2="abcdghr";
        System.out.println(LCSubstringTab(s1, s2));
    }
}
  