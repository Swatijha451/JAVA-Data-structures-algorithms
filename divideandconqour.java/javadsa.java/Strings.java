import java.util.*;
public class Strings {
    // function to check if the string is palindrome or not
    public static boolean ispalindrome(String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //declaration
        String str1="madam";//the str1 and str2 object of the class String is referring to  same abcd string in heap memory
        String str2= "abcd";

        String str= new String("abcd");// this str has formed a new string in the memory not referring th the above string
        //strings are immutable
        //input of string
        Scanner sc= new Scanner(System.in);
        String str3= sc.next();// for single word input
        String str4= sc.nextLine();// for many words
        // to find the length of the string;
        int len= str4.length();
        // we can concatenate to string just by adding plus '+' between two strings
        str1= str1+str2+str3+ str;
        System.out.println(str1); 
        System.out.println(ispalindrome(str1));
        sc.close();
        
    }
}
