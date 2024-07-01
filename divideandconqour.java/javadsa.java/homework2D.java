public class homework2D {
    //find the frequency of 7 in the goiven 2d
    public static int frequencyofkey(int matrix[][], int key){
        int frequency=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==key){
                    frequency++;
                }
                
            }
        }
        return frequency;
    }
    //sum of numbers in the second row of given array
    public static int sumofelements(int matrix[][]){
        int sum=0;
        
            for(int j=0;j<matrix[0].length;j++){
                
                    sum+=matrix[1][j];
                
            }

        
        return sum;

        
    }
    public static void main(String[] args) {
        int matrix[][]={{4,7,8},{8,7,8}};
        System.out.println(sumofelements(matrix));
    }
}
