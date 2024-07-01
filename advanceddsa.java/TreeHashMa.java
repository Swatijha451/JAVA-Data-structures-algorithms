import java.util.*;
//key are sorted in ascending order alphabetically or numerically 
//all the function are O(log N)
//red Black trees are used to implement irt internally
//
public class TreeHashMa {
    public static void main(String[] args) {
        TreeMap<String,Integer>thm=new TreeMap<>();
        thm.put("India", 100);
        thm.put("Usa", 50);
        thm.put("China", 150);
        System.out.println(thm);
    }
}
