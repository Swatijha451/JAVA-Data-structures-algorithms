import java.util.Scanner;

public class checkevenornot {
    public static boolean isEven(int n){
        if(n%2!=0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
          System.out.println(isEven(a));
        sc.close();
    }
}
