/*given a string and a wildcard pattern, implement wild card matching agoritm that finds its wildcard pattern is
 * matched with te string. te matching sold cover the entire string(not partia text). The wildcard pattern includes
 * '?','*' and charcters(aplphabets, numbers).
 * ?- matches any single character(alphanumeric vaue) & cannot matc empty String
 * *-matches any sequence of characters(mutiple characters) including empty sequence
 */
public class DPwildCardMatching {
    public static boolean wildCardMatchingTab(String str,String pattern){
        int n=str.length();
        int m=pattern.length();
        //create dp table->2d ecause ther atre two variabes n and m
        boolean dp[][]= new boolean[n+1][m+1];
        //initailaze
        dp[0][0]=true;//no pattern & no string will always match
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }//oth column from 1 to i// onlt string but no pattern -no match
            for(int j=1;j<m+1;j++){
                if(pattern.charAt(j-1)=='*'){//a other caracter of pattern is also * before j
                    //look to your left
                    dp[0][j]=dp[0][j-1];// true or false depends on wheather other strings matc or not
                }
                else{//if pattern.charAt(j-1)=='?'or any caracter/number
                dp[0][j]=false;//by default also it is false;
                }
            }
            //bottom up fiiling
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if (str.charAt(i-1)==pattern.charAt(j-1)||pattern.charAt(j-1)=='?') {
                        
                        dp[i][j]=dp[i-1][j-1];//other characters before it mtched or not
                    }
                    else if (pattern.charAt(j-1)=='*') {
                        //ignore star||match star
                        dp[i][j]=dp[i-1][j]||dp[i][j-1];//look left or look up whatever is te value of their OR
                    }
                    else{//any other character
                        dp[i][j]=false;
                    }
                }
            }
            return dp[n][m];

        
    }
    public static void main(String[] args) {
        String str="abc";
        String pattern="**?b?*";
        System.out.println(wildCardMatchingTab(str, pattern));

    }
}
