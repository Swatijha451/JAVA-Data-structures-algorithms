import java.util.Scanner;

public class palindromeornot {
    public static boolean ispalindrome(int n){
        int rev=0;
        int number=n;
        while(number!=0){
            int remainder= number%10;
             rev=(rev*10)+remainder;
              number= number/10;
        }
        if(n!=rev){
            return false;
        }
        
        return true;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(ispalindrome(n));
        sc.close();
    }
}
