import java.util.Scanner;

public class multiplicationtable {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter your number:");
        int n= sc.nextInt();
        int product;
        for(int i=1;i<=10;i++){
            product=n*i;
            System.out.println(i+"* "+n+"= "+product);

        }
        sc.close();
    }
}
