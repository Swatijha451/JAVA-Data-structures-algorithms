import java.util.Scanner;

public class Calculator{
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the opertor");
        System.out.println("chose from: +,-,/,*,%");
        final char operator= sc.next().charAt(0);
        System.out.println("Enter two numbers for operation");
        double a= sc.nextDouble();
        double b= sc.nextDouble();
        switch (operator) {
            case '+': System.out.println((a+b));
                
                break;
                
                case '-': System.out.println((a-b));
                break;
                case '/': System.out.println((a/b));
                break;
                case '*': System.out.println((a*b));
                break;
                case '%': System.out.println((a%b));
                break;
        
            default: System.out.println("invalid operator");
                
        }
        sc.close();
        

    }

    
}
