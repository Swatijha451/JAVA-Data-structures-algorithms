//given a m*n intefer grid where image [i][j] represents the pixel value of the image. you are also given three
//sr,sc,and color. You should perform a flood fil algorithm on the image starting from te pixel image[sr][sc]
//To perform a floood fill algorithm, consider the starting pixel, plus anyy pixels connected diametrically to 
// those pixel(aso with the same color) and so on. replece the aforementioned pixels wit color
public class GrapFoodFillAgorithm {
    public static void helper (int [][]image,int sr,int sc,int color,boolean visited[][],int orgColor){
        if (sr<0||sc<0||sr>=image.length||sc>=image[0].length||visited[sr][sc]||
        image[sr][sc]!=orgColor) {
            return;
        }
        //eft
        helper(image, sr, sc-1, color, visited, orgColor);
        //right
        helper(image, sr, sc+1, color, visited, orgColor);
        //up
        helper(image, sr-1, sc, color, visited, orgColor);
        //down
        helper(image, sr+1, sc, color, visited, orgColor);
    }
    public static int[][] floodFillAlgorithm(int [][]image,int startingRow,int startingCol,int color){
        boolean visited[][]=new boolean[image.length][image[0].length];
        helper(image, startingRow, startingCol, color, visited, image[startingRow][startingCol]);
        return image;
    }
    public static void main(String[] args) {
        int  image[][]={{1,1,1},{1,1,0},{1,0,1}};
        floodFillAlgorithm(image, 1, 1, 2);
        for ( int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.println(image[i][j]+" ");
            }
        }
    }
    
}
