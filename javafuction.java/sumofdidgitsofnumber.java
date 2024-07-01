import java.util.Scanner;

public class sumofdidgitsofnumber {
    public static int DigitSum(int n){
        int number=n;
        int sum=0;
        while (number>0) {
            int remainder=number%10;
            sum+=remainder;
            number/=10;
        }
        return sum;

        

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(DigitSum(n));
        sc.close();
    }
    
    
    
}
