public class stingpemutation { //timecomplexity id O(n*n!)
    public static void pemutationString(String str,String perm, int index){
        //base case
        if(str.length()==0){
            System.out.println(perm);
            return;
        }
        //perm string stoing different permutations of str
        for(int i=0;i<str.length();i++){
            char currchar=str.charAt(i);//fo first char in str in first place
            //for other char in strin in fist place removing first char
            // i is non inclusive thus first substring is empty in which other substrings are added
            String newstr= str.substring(0,i)+str.substring(i+1);
            //recusion
            pemutationString(newstr, perm +currchar, index+1);

        }
    }
    public static void main(String[] args) {
        String str= "ABC";
        pemutationString(str, "", 0);
    }
}
