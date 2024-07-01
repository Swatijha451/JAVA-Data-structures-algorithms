import java.util.*;
public class hashingLargestSubarrywit0sum {
    public static void main(String[] args) {
        int arr[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer>map= new HashMap<>();
        int sum=0;
        int lenght=0;
        for (int j = 0; j < arr.length; j++) {
           sum+=arr[j];
           if (map.containsKey(sum)) {
            lenght=Math.max(lenght, j-map.get(sum));
           } 
           else{
            map.put(sum, j);
           }
        }
        System.out.println("the largset subarray sum  0 is "+lenght);
    }
}
