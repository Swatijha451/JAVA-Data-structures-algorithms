import java.util.Scanner;

public class checkprimeornot {
   public static boolean isPrime(int n ){
    boolean isprime=true; 
    for(int i=2;i<=n-1;i++){
        if(n%i==0){
            isprime=false;
            break;
        }
    }
    return isprime;
}
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(isPrime(n));
        sc.close();
        
    }
}
