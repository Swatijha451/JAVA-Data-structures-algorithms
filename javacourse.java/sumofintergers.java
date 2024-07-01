import java.util.Scanner;

public class sumofintergers {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int oddSum=0;
        int evenSum=0;
        for(int i=3;i<n;i++){
            if(i%2==0){
                evenSum +=i;
            } 
            else{
                oddSum= oddSum+3+i;
            }

        }
        System.out.println(" even sum is "+evenSum);
        System.out.println("odd Sum is "+ oddSum);
        sc.close();


    }
}
