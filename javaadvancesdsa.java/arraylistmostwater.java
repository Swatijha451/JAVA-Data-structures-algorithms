import java.util.*;
public class arraylistmostwater {
    public static int maxwatercontainer(ArrayList<Integer>height){
        int maxwater=0;
        int left=0;
        int right=height.size()-1;
        while(left!=right){
            //calculate water
            int ht=Math.min(height.get(left),height.get(right));
            int width= right-left;
            int currwater=ht*width;
            maxwater= Math.max(maxwater, currwater);
            //update pointer
            if (height.get(left)<height.get(right)) {
                left++;
            } else{
                right--;
            }
        }
        return maxwater;
    }
    //O(n) approach -> 2 pointer approach
    public static void main(String[] args) {
        ArrayList<Integer>height= new ArrayList<>();
        height.add(1);height.add(8);height.add(6);height.add(2);
        height.add(5);height.add(4);height.add(8);height.add(3);height.add(7);
        System.out.print(maxwatercontainer(height));

    }
}
