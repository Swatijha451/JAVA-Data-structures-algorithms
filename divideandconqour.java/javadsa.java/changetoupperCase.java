public class changetoupperCase {//O(n)
    public static String fltoUppercase(String str){
        StringBuilder sb= new StringBuilder("");
        
            char ch= Character.toUpperCase(str.charAt(0));
            sb.append(ch);// addindg the uppercase letter at the end of sb
            for(int i=1;i<str.length();i++){
                if(str.charAt(i)==' ' && i<str.length()-1){
                    sb.append(str.charAt(i));// adding the empty space to stringbuilder sb
                    i++;
                    sb.append(Character.toUpperCase(str.charAt(i)));

                } else{
                    sb.append(str.charAt(i));// if the space is not there just add other words to the stringbuilder sb
                }
            }
            return sb.toString();
        }

    public static void main(String[] args) {
        String str= "my name is swati jha";
        System.out.println(fltoUppercase(str));
    }
    
}
