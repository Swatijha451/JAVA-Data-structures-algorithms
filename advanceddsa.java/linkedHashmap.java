import java.util.*;
//ordered hashmap->it maintains the order of Insertion
//douby inked ist is used to implememt inked Hashmap  internally
//al the functions are available as in hashmap
//NUl keys are allowed
public class linkedHashmap {
public static void main(String[] args) {
    LinkedHashMap<String,Integer>lhm= new LinkedHashMap<>();
    lhm.put("India", 100);
    lhm.put("China", 150);
    lhm.put("US", 50);
    System.out.println(lhm);
}    
}
