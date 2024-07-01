public class Stringbuilder {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder("hello");
        sb.toString();// it changes a stringbuilder to string
        // the main difference between a string and stringbuilder is stringbuilder can be mutated i.e. edited whereas strins are immutable
        // for every change in string the orginal string is coppied and tehn the change is implemented.
        // but in stringBuilder orginal string can be edited using objectname.append() function
        StringBuilder sb1= new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            sb1.append(ch);// it append the string to the end of the string
        }
        System.out.println(sb1);
        
    
    }
}
