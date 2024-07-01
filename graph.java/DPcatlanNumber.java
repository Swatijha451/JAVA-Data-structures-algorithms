//Cn->C0*Cn-1+C1*Cn-2+C2*Cn-3....Cn-1*C0
//Cn=Cn-2*Cn-1+Cn-1*Cn-2;
//Cn+=Ci*Cn-i-1

//import java.util.Arrays;

public class DPcatlanNumber {
    public static int catalanRec(int n){
        //base case
        if(n==0||n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanRec(i)*catalanRec(n-i-1);
        }
        return ans;
    }
    public static int catalanMemo(int n,int dp[]){
        if(n==0||n==1){
            return dp[n];
        }
        if (dp[n]!=-1) {
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=catalanMemo(i, dp)*catalanMemo(n-i-1, dp);
        }
        return dp[n]=ans;
    }
    public static int catalanTab(int n){
        int dp[]=new int[n+1];
        //initiaize
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
             
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        //System.out.println(catalanRec(n));
        // int dp[]=new int [n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(catalanMemo(n, dp));
        System.out.println(catalanTab(n));
    }
}
