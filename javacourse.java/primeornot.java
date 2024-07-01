import java.util.Scanner;

public class primeornot {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter your number:");
         int n= sc.nextInt();
         boolean yourn= true;// boolean variable that only takes true and false
        // for (int i = 2;i < n-1; i++) {
            for(int i=2;i<Math.sqrt(n);i++){ // more optimised root n method
            if(n%i==0){// it has a variable other than 1 and itself thus not prime
                yourn= false;   
            }  
         }
         if(yourn==true){
            System.out.println(" your number is prime");
         }
          else{
            System.out.println("your numb er is not prime");

         }
         sc.close();
    }
}
