
public class largestnumberinarray {
    public static int smallestinarray(int arr[]){
        int smallest= Integer.MAX_VALUE;
        for(int i=0;i<=arr.length-1;i++){
        if(smallest>arr[i]){
            smallest=arr[i];
        }
    }
    return smallest;
} 
    public static int largestinarry(int arr[]){
        int largest= Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-1;i++){
            if(largest< arr[i]){
                largest=arr[i];

            }
        }
        return largest;
}

    public static void main(String[] args) {
         int arr[]= {1,2,4,5,6};

         int number= largestinarry(arr);
         System.out.println("the largest number is "+ number);
         int smallestNumber= smallestinarray(arr);
         System.out.println("the smallest is "+smallestNumber);
    }
}
