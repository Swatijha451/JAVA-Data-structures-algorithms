import java.util.Scanner;

public class dontprintmultipleoften {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            do{
                System.out.println("enter your number:");
                int input= sc.nextInt();
                if(input%10==0){
                    continue;
                }
                System.out.println("the number was "+input);

            } 
            while(true);
        }

        
}

}

    

