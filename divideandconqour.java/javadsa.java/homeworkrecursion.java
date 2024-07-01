public class homeworkrecursion {
    public static void findoccurances(int arr[],int key,int idx){
        //base case
        if(idx==arr.length){
            return;
    }
    if(arr[idx]==key){
        System.out.print(idx+" ");

    }
     findoccurances(arr, key, idx+1);
        
    }
    static String arr[]={"zero","one","two","three","four","five","six","seven","eighht","nine"};
    public static void printwordsfornumber(int n){
        //base case
        if(n==0){
            return;
        }
        int lastdigit= n%10;
        printwordsfornumber(n/10);
        System.out.print(arr[lastdigit]+" ");

    }
    // count all the contigous substring og given string that stsrst and ends with the sme charachter
    public static int countsubstringsstatendsame(String str, int si,int ei, int n){
        //base cases
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;// in this case iot is an empty string
        }
        int count= countsubstringsstatendsame(str, si+1, ei,n-1)+countsubstringsstatendsame(str, si, ei-1,n-1)-countsubstringsstatendsame(str, si+1, ei-1,n-2);
        if(str.charAt(si)==str.charAt(ei)){
            count++;
        }
        return count;  

    }
    public static void main(String[] args) {
        
        String str= "abcab";
        int n= str.length();
        System.out.println(countsubstringsstatendsame(str, 0, n-1,n));
        
    }
}

