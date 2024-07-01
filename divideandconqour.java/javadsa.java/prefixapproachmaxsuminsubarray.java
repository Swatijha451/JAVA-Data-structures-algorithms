public class prefixapproachmaxsuminsubarray {
    public static void maxsubarraysumusingperfixarrayfuction(int arr[]){
        int maxsum= Integer.MIN_VALUE;
        int currsum=0;
        // create prefix array
        int prefix[]= new int [arr.length];
        //first element is gonig to be same as proginal array
        prefix[0]= arr[0];
        for(int i=1;i<prefix.length;i++){
            //calculating prefix
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            int start=i;
            for (int j=i;j<arr.length;j++){
                int end=j;

                currsum=start==0?prefix[end]:prefix[end]-prefix[start-1];
                if(maxsum<currsum){
                    maxsum=currsum;
                }
            }

        }
        System.out.println("maxsum is "+maxsum);

    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        maxsubarraysumusingperfixarrayfuction(arr);
        
    }
}
