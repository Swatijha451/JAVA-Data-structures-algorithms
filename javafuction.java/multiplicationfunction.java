import java.util.Scanner;

public class multiplicationfunction {
    public static void multiply(int a,int b){
        System.out.println("the product is:"+(a*b));
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        multiply(a,b);
        sc.close();
    }
}
