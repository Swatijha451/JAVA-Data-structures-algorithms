public class linearsearch {
   public static int linearSearch(int arr[], int key){
    for (int i=0;i<=arr.length;i++) {
        if(arr[i]==key){
            return i;
        }    
    }
    return -1;//this return means the number we are searching does not exist
   }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,8,10,12};
        int findNumfromarr=10;
        int index= linearSearch(arr, findNumfromarr);
        if(index==-1){
            System.out.println(" the number is not present in array");
        }
        else{
            System.out.println("the number is present");
        }
    }
    
}
