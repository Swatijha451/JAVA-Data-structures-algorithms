//Given an Integer array of size n,find all elements that appear maximum time

import java.util.HashMap;
import java.util.Set;

public class MajorityEament {
    public static void main(String[] args) {
        int arr[]={1,3,2,3,1,3,3,5,1};
        HashMap<Integer,Integer>map= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);//increses the frequency 
            }
            else{
                map.put(arr[i], 1);//add the key and its frequency 1
            }
        }
        Set<Integer>keyset= map.keySet();
        for (Integer key : keyset) {
            if (map.get(key)>arr.length/3) {
                System.out.println(key);
            }
        }
    }
    
}
  