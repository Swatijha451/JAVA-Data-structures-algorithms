//convert str1 to str2 with minimum number of operations of ADD, DELETE
public class DPstringconveersion2 {
    public static int stringConversiontype1(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int dp[][]= new int[n+1][m+1];
        //initiaize
        for (int i = 0; i < n+1; i++) {
            for(int j=0;j<m+1;j++){
                if(i==0){//if str1 is empty we add jth element to str1
                    dp[i][j]=j;//0,1,2,3
                }
                if(j==0){//if str2 is empty we delete every ith elment from str1
                    dp[i][j]=i;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)) {//same  letter
                    dp[i][j]=dp[i-1][j-1];//
                }else{//different letter
                    int add=dp[i-1][j]+1;//left
                    int delete=dp[i][j-1]+1;//top
                    dp[i][j]=Math.min(add,delete);
                }
            }
        }
        return dp[n][m];
        
    }
    //another way of string conversion using two operations is
    //find Longest Common Subsequence(LCS) of str1 & str2-> find the differnce in length of str1&lcs
    //lcs(str1-Lcs)=no of delete opeartion->find difference in length of lcs&str2 (str2-lcs)= no of add operation
    //total no of operation is no of add & delete operation
    public static int LCStab(String str1, String str2){
        int n=str1.length();
        int m= str2.length();
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
              if(i==0||j==0){
                dp[i][j]=0;
              }
            }
        }
        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)) {//characters are same
                    dp[i][j]=dp[i-1][j-1]+1;//
                }else{//different letter
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);//max of up &left index of dp table
                }
                
            }
        }
        return dp[n][m];
    } 
    public static int stringConversion(String str1,String str2){
        int n=str1.length();//str1-lcs=delete operation
        int m=str2.length();//str2-lcs=add operation
        int len=LCStab(str1, str2);//Longest Common Subsequence
        return (n-len)+(m-len);//delete+add operations=no of operations to convert str1 to str2
    }


    public static void main(String[] args) {
        String str1="abcdef";
        String str2="aceg";
        System.out.println(stringConversion(str1, str2));
        System.out.println(stringConversiontype1(str1, str2));

    }
}
