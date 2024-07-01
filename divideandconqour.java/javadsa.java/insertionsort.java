public class insertionsort {
    public static void insertionsortfunction(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];//curr is a temporary variable storing value
            int prev=i-1;//storing the address not the element prev is a address
            //finding current position to insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];// prev+1 means curr thusprev-- to get the previous position of i
                prev--;
            }
            //insertion
            arr[prev+1]=curr;
        }
    }
    public static void main(String[] args) {
        int arr[]={5,4,1,3,2};
        insertionsortfunction(arr);
        bubblesort.arrayprint(arr);
    }
}
