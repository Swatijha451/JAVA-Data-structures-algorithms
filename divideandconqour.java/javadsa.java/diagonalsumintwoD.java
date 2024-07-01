public class diagonalsumintwoD {
   public static int diagonalsum(int matrix[][]){
    int sum=0;
    //brute force method
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<matrix[0].length;j++){
            //for primary diagonal
            if(i==j){
                sum+=matrix[i][j];

            }
            else if(i+j==matrix.length-1){
                sum+=matrix[i][j];

            }
        }
    }
    return sum;

   } 
   public static int moreoptimised(int matrix[][]){
    int sum=0;
    for(int i=0;i<matrix.length;i++){
        //fpr primary diagonal wgere i=j
        sum+=matrix[i][i];
        //for secondary diagonal where i+j=n-1
        if(i!=matrix.length-1-i){
            sum+=matrix[i][matrix.length-1-i];
        }
    }
    return sum;
   }
   public static void main(String[] args) {
    int matrix[][]={{1,2,3,4},{5,6,7,8,9},{10,11,12,13},{14,15,16,17}};
    System.out.println(moreoptimised(matrix));
   }
}
