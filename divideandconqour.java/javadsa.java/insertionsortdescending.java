public class insertionsortdescending {
    public static void insertiondescendingfunction(int arr[]){
        for(int i=0;i<arr.length;i++){
            int current=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]<current){
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1]=current;
        }
    }
    public static void main(String[] args) {
        int nums[]= {3,8,7,6,6,5,0,9};
        insertiondescendingfunction(nums);
        bubblesortdescending.printfunction(nums        );
    }
}
