//An anagram is a word or phrase formed bt rearranging the letters of a different word or phrase,typicay uding al the origina
//letters exactly once
import java.util.*;
public class hashmapVaidAnagram {
    public static boolean isAnagram(String s,String t){
        if (s.length()!=t.length()) {
            return false;//the ength of the strings are not equal
        }
        HashMap<Character,Integer>map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            //add 0 to the ma if the character exists and if it exists judt increae the frequenncy of the value
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for (int i = 0; i <t.length(); i++) {
            char ch=t.charAt(i);
            if (map.get(ch)!=null) {//word exists
                if (map.get(ch)==1) {
                    map.remove(ch);
                }
                else{
                    map.put(ch, map.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }
        return map.isEmpty();

    }
    public static void main(String[] args) {
        String s="cart";
        String t="race";
        System.out.println(isAnagram(s, t));
    }
}
