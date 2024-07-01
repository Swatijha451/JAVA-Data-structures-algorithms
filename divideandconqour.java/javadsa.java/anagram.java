import java.util.*;
public class anagram {
    public static void isAnagram(String str1,String str2){
        // slowecse do that we dont have to check for it separately
        str1= str1.toLowerCase();
        str2= str2.toLowerCase();
        if(str1.length()==str2.length()){
            //if the size of the string s are same then only following condiTIONS ARE TRUE
            // convert the string into char arary
            char ch1[]= str1.toCharArray();
            char ch2[]= str2.toCharArray();
            // sort the array in ascending order using the inbuilt functions
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            boolean result=Arrays.equals(ch1,ch2);
            if(result){
                System.out.println("the strings are anagrams");
            } else{
                System.out.println("the strings are not equal");
            }


        }
        // when the lengthof the goven strings are not same
        else{
            System.out.println("the strings are not same");
        }
    }
    public static void main(String[] args) {
        String str1= "race";
        String str2="care";
        isAnagram(str1, str2);
    }
}
