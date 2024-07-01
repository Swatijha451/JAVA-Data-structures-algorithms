import java.util.Scanner;

public class binarytodecimal {
    public static void BinToDec(int binum){
        int myNum= binum;
        int decimal=0;
        int pow=0;
        while(binum>0){
            int lastdigit= binum%10;
            decimal=decimal+(lastdigit*(int)Math.pow(2,pow));
            pow++;
            binum=binum/10;
        }
        System.out.println("decimal of "+myNum+" is "+decimal);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        BinToDec(n);
        sc.close();
        
    }
}
