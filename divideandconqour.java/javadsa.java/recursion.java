public class recursion {
    public static void printinc(int n){
       //base case
       if(n==1){
        System.out.print(n+" ");
        return;
       }
       //function call
       printinc(n-1);
       //then print
        System.out.print(n+" ");
    }
    public static void printDec(int n){
        //base case
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        //kaam
        System.out.print(n+" ");
        //function call
        printDec(n-1);
        
    }
    public static int sumofnnatural(int n){
        if(n==1){
            return 1;
        }
        int sum= sumofnnatural(n-1);
        int sumfn= sum+n;
        return sumfn;
    }
    public static int factorial(int n){
        //base case
        if(n==0){
            
            return 1;
        }
        int factnminusone=factorial(n-1);// recursion
        int factorialofn= n*factnminusone;//the job
        return factorialofn;
    }
    public static int fibonacci(int n){//timecomplexity ==2powern which is really bad
        if(n==0||n==1){
            return n;
        }
        int fibn1=fibonacci(n-1);
        int fibn2= fibonacci(n-2);
        int fibN= fibn1+fibn2;
        return fibN;
    }
    public static boolean isSorted(int arr[],int i){
       //base case
       if(i==arr.length-1){
        return true;
       }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int searchinarray(int []arr,int key,int i){
        // base case
        
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
       return searchinarray(arr, key, i+1);

    }
    public static int lastoccuranceinarray(int arr[],int i,int key){
        //base case
        if(i==arr.length){
            return -1;//key does not ersist
        }
        int isfound= lastoccuranceinarray(arr, i+1, key);// if the key is present at i check with other elemments after i for more occurances
        if(isfound==-1&&arr[i]==key){// if there are no more occurances that is -1 then just retutn itself
            return i;
        }
        return isfound;// otherwise return isfound
    }
    public static int power(int n, int x){
        if(n==0){
            return 1;
        }
        return x*power(n-1, x);
    }
    public static int optimisedpowe(int x,int n ){
        //base case
        if(n==0){
            return 1;
        }
        //the work
        int halfpower= optimisedpowe(x, n/2);
        int halfpowesquare= halfpower*halfpower;
        if(n%2!=0){
            halfpowesquare=x*halfpowesquare;
        }
        return halfpowesquare;
    }
    public static void main(String[] args) {
        System.out.println(optimisedpowe(5, 2));
    }
}
