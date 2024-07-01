import java.util.Scanner;

public class halfpyramidofnumbers {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=1;i<=n;i++){// line nmber
            for(int j= 1;j<=i;j++){//the number
                System.out.print(j+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
