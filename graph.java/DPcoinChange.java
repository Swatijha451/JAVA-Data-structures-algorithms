//retrn nmber of ways the chang can be given with given coins
//variation of unbounded of knapsack with unimited supply of nmber of coins
public class DPcoinChange {
    public static int coinchangeTab(int coin[],int change){
        int n=coin.length;
        int dp[][]=new int[n+1][change+1];
        //initiaize
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=1;//0t column -> teh ways ogf not  getting change is empty set thus 1
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;//0th row giving change without any coins is invalid
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<change+1;j++){
                if (coin[i-1]<=j) {//valid-.incude+excude
                    dp[i][j]=dp[i][j-coin[i-1]]+dp[i-1][j];//incude a coins in chnage- value of coin and exclude
                    //coin in full chnge ;
                    
                }
                else{//exclude coin
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][change];
    }
     
    public static void main(String[] args) {
        int coin[]={1,2,3};
        int change=6;
        System.out.println(coinchangeTab(coin, change));
    }
}
