//Given a rod of rength of n inches and an array od array that reprsents the price of cutting rod in the inches 
//smaller that its size. Determine themaximumm value obtainable by cutting up the rod and selling the pieces
public class DProdCutting {
    public static int cuttingRod(int length[],int price[],int len){
        //we will do Tabulation DP->Create table,meaning + initiaize, fill bottom up(small to large)
        int n=price.length;
        int dp[][]=new int [n+1][len+1];//created DP table
        for(int i=0;i<n+1;i++){//initiized Dp table
            for(int j=0;j<len+1;j++){
                if (i==0||j==0) {//when length is 0 or when tere is no price for cutting the rod at i length
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<len+1;j++){
                if (length[i-1]<=j) {//valid->inalude/exclude
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }
                else{//invalid then no choice just exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][len];
    }
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int len=8;
        System.out.println(cuttingRod(length, price, len));
    }
}
