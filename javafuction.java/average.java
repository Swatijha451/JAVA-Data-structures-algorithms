import java.util.Scanner;

public class average {
    public static double averageofNum(int a,int b,int c){
        double average=(a+b+c)/3;
        return average; 

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();
        System.out.println(averageofNum(a, b, c));
        sc.close();

    }
}
