public class spiralmatrix {
    public static void printspiral(int matrix[][]){
        int startrow=0;
        int startcolumn=0;
        int endrow=matrix.length-1;
        int endcolumn= matrix[0].length-1;
        while(startrow<=endrow && startcolumn<= endcolumn ){
            // top boundary row is fixed coulumn is variable
            for (int j=startcolumn;j<=endcolumn;j++){
                
                System.out.print(matrix[startrow][j]+" ");
            }
            // right boundary
            for(int i=startrow+1;i<=endrow;i++){
                
                System.out.print(matrix[i][endcolumn]+" ");
            }
            //bottomboundary
            for(int j=endcolumn-1;j>=startcolumn;j--){
                if(startrow==endrow){
                    break;// for odd numbers of column
                }
                               
                System.out.print(matrix[endrow][j]+" ");
            }
            //leftboundary
            for(int i=endrow-1;i>=startrow+1;i--){
                if(startcolumn==endcolumn){// for odd numbers of n*m
                    break;
                } 
            
                System.out.print(matrix[i][startcolumn]+" ");
            }
            startcolumn++;
            startrow++;
            endcolumn--;
            endrow--;

        }
        System.out.println();

    }
    public static void main(String[] args) {
        int matrx[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printspiral(matrx);
}
}
