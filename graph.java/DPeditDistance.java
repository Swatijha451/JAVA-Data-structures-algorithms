//given two strings , return the minimum number of operation to change str1 to str2
//operations are INSERT, DELETE, REPLACE
public class DPeditDistance {
    public static int editDistanceTab(String str1, String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
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
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];//no operation performed if characters are same
                }
                else{//differnt characters
                    int add=dp[i-1][j]+1;//left
                    int delete=dp[i][j-1]+1;//top
                    int replace=dp[i-1][j-1]+1;//diagonal
                    dp[i][j]=Math.min(add,Math.min(delete,replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1="abc";
        String str2="sbd";
        System.out.println(editDistanceTab(str1, str2));
    }
}
