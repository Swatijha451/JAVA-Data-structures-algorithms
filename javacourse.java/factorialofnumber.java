import java.util.Scanner;

public class factorialofnumber {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        int factorial= 1;
        System.out.println("enter your number: ");
        int n= sc.nextInt();
        for(int i=1;i<=n;i++){
            factorial*=i;
        }
        System.out.println("the factorial of number is:" + factorial);
        sc.close();
    }
}
