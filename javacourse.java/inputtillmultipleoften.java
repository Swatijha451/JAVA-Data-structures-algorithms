import java.util.Scanner;

public class inputtillmultipleoften {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        do{
            System.out.println("enter yoiur number: ");
               int input= sc.nextInt();
                   if(input%10==0){
                       break;
                    }
            System.out.println(input);
        } while(true);
        sc.close();


    }
}
