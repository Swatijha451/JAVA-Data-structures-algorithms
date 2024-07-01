public class searchsortedtwoD {
    public static boolean staircaseapproach(int matrix[][],int key){
        int row= 0;
        int column= matrix[0].length-1;
        while(row<matrix.length && column>=0){
            if(matrix[row][column]==key){
                System.out.println("dound key at the index "+"("+row+","+column+")");
                return true;
            }
            else if(key<matrix[row][column]){
                column--;
            }
            else{
                row++;
            }

        }
        System.out.println("key not found");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][]= {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,29,50}};
        int key=33;
        staircaseapproach(matrix,key);
    }
}
