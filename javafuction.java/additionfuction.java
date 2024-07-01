import java.util.Scanner;

public class additionfuction {
   public static int addition(int a, int b){
    int add= a+b;
    return add;
   }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int sum= addition(a,b);
        System.out.println("the sum is: "+sum);
        sc.close();
    
   } 
}
