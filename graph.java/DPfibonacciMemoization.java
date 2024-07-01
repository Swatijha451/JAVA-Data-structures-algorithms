//memoization of Dynamic Programming.  
public class DPfibonacciMemoization {
    public static int fib(int n,int []f){
        //base case
        if(n==0||n==1){
            return n;
        }
        if (f[n]!=0) {//if f[n] is calcukated
            return f[n];
        }
        f[n]=fib(n-1, f)+fib(n-2, f);
        return f[n];
    }
    public static void main(String[] args) {
        int n=8;
        int f[]=new int[n+1];
        System.out.println(fib(n, f));

    }
}
