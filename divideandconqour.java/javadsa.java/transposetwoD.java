public class transposetwoD {
    public static void printMatrix(int matrix[][]){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) {
        int matrix[][]={{2,5,7,9},{4,6,8,0}}; 
        printMatrix(matrix);
        //ttanspose
        int transpose[][]=new int [matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                transpose[j][i]=matrix[i][j];
            }
        }
        printMatrix(transpose);
 
      }
}
