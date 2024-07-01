import java.util.Scanner;

public class factorialfunction {
    public static int factorial(int a){
        int fact=1;
        for(int i=1;i<=a;i++){
            fact= fact*i;
        }
        return fact;

    }
    public static int binomialcoefficient(int n,int r){
        int nfact= factorial(n);
        int rfact= factorial(r);
        int nrfact= factorial((n-r));
        int binom= nfact/(rfact*nrfact);
        return binom;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int binom=binomialcoefficient(a,b);
        System.out.println(binom);
        sc.close();
    }
}
