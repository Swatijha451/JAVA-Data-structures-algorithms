public class tilingproblemrecursion {
    public static int tilingproblem(int n){//2*n
        //base case
        if(n==0||n==1){
            return 1;
        }
        //choice is vertical
        int fnm1=tilingproblem(n-1);
        //choice is horizontal
        int fnm2= tilingproblem(n-2);
        int noofways=fnm1+fnm2;
        return noofways;
    }
    public static void main(String[] args) {
        System.out.println(tilingproblem(4));
        
    }
}
