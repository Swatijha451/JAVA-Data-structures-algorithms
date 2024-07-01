/*mountain and valley at any moment the number of down strojkes cannot be more than up Strokes
 * pair(/\)=(upstroke,downStroke)
 * no of valleys with three pair /\ /\ /\
 * /\/\/\, /\        /\    /\    /\/\
 *        /  \/\, /\/  \, /  \  /    \,
 *                       /    \,
 * 5 patterns -. this ia case of catalan nmber 
 * the down strokes should not exceed up stroke because it might go below the ground
 *  eve which is n invalid case
 * we wil use cataln number 
 */       
public class DPmountainRanges {
    public static int mountainRange(int n){
          int dp[]=new int[n+1];
          //initiaization
          dp[0]=1;
          dp[1]=1;
          for(int i=2;i<n+1;i++){
            for (int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
                //inside=dp[j]
                //outside=dp[i-j-1]
                //dp[i]=inside*outsiide
                
            }
          }
          return dp[n];
    }
    public static void main(String[] args) {
        int n=3;
        System.out.println(mountainRange(n));
    }
}
