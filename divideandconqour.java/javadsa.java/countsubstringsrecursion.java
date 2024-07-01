public class countsubstringsrecursion {
    public static int countsubstrings(String str,int sidx,int eidx,int strlength){
        if(strlength==1){
            return 1;//if one character in string it will be the substring we are looking for
        }
        if(strlength<=0){
            return 0;
        }
        int result=countsubstrings(str, sidx+1, eidx, strlength-1)+countsubstrings(str, sidx, eidx-1, strlength-1)-countsubstrings(str, sidx+1, eidx-1, strlength-2);
        if(str.charAt(sidx)==str.charAt(eidx)){
            result++;
        }
        return result;


    }
    public static void main(String[] args) {
        String str="abcab";
        int n= str.length();
        System.out.print(countsubstrings(str,0,n-1,n));
    }
}
