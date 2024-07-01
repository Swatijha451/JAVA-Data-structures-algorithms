import java.util.Scanner;

public class decimaltobinary {
    public static void DecToBin(int decnum){
        int myNum=decnum;
        int biNum=0;
        int pow=0;
        while(decnum>0){
            int rem= decnum%2;
            biNum=biNum+(rem*(int)Math.pow(10, pow));
            pow++;
            decnum=decnum/2;
        }
        System.out.println("the binary of "+myNum+" is "+biNum);

    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        DecToBin(n);
        sc.close();
    }
}
