//no duplicates,unorderded,Null is allowed
//Linked Hashset is ordered based on insertion, it is impemented by douby lined list
//tree Hashset is sorted in ascending order,Null vaues are bnot aowed because it has to sort intenally
import java.util.*;
public class hashset {
    public static void main(String[] args) {
        HashSet<String>cities=new HashSet<>();
        cities.add("kolkata");
        cities.add("mumbai");
        cities.add("delhi");
        System.out.println(cities);
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
