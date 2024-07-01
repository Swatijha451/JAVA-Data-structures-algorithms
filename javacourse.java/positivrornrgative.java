import java.util.Scanner;

public class positivrornrgative {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
        if(a>=0){
            System.out.println("positive");
        }
        else{
            System.out.println("negative");
        }
        sc.close();
    }
}
