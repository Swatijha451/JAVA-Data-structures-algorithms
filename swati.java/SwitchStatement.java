import java.util.Scanner;

public class SwitchStatement {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int button= sc.nextInt();
        //switch case use
        switch (button) {
            case 1: System.out.println("Namaste");
                
                break;
            case 2: System.out.println("hello");
                break;
            case 3: System.out.println("Bonjour");
                break;
        
            default:System.out.println("Invalid button");
            
        }
        sc.close();
    }
}
