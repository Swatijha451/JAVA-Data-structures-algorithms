public class maxsuarraysumusinfkadanesalgorithm{
   
public static void kadanes(int arr[]){
    int maxsum= Integer.MIN_VALUE;
    int currsum=0;
    for(int i=0;i<arr.length;i++){
        currsum=currsum+arr[i];
        if(currsum<0){
            currsum=0;
        }
        maxsum= Math.max(maxsum, currsum);
    }
    System.out.println("the maxsum is: "+maxsum);

}   
 public static void main(String[] args) {
    int arr[]={-1,-2,-3,9,8,-3,5,3};
    kadanes(arr);
        
    }
}