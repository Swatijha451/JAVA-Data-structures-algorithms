
public class floydtriangle {
    public static void main(String[] args) {
        int number=1;
        int n=6;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(number+" ");
                number++;

            }
            System.out.println();
        }

    }
}
