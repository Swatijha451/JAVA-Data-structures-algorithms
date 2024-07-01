public class substrings {
    public static String printsubstrings(String str,int startindex,int endingindex){
        String substr="";
        for(int i=startindex;i<=endingindex;i++){
            substr+=str.charAt(i);

        }
        return substr;
    }
    public static void main(String[] args) {
        String str="mynameisswatijha";
        int startindex=3;
        int endindex=9;
        System.out.println(printsubstrings(str, startindex, endindex));

    }
}
